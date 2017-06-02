package com.springboot.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPETITION_REGISTER_MASTER")
public class CompetitionRegisterMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int competitionId;
	private int registeredBy;
	private String teamName;
	private int teamSize;
	private String teamContactPh;
	private String teamContactEmail;
	private String teamGitHubLink;
	private Date registrationDate;
	private Date actualStartDate;
	private Date actualEndDate;
	private String developmentApproach;
	private double estimation;
	private String details;

	public CompetitionRegisterMaster() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
	}

	public int getRegisteredBy() {
		return registeredBy;
	}

	public void setRegisteredBy(int registeredBy) {
		this.registeredBy = registeredBy;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public String getTeamContactPh() {
		return teamContactPh;
	}

	public void setTeamContactPh(String teamContactPh) {
		this.teamContactPh = teamContactPh;
	}

	public String getTeamContactEmail() {
		return teamContactEmail;
	}

	public void setTeamContactEmail(String teamContactEmail) {
		this.teamContactEmail = teamContactEmail;
	}

	public String getTeamGitHubLink() {
		return teamGitHubLink;
	}

	public void setTeamGitHubLink(String teamGitHubLink) {
		this.teamGitHubLink = teamGitHubLink;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public String getDevelopmentApproach() {
		return developmentApproach;
	}

	public void setDevelopmentApproach(String developmentApproach) {
		this.developmentApproach = developmentApproach;
	}

	public double getEstimation() {
		return estimation;
	}

	public void setEstimation(double estimation) {
		this.estimation = estimation;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
