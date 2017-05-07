package com.springboot.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.UserMaster;

@Repository
@Transactional
public class UserMasterDaoImpl implements UserMasterDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(UserMaster userMasterObj) {
		sessionFactory.getCurrentSession().save(userMasterObj);
	}

	public void update(UserMaster userMasterObj) {
		sessionFactory.getCurrentSession().update(userMasterObj);
	}

	public void delete(UserMaster userMasterObj) {
		sessionFactory.getCurrentSession().delete(userMasterObj);
	}

	public List<UserMaster> list() {
		List<UserMaster> userList = sessionFactory.getCurrentSession().createCriteria(UserMaster.class).list();
		return userList;
	}

	public UserMaster getUserDetails(int id) {
		UserMaster userMasterObj = (UserMaster) sessionFactory.getCurrentSession().createCriteria(UserMaster.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		return userMasterObj;
	}

}
