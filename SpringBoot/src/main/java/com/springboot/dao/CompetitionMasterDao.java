package com.springboot.dao;

import java.util.List;

import com.springboot.model.CompetitionMaster;

public interface CompetitionMasterDao {
	
	public void save(CompetitionMaster compititionMasterObj);

	public void update(CompetitionMaster compititionMasterObj);
	
	public void delete(CompetitionMaster compititionMasterObj);
	
	public List<CompetitionMaster> list();
	
	public CompetitionMaster getCompititionMasterDetails(int id);

}
