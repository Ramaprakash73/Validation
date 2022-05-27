package com.slokam.rama.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PERSONS2")
public class persons2 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer personId;
	@Size(max=30,min=1)
	private String firstNmae;
	 @Size(max=30,min=1)
	private String lastName;
	private String address;
	//@NotNull
	@NotBlank
	private String city;
	
	
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getFirstNmae() {
		return firstNmae;
	}
	public void setFirstNmae(String firstNmae) {
		this.firstNmae = firstNmae;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	@Override
	public String toString() {
		return "persons2 [personId=" + personId + ", firstNmae=" + firstNmae + ", lastName=" + lastName + ", address="
				+ address + ", city=" + city + "]";
	}
	
	
	

}
