package com.orion10110.training.managertaxi.services.aspect;

import java.lang.reflect.Method;
import java.util.List;

import javax.inject.Inject;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.AbstractModel;
/**
 * Кэширование списка объектов по "одному"
 * 
 * @author Калач Артур
 *
 */
@Aspect
@Component
public class CacheAspect {
	/**
	 * Кэш менеджер приложения
	 */
	@Inject
	private CacheManager cacheManager;
	/**
	 * Контекст spring
	 */
	@Autowired
	private ApplicationContext context;
	
	/**
	 * Получение списка объектов и кеширование по одиночке
	 * @param joinPoint предоставляет информацию метода метод, выполнение метода
	 * @param cacheList PointCut анотация
	 * @return	Кэшируемы список
	 * @throws Throwable
	 */
	@Around("@annotation(cacheList)")
	public List cacheListVal(ProceedingJoinPoint joinPoint, CacheList cacheList) throws Throwable {
		String keyGenerator = cacheList.keyGenerator(); //Получение генератора ключей
		String cacheName = cacheList.value(); //Получение имени кэша
		Cache cache = cacheManager.getCache(cacheName); //Получение кэша из менеджера
		String listKey = joinPoint.getTarget().getClass().getSimpleName(); //Имя класса для хранения
		KeyGenerator keyGen = (KeyGenerator) context.getBean(keyGenerator); //Получение генератора ключей из контекста спринга
		ValueWrapper listCache = cache.get(listKey);//Получение кэша (списка объектов)
		List<AbstractModel> list; 
		if (listCache == null) {	//Проверка на пустату кэша
			list = (List) joinPoint.proceed(); //получение списка объектов 
			cache.put(listKey, list);	//Запись списка в кэш
			for (AbstractModel object : list) {	//Запись объектов по одному
				String name = (String) keyGen.generate(object, null, object);
				cache.put(name, object);
			}
		} else { //Иначе берем значение кэша
			list = (List) listCache.get(); 
		}

		return list;
	}

	
	/**
	 * Запись одиночного объекта в кэш лист
	 * @param joinPoint предоставляет информацию метода
	 * @param retVal предоставляет объект записанный в хранилище
	 * @param listCachePut PointCut анотация
	 */
	@AfterReturning(value = "@annotation(listCachePut)", returning = "retVal")
	public void putAfter(JoinPoint joinPoint, AbstractModel retVal, ListCachePut listCachePut){
		if(retVal==null){ //Если объект пустой то выходим
			return;
		}
		String cacheName = listCachePut.value();
		Cache cache = cacheManager.getCache(cacheName);
		String listKey = joinPoint.getTarget().getClass().getSimpleName();
		ValueWrapper listCache = cache.get(listKey);
		List<AbstractModel> list;
		AbstractModel abstractModel = null;
		if (listCache != null) { //Проверка на пустату кэша
			list = (List<AbstractModel>) listCache.get(); //Получение всех эллементов
			abstractModel = list.stream().filter(p -> p.getId() == retVal.getId()).findAny().orElse(null); //Поиск кэшируемого эллемента
		} else {
			return;
		}

		AbstractModel addedAbstract = retVal;
		if (abstractModel == null) {//Проверка если объект в базе
			list.add(retVal); //Если нету добавляем в кэш списка
		} else {	//иначе обновляем
			int index = list.indexOf(abstractModel); 
			list.set(index, retVal);

		}
		cache.put(listKey, list); //сохраняем в кэш

	}
	/**
	 * Удаление эллемента в списке кэша
	 * @param joinPoint предоставляет информацию метода
	 * @param retVal предоставляет id объекта
	 * @param listCacheEvict PointCut анотация
	 */
	@AfterReturning(value = "@annotation(listCacheEvict)", returning = "retVal")
	public void evictAfter(JoinPoint joinPoint, long retVal, ListCacheEvict listCacheEvict) {
		String cacheName = listCacheEvict.value();
		Cache cache = cacheManager.getCache(cacheName);
		String listKey = joinPoint.getTarget().getClass().getSimpleName();
		ValueWrapper listCache = cache.get(listKey);
		List<AbstractModel> list;
		AbstractModel abstractModel = null;
		if (listCache != null) {
			list = (List<AbstractModel>) listCache.get();
			abstractModel = list.stream().filter(p -> p.getId() == retVal).findAny().orElse(null);
		} else {
			return;
		}
		if (abstractModel == null) {
			return;
		} else {
			list.remove(abstractModel); //удаление из списка объекта

		}
		cache.put(listKey, list); //Сохранение списка

	}

	/*
	 * @Pointcut("execution(public * *(..)) && @annotation(cacheList)") public
	 * void performance(CacheList cacheList) { }
	 */

	// @After("@annotation(cacheList)")
	// public void logAfter(JoinPoint joinPoint, CacheList cacheList) {
	//
	// MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	// Method method = signature.getMethod();
	//
	// CacheList cacheListAnotation = method.getAnnotation(CacheList.class);
	// String keyGenerator = cacheListAnotation.keyGenerator();
	// String cacheName[] = cacheListAnotation.value();
	// for (String cashe : cacheName) {
	// System.out.println(cashe);
	// }
	// System.out.println(keyGenerator);
	// System.out.println(joinPoint.getTarget().getClass().getSimpleName());
	// System.out.println("hijacked : " + joinPoint.getSignature().getName());
	// System.out.println("******");
	//
	// }
	//
	// @Before("@annotation(cacheList)")
	// public void logBefore(JoinPoint joinPoint, CacheList cacheList) {
	//
	// System.out.println("logBefore() is running!");
	// System.out.println("hijacked : " + joinPoint.getSignature().getName());
	// System.out.println("******");
	// }

}
