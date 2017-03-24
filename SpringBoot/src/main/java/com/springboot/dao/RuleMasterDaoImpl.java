package com.springboot.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.RuleMaster;

@Repository
@Transactional
public class RuleMasterDaoImpl implements RuleMasterDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void save(RuleMaster ruleMasterObj) {
		sessionFactory.getCurrentSession().save(ruleMasterObj);
	}

}
