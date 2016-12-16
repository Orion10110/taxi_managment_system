package com.orion10110.training.managertaxi.web.security.aspect;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.training.managertaxi.services.aspect.CacheList;
import com.orion10110.training.managertaxi.services.aspect.ListCacheEvict;
import com.orion10110.training.managertaxi.services.aspect.ListCachePut;
import com.orion10110.training.managertaxi.services.components.UserDataStorage;
import com.orion10110.training.managertaxi.services.components.UserDataToken;
import com.orion10110.training.managertaxi.web.security.JwtAuthentication;

@Aspect
@Component
public class SecurityAspect {

	@Inject
	private CacheManager cacheManager;

	@Autowired
	private ApplicationContext context;

	@Inject
	private JwtAuthentication jwtAuthentication;

	// @Autowired
	// private UserDataToken userDataToken;

	@Around("@annotation(authAccess)")
	public ResponseEntity authAccess(ProceedingJoinPoint joinPoint, AuthAccess authAccess) throws Throwable {
		UserDataToken userDataToken = context.getBean(UserDataToken.class);
		if (!userDataToken.isLoggedIn()) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		ResponseEntity response = (ResponseEntity) joinPoint.proceed();
		return response;
	}
	@Around("@annotation(allowAnonymous)")
	public ResponseEntity allowAnonymous(ProceedingJoinPoint joinPoint, AllowAnonymous allowAnonymous) throws Throwable {
		UserDataToken userDataToken = context.getBean(UserDataToken.class);
		if (userDataToken.isLoggedIn()) {
			return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
		}
		ResponseEntity response = (ResponseEntity) joinPoint.proceed();
		return response;
	}
	@Around("@annotation(roleAccess)")
	public ResponseEntity roleAccess(ProceedingJoinPoint joinPoint, RoleAccess roleAccess) throws Throwable {
		UserDataToken userDataToken = context.getBean(UserDataToken.class);
		if (!userDataToken.isLoggedIn()) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		String role = roleAccess.value();
		String roleUser=userDataToken.getUserModel().getRole();
		if (roleUser==null || !role.equals(roleUser)) {
			return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
		}
		ResponseEntity response = (ResponseEntity) joinPoint.proceed();
		return response;
	}
	
	
	

}
