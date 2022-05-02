package com.solvd.realstateagency.person;

import com.solvd.realstateagency.innterface.IWork;

public class Employee extends Person {
	private int emplID;
	
	//constructor
	public Employee(int pID, int emplID, String pName, String pTelephone) {
		super(pID, pName, pTelephone);
		this.emplID = emplID;
	}
	
	//setters
	public void setEmplID(int emplID) {
		this.emplID = emplID;
	}
	
	//getters
	public int getEmplID() {
		return emplID;
	}


	@Override
	public void setPID(int pID) {
		this.pID = pID;
	}

	@Override
	public void setPName(String pName) {
		this.pName = pName;
	}

	@Override
	public void setPTelephone(String pTelephone) {
		this.pTelephone = pTelephone;
	}

	@Override
	public int getPID() {
		return pID;
	}

	@Override
	public String getPName() {
		return pName;
	}

	@Override
	public String getPTelephone() {
		return pTelephone;
	}
}
