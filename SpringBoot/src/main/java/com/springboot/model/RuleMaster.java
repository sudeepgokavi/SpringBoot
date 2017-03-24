package com.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RULE_MASTER")
public class RuleMaster {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String ruleName;
	private String ruleType;
	private String rulePriority;
	private String ruleStatus;
	private String ruleDesc;
	private int rulePoints;

	public RuleMaster() {

	}

	public RuleMaster(int id, String ruleName, String ruleType, String rulePriority, String ruleStatus, String ruleDesc,
			int rulePoints) {
		super();
		this.id = id;
		this.ruleName = ruleName;
		this.ruleType = ruleType;
		this.rulePriority = rulePriority;
		this.ruleStatus = ruleStatus;
		this.ruleDesc = ruleDesc;
		this.rulePoints = rulePoints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getRulePriority() {
		return rulePriority;
	}

	public void setRulePriority(String rulePriority) {
		this.rulePriority = rulePriority;
	}

	public String getRuleStatus() {
		return ruleStatus;
	}

	public void setRuleStatus(String ruleStatus) {
		this.ruleStatus = ruleStatus;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public int getRulePoints() {
		return rulePoints;
	}

	public void setRulePoints(int rulePoints) {
		this.rulePoints = rulePoints;
	}

}
