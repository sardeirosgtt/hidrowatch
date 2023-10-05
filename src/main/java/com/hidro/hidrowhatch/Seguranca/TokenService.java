package com.hidro.hidrowhatch.Seguranca;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.hidro.hidrowhatch.model.Usuario;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;
	
	public String generetedToken(Usuario usuario) {
		try {
			Algorithm algorithm =  Algorithm.HMAC256(secret);
			String token = JWT.create()
					.withIssuer("hidrowatch")
					.withSubject(usuario.getEmail())
					.withExpiresAt(genExpirationDate())
					.sign(algorithm);
			return token;
		} catch (JWTCreationException e ) {
			throw new RuntimeException("Erro ao gerar o Token", e);
		}
	}
	
	
	
	public String validateToken(String token) {
		try {
			Algorithm algorithm =  Algorithm.HMAC256(secret);
		return JWT.require(algorithm)
				.withIssuer("hidrowatch")
				.build()
				.verify(token)
				.getSubject();
		} catch (JWTCreationException e) {
			return "";
		}
		
	}
	
	
	private Instant genExpirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}

}
