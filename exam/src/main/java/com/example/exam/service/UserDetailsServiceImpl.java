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
import org.springframework.stereotype.Component;

import com.example.exam.dao.UserDaoImpl;
import com.example.exam.model.Question;
import com.example.exam.model.Test;

@Component(value = "userDetailService")
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



	private static void populateSampleDB() {
		Question q1 = new Question("Sample Description1", "op1", "op2", "op3", "op4", "op1" );
		Question q2 = new Question("Sample Description2", "op1", "op2", "op3", "op4", "op1" );
		Question q3 = new Question("Sample Description3", "op1", "op2", "op3", "op4", "op1" );
		Question q4 = new Question("Sample Description4", "op1", "op2", "op3", "op4", "op1" );
		Question q5 = new Question("Sample Description5", "op1", "op2", "op3", "op4", "op1" );
		Question q6 = new Question("Sample Description6", "op1", "op2", "op3", "op4", "op1" );
		HashSet<Question> questions = new HashSet<Question>();
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		questions.add(q4);
		questions.add(q5);
		questions.add(q6);
		
		
		Test test = new Test();
		test.setName("Test 1");
		test.setYear("2020");
		test.setQuestions(questions);
		
		Test test2 = new Test();
		test2.setName("Test 1");
		test2.setYear("2020");
		
		
		SessionFactory  sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.save(test);
		session.save(test2);
		
		 
	}
	

}