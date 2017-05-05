package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.CompetitionMasterDao;
import com.springboot.model.CompetitionMaster;

@Service
public class CompetitionMasterService {
	@Autowired
	CompetitionMasterDao competitionMasterDao;
	
	public void save(CompetitionMaster compititionMasterObj){
		this.competitionMasterDao.save(compititionMasterObj);
	}

	public void update(CompetitionMaster compititionMasterObj){
		this.competitionMasterDao.update(compititionMasterObj);
	}
	
	public void delete(CompetitionMaster compititionMasterObj){
		this.competitionMasterDao.delete(compititionMasterObj);
	}
	
	public List<CompetitionMaster> list(){
		return this.competitionMasterDao.list();
	}
	
	public CompetitionMaster getCompititionMasterDetails(int id){
		return this.competitionMasterDao.getCompititionMasterDetails(id);
	}
}
