package com.springboot.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.CompetitionMaster;

@Repository
@Transactional
public class CompetitionMasterDaoImpl implements CompetitionMasterDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(CompetitionMaster compititionMasterObj) {
		sessionFactory.getCurrentSession().save(compititionMasterObj);
	}

	public void update(CompetitionMaster compititionMasterObj) {
		sessionFactory.getCurrentSession().update(compititionMasterObj);
	}

	public void delete(CompetitionMaster compititionMasterObj) {
		sessionFactory.getCurrentSession().delete(compititionMasterObj);
	}

	public List<CompetitionMaster> list() {
		List<CompetitionMaster> compititionMasterList = sessionFactory.getCurrentSession()
				.createCriteria(CompetitionMaster.class).list();
		return compititionMasterList;
	}

	public CompetitionMaster getCompititionMasterDetails(int id) {
		CompetitionMaster compititionMasterObj = (CompetitionMaster) sessionFactory.getCurrentSession()
				.createCriteria(CompetitionMaster.class).add(Restrictions.eq("id", id)).uniqueResult();
		return compititionMasterObj;
	}

}
