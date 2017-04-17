package com.springboot.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	public CompetitionMaster() {
	}

	
	
	public CompetitionMaster(int id, String competitionName, String competitionDetails, String competitionRules,
			String competitionStatus, int competitionPoints, Date competitionStartDate, Date competitionEndDate,
			String competitionOwner, String competitionPrize) {
		super();
		this.id = id;
		this.competitionName = competitionName;
		this.competitionDetails = competitionDetails;
		this.competitionRules = competitionRules;
		this.competitionStatus = competitionStatus;
		this.competitionPoints = competitionPoints;
		this.competitionStartDate = competitionStartDate;
		this.competitionEndDate = competitionEndDate;
		this.competitionOwner = competitionOwner;
		this.competitionPrize = competitionPrize;
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

}
