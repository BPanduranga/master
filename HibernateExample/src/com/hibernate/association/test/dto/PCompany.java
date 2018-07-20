package com.hibernate.association.test.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "P_COMPANY_DETAILS")
public class PCompany {

	@Id
	@Column(name = "COMPANY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int companyId;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	// @JoinTable(name = "C_B_DETAILS", joinColumns = @JoinColumn(name = "C_ID"),
	// inverseJoinColumns = @JoinColumn(name = "B_ID"))
	private Collection<Branch> branches = new ArrayList<>();

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Collection<Branch> getBranches() {
		return branches;
	}

	public void setBranches(Collection<Branch> branches) {
		this.branches = branches;
	}
}
