package com.example.exam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.exam.model.UserDetails;

@Component
public class UserDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDetails findUserById(String name) {
		Criteria criteria = sessionFactory.openSession().createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("name", name));
		List entityList =  criteria.list();
		
		UserDetails userDetails = null;
		if(!entityList.isEmpty()) {
			userDetails = (UserDetails) entityList.get(0);
		}
		return userDetails;
	}

	public void save(UserDetails user) {
		sessionFactory.openSession().save(user);
	}


}