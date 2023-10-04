package com.hidro.hidrowhatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hidro.hidrowhatch.repository.UsuarioRepository;

@Service
public class AuthorizationService implements UserDetailsService {

	
	@Autowired
	UsuarioRepository repositorio;
	
	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return repositorio.findByEmail(username);
	}

}

