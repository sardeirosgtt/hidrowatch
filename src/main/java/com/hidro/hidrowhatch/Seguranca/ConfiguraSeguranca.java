package com.hidro.hidrowhatch.Seguranca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.w3c.dom.css.CSSFontFaceRule;

@Configuration
@EnableWebSecurity
public class ConfiguraSeguranca {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.csrf(csfr-> csfr.disable())
				.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
	}
}
