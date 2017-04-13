package com.springboot.dao;

import java.util.List;
import java.util.Map;

import com.springboot.model.RuleMaster;

public interface RuleMasterDao {

	public void save(RuleMaster ruleMasterObj);
	
	public List<RuleMaster> list();

	public List<String> getColSpecificData(String colName);
	
	public RuleMaster getRuleMasterObj(int ruleMasterId);
	
	public void update(RuleMaster ruleMasterObj);
	
	public void delete(RuleMaster ruleMasterObj);
}
