package com.hibernate.association.test.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY_BRANCH_DETAILS")
public class Branch {

	@Id
	@GeneratedValue
	@Column(name = "BRANCH_ID")
	private int branchId;

	@Column(name = "BRANCH_NAME")
	private String branchName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "C_ID")
	private PCompany company;

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public PCompany getCompany() {
		return company;
	}

	public void setCompany(PCompany company) {
		this.company = company;
	}

}
