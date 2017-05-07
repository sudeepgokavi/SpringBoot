package com.springboot.dao;

import java.util.List;

import com.springboot.model.UserMaster;

public interface UserMasterDao {

	public void save(UserMaster userMasterObj);
	
	public void update(UserMaster userMasterObj);
	
	public void delete(UserMaster userMasterObj);
	
	public List<UserMaster> list();
	
	public UserMaster getUserDetails(int id);
}
