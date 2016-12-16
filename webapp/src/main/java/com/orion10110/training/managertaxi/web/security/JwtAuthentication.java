package com.orion10110.training.managertaxi.web.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.UserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;   
@Component
public class JwtAuthentication {
	public String createJWT( UserModel user, long ttlMillis) {
		 
	    //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	 
	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);
	 
	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("afasdfasdf");
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
	
	public UserModel parseJWT(String jwt) {
		 try{
	    //This line will throw an exception if it is not a signed JWS (as expected)
	    Claims claims = Jwts.parser()         
	       .setSigningKey(DatatypeConverter.parseBase64Binary("afasdfasdf"))
	       .parseClaimsJws(jwt).getBody();
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
