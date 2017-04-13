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
	
	public List<String> getColSpecificData(String colName) {
		return this.ruleMasterDao.getColSpecificData(colName);
	}
	
	public RuleMaster getRuleMasterObj(int ruleMasterId){
		return this.ruleMasterDao.getRuleMasterObj(ruleMasterId);
	}
	
	public void update(RuleMaster ruleMasterObj){
		this.ruleMasterDao.update(ruleMasterObj);
	}
	
	public void delete(RuleMaster ruleMasterObj){
		this.ruleMasterDao.delete(ruleMasterObj);
	}
	
}
