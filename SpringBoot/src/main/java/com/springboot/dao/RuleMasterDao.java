package com.springboot.dao;

import java.util.List;

import com.springboot.model.RuleMaster;

public interface RuleMasterDao {

	public void save(RuleMaster ruleMasterObj);
	
	public List<RuleMaster> list();
}
