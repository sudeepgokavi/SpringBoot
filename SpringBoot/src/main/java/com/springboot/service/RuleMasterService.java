package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.RuleMasterDao;
import com.springboot.model.RuleMaster;

@Service
public class RuleMasterService {

	@Autowired
	private RuleMasterDao ruleMasterDao;
	
	public void save(RuleMaster ruleMasterObj){
		this.ruleMasterDao.save(ruleMasterObj);
	}
	
	public List<RuleMaster> list(){
		return this.ruleMasterDao.list();
	}
}
