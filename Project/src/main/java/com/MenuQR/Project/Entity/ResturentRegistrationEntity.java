package com.MenuQR.Project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "resturent_registration_details")
public class ResturentRegistrationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String password;
	private String resturentName;
	private String address;
	private String city;
	private String zipCode;
	private String Number;
	private String ownerName;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResturentName() {
		return resturentName;
	}

	public void setResturentName(String resturentName) {
		this.resturentName = resturentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}
