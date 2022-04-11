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
	

}
