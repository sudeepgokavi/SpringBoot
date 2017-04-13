package com.springboot.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.UniqueConstraint;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

	public List<RuleMaster> list() {
		List<RuleMaster> ruleMasterObjList = sessionFactory.getCurrentSession().createCriteria(RuleMaster.class).list();
		return ruleMasterObjList;
	}


	public List<String> getColSpecificData(String colName) {
		List<String> colSpecificData = sessionFactory.getCurrentSession().createCriteria(RuleMaster.class)
				.setProjection(Projections.distinct(Projections.property(colName))).list();
		return colSpecificData;
	}

	public RuleMaster getRuleMasterObj(int ruleMasterId) {
		RuleMaster ruleMasterObj = (RuleMaster) sessionFactory.getCurrentSession().createCriteria(RuleMaster.class)
				.add(Restrictions.eq("id", ruleMasterId)).uniqueResult();
		return ruleMasterObj;
	}

	public void update(RuleMaster ruleMasterObj) {
		sessionFactory.getCurrentSession().update(ruleMasterObj);
	}

	public void delete(RuleMaster ruleMasterObj) {
		sessionFactory.getCurrentSession().delete(ruleMasterObj);
	}

}
