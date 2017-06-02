package com.springboot.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPETITION_MASTER")
public class CompetitionMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String competitionName;
	private String competitionDetails;
	private String competitionRules;
	private String competitionStatus;
	private int competitionPoints;
	private Date competitionStartDate;
	private Date competitionEndDate;
	private String competitionOwner;
	private String competitionPrize;

	private String compContactPhone;
	private String compContactEmail;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="registeredUserId", nullable = false)
	private UserMaster userId;

	public CompetitionMaster() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompetitionName() {
		return competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	public String getCompetitionDetails() {
		return competitionDetails;
	}

	public void setCompetitionDetails(String competitionDetails) {
		this.competitionDetails = competitionDetails;
	}

	public String getCompetitionRules() {
		return competitionRules;
	}

	public void setCompetitionRules(String competitionRules) {
		this.competitionRules = competitionRules;
	}

	public String getCompetitionStatus() {
		return competitionStatus;
	}

	public void setCompetitionStatus(String competitionStatus) {
		this.competitionStatus = competitionStatus;
	}

	public int getCompetitionPoints() {
		return competitionPoints;
	}

	public void setCompetitionPoints(int competitionPoints) {
		this.competitionPoints = competitionPoints;
	}

	public Date getCompetitionStartDate() {
		return competitionStartDate;
	}

	public void setCompetitionStartDate(Date competitionStartDate) {
		this.competitionStartDate = competitionStartDate;
	}

	public Date getCompetitionEndDate() {
		return competitionEndDate;
	}

	public void setCompetitionEndDate(Date competitionEndDate) {
		this.competitionEndDate = competitionEndDate;
	}

	public String getCompetitionOwner() {
		return competitionOwner;
	}

	public void setCompetitionOwner(String competitionOwner) {
		this.competitionOwner = competitionOwner;
	}

	public String getCompetitionPrize() {
		return competitionPrize;
	}

	public void setCompetitionPrize(String competitionPrize) {
		this.competitionPrize = competitionPrize;
	}

	public String getCompContactPhone() {
		return compContactPhone;
	}

	public void setCompContactPhone(String compContactPhone) {
		this.compContactPhone = compContactPhone;
	}

	public String getCompContactEmail() {
		return compContactEmail;
	}

	public void setCompContactEmail(String compContactEmail) {
		this.compContactEmail = compContactEmail;
	}

	public UserMaster getUserId() {
		return userId;
	}

	public void setUserId(UserMaster userId) {
		this.userId = userId;
	}

}
