package com.orion10110.training.managertaxi.services.aspect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.taximanager.datamodel.Brand;

@Aspect
@Component
public class CacheAspect {

	@Around("@annotation(cacheList)")
	public Object logAround(ProceedingJoinPoint joinPoint, CacheList cacheList) throws Throwable {
		  Object obj = joinPoint.proceed();
		  
		  
		  
		  
		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

		System.out.println("Around before is running!");
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		CacheList cacheListAnotation = method.getAnnotation(CacheList.class);
		String keyGenerator = cacheListAnotation.keyGenerator();
		String cacheName[] = cacheListAnotation.value();
		for (String cashe : cacheName) {
			System.out.println(cashe);
		}
		System.out.println(keyGenerator);
		System.out.println(joinPoint.getTarget().getClass().getSimpleName());
		List<AbstractModel> abstr = new ArrayList<AbstractModel>();
		abstr.add(new Brand());
		abstr.add(new Brand());
		abstr.add(new Brand());
		return (Object)abstr; // continue on the intercepted method

	}
	
	

	@Pointcut("execution(public * *(..)) && @annotation(cacheList)")
	public void performance(CacheList cacheList) {
	}

//	@After("@annotation(cacheList)")
//	public void logAfter(JoinPoint joinPoint, CacheList cacheList) {
//
//		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//		Method method = signature.getMethod();
//
//		CacheList cacheListAnotation = method.getAnnotation(CacheList.class);
//		String keyGenerator = cacheListAnotation.keyGenerator();
//		String cacheName[] = cacheListAnotation.value();
//		for (String cashe : cacheName) {
//			System.out.println(cashe);
//		}
//		System.out.println(keyGenerator);
//		System.out.println(joinPoint.getTarget().getClass().getSimpleName());
//		System.out.println("hijacked : " + joinPoint.getSignature().getName());
//		System.out.println("******");
//
//	}
//
//	@Before("@annotation(cacheList)")
//	public void logBefore(JoinPoint joinPoint, CacheList cacheList) {
//
//		System.out.println("logBefore() is running!");
//		System.out.println("hijacked : " + joinPoint.getSignature().getName());
//		System.out.println("******");
//	}

}
