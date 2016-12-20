package com.orion10110.training.managertaxi.services.security;

import java.security.Key;

import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.UserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;   

/**
 * Работа с токеном
 * @author Калач Артур
 *
 */
@Component
public class JwtAuthentication implements TokenAuthentication{
	
	@Value("${key}")
	private String key;
	
	/**
	 * Создание токена для пользователя
	 * @param user пользователь
	 * @param ttlMillis время жизни
	 * @return токен
	 */
	public String create( UserModel user, long ttlMillis) {
		 
	    //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; //Алгоритм шифрования токена
	 
	    long nowMillis = System.currentTimeMillis();	//получение времеи
	    Date now = new Date(nowMillis);	//получение даты
	 
	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key); 
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	    //Let's set the JWT Claims
	    JwtBuilder builder = Jwts.builder().setId(user.getId().toString())
	                                .setIssuedAt(now)
	                                .setSubject(user.getUserName())
	                                .claim("role", user.getRole())
	                                .claim("email", user.getEmail())
	                                .signWith(signatureAlgorithm, signingKey);
	 
	    //if it has been specified, let's add the expiration
	    if (ttlMillis >= 0) {
	    long expMillis = nowMillis + ttlMillis;
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }
	 
	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	}
	/**
	 * Парсер токена
	 * @param token токен
	 * return информация пользователя
	 */
	public UserModel parse(String token) {
		 try{
	    //This line will throw an exception if it is not a signed JWS (as expected)
	    Claims claims = Jwts.parser()         
	       .setSigningKey(DatatypeConverter.parseBase64Binary(key))
	       .parseClaimsJws(token).getBody();
	    UserModel user = new UserModel();
	    user.setId(Long.parseLong(claims.getId()));
	    user.setEmail(toStringOrNull(claims.get("email")));
	    user.setRole(toStringOrNull(claims.get("role")));
	    user.setUserName(claims.getSubject());
	    return user;
	    }catch(JwtException | ClassCastException e){
	    	return null;
	    }
	}
	
	private String toStringOrNull(Object object){
		return (object == null) ? null : object.toString(); 
	}
	
	
}
