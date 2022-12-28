package com.netxssolutions.dto;

import java.util.Date;

public class Employee {
String name;
Date birthdate;
String address;
Byte gender;
Double salary;

public Employee(){}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Date getBirthdate() {
	return birthdate;
}

public void setBirthdate(Date birthdate) {
	this.birthdate = birthdate;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public Byte getGender() {
	return gender;
}

public void setGender(Byte gender) {
	this.gender = gender;
}

public Double getSalary() {
	return salary;
}

public void setSalary(Double salary) {
	this.salary = salary;
}


}
