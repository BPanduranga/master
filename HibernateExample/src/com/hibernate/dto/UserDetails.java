package com.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type = "long"))
	private Collection<Address> addresses = new ArrayList<Address>();

	/*
	 * @Embedded
	 * 
	 * @AttributeOverrides({
	 * 
	 * @AttributeOverride(name="city",column=@Column(name="OFFICE_CITY")),
	 * 
	 * @AttributeOverride(name="pin",column=@Column(name="OFFICE_PINCODE")),
	 * 
	 * @AttributeOverride(name="state",column=@Column(name="OFFICE_STATE")),
	 * 
	 * @AttributeOverride(name="country",column=@Column(name="OFFICE_COUNTRY")) })
	 * private Address officeAddress;
	 */
	// @Transient

	@OneToMany(mappedBy = "user")
	// @JoinTable(name="USER_COLLEGE_MAPPING",
	// joinColumns=@JoinColumn(name="USER_ID"),
	// inverseJoinColumns=@JoinColumn(name="COLLEGE_ID"))
	private List<College> college = new ArrayList<College>();

	@ManyToMany
	private Collection<Company> companies = new ArrayList<>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<Address> getAddress() {
		return addresses;
	}

	public void setAddress(Collection<Address> address) {
		this.addresses = address;
	}

	public List<College> getColleges() {
		return college;
	}

	public void setCollege(College college) {
		this.college.add(college);
	}

	public Collection<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Collection<Company> companies) {
		this.companies = companies;
	}

}
