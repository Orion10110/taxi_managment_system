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

@Aspect
@Component
public class CacheAspect {

	@Inject
	private CacheManager cacheManager;

	@Autowired
	private ApplicationContext context;

	@Around("@annotation(cacheList)")
	public List cacheListVal(ProceedingJoinPoint joinPoint, CacheList cacheList) throws Throwable {

		Method method = getMehod(joinPoint);

		CacheList cacheListAnotation = method.getAnnotation(CacheList.class);
		String keyGenerator = cacheListAnotation.keyGenerator();
		String cacheName = cacheListAnotation.value();

		Cache cache = cacheManager.getCache(cacheName);

		String listKey = joinPoint.getTarget().getClass().getSimpleName();
		KeyGenerator keyGen = (KeyGenerator) context.getBean(keyGenerator);
		ValueWrapper listCache = cache.get(listKey);
		List<AbstractModel> list;
		if (listCache == null) {
			list = (List) joinPoint.proceed();
			cache.put(listKey, list);
			for (AbstractModel object : list) {
				String name = (String) keyGen.generate(object, null, object);
				cache.put(name, object);
			}
		} else {
			list = (List) listCache.get();
		}

		return list;
	}

	private Method getMehod(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		return method;
	}

	@AfterReturning(value = "@annotation(listCachePut)", returning = "retVal")
	public void putAfter(JoinPoint joinPoint, AbstractModel retVal, ListCachePut listCachePut) throws Throwable {

		Method method = getMehod(joinPoint);
		ListCachePut cacheListAnotation = method.getAnnotation(ListCachePut.class);
		String cacheName = cacheListAnotation.value();
		Cache cache = cacheManager.getCache(cacheName);
		String listKey = joinPoint.getTarget().getClass().getSimpleName();
		ValueWrapper listCache = cache.get(listKey);
		List<AbstractModel> list;
		AbstractModel abstractModel = null;
		if (listCache != null) {
			list = (List<AbstractModel>) listCache.get();
			abstractModel = list.stream().filter(p -> p.getId() == retVal.getId()).findAny().orElse(null);
		} else {
			return;
		}

		Object[] args = joinPoint.getArgs();
		AbstractModel addedAbstract = retVal;
		if (abstractModel == null) {

			list.add(retVal);
		} else {
			int index = list.indexOf(abstractModel);
			list.set(index, retVal);

		}
		cache.put(listKey, list);

	}

	@AfterReturning(value = "@annotation(listCacheEvict)", returning = "retVal")
	public void evictAfter(JoinPoint joinPoint, long retVal, ListCacheEvict listCacheEvict) throws Throwable {

		Method method = getMehod(joinPoint);
		ListCacheEvict cacheListAnotation = method.getAnnotation(ListCacheEvict.class);
		String cacheName = cacheListAnotation.value();
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
			list.remove(abstractModel);

		}
		cache.put(listKey, list);

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
