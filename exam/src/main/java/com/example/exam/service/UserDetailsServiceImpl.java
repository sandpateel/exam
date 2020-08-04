package com.example.exam.service;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.exam.dao.UserDaoImpl;
import com.example.exam.model.Question;
import com.example.exam.model.Test;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserDaoImpl userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.example.exam.model.UserDetails userDB = userDao.findUserById(username);
		Set <GrantedAuthority> grantedAuthorities = new HashSet <> ();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));

        UserDetails user = new org.springframework.security.core.userdetails.User(userDB.getName(), userDB.getPassword(),
                grantedAuthorities);

		return user;
	}

	

}