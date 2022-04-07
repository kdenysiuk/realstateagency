package com.solvd.realstateagency.person;

public class Person {
	private int pID;
	private String pName;
	private String pTelephone;
	
	//constructor
	public Person (int pID, String pName, String pTelephone) {
		this.pID = pID;
		this.pName = pName;
		this.pTelephone = pTelephone;
	}
	//setters
	public void setPID(int pID) {
		this.pID = pID;
	}
	public void setPName(String pName) {
		this.pName = pName;
	}
	public void setPTelephone(String pTelephone) {
		this.pTelephone = pTelephone;
	}
	//getters
	public int getPID() {
		return pID;
	}
	public String getPName() {
		return pName;
	}
	public String getPTelephone() {
		return pTelephone;
	}
}
