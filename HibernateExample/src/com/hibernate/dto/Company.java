package com.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY_DETAILS")
public class Company {

	@Id
	@Column(name = "COMPANY_ID")
	@GeneratedValue
	private int id;

	@Column(name = "COMPANY_NAME")
	private String companyName;
	@Column(name = "LOCATION")
	private String companyLocation;
	
	@ManyToMany(mappedBy="companies")
	private Collection<UserDetails> users = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

	public Collection<UserDetails> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserDetails> users) {
		this.users = users;
	}

}
