package com.example.exam.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.exam.dao.QuestionRepository;
import com.example.exam.jwt.JwtTokenUtil;
import com.example.exam.model.JwtRequest;
import com.example.exam.model.JwtResponse;
import com.example.exam.model.Question;
import com.example.exam.service.UserDetailsServiceImpl;

@RestController
public class ExamController {

	@Autowired 
	private AuthenticationManager authenticationManager;

	@Autowired 
	private JwtTokenUtil jwtTokenUtil;

	@Autowired 
	private UserDetailsServiceImpl userDetailsService;
	@Autowired 
	private QuestionRepository questionRepo;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST) 
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword()); 
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails); 
		return ResponseEntity.ok(new JwtResponse(token));

	}

	private void authenticate(String username, String password) throws Exception { 
		try { 
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)); 
		} catch (DisabledException e) { 
			throw new Exception("USER_DISABLED", e); 
		} catch (BadCredentialsException e) { 
			throw new Exception("INVALID_CREDENTIALS", e); 
		}

	}

	@RequestMapping({ "/hello" }) 
	public String firstPage() { 
        Pageable pageable = PageRequest.of(0, 5, Sort.by("statement"));

		return "Question count: "
		+  questionRepo.findAll(pageable).stream().map(Question::getQno).collect(Collectors.toList());
	}
	
	
	
}
