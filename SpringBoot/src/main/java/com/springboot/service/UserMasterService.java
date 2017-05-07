package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.UserMasterDao;
import com.springboot.model.UserMaster;

@Service
public class UserMasterService {

	@Autowired
	UserMasterDao userMasterDao;
	
	public void save(UserMaster userMasterObj){
		this.userMasterDao.save(userMasterObj);
	}
	
	public void update(UserMaster userMasterObj){
		this.userMasterDao.update(userMasterObj);
	}
	
	public void delete(UserMaster userMasterObj){
		this.userMasterDao.delete(userMasterObj);
	}
	
	public List<UserMaster> list(){
		return this.userMasterDao.list();
	}
	
	public UserMaster getUserDetails(int id){
		return this.userMasterDao.getUserDetails(id);
	}
}
