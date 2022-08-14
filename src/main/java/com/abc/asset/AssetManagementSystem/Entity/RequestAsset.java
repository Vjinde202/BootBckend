package com.abc.asset.AssetManagementSystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class RequestAsset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
	private String empName;
	private String role;
	private String assetRequired;
	private String address;
	private long contactNu;
	private String emailId;
	public RequestAsset() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestAsset(String empName, String role, String assetRequired, String address, long contactNu,
			String emailId) {
		super();
		this.empName = empName;
		this.role = role;
		this.assetRequired = assetRequired;
		this.address = address;
		this.contactNu = contactNu;
		this.emailId = emailId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAssetRequired() {
		return assetRequired;
	}
	public void setAssetRequired(String assetRequired) {
		this.assetRequired = assetRequired;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContactNu() {
		return contactNu;
	}
	public void setContactNu(long contactNu) {
		this.contactNu = contactNu;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	
	
	
	
	
	

	
}