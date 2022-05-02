package com.solvd.realstateagency.person;

public abstract class Person {
	protected int pID;
	protected String pName;
	protected String pTelephone;
	
	//constructor
	public Person (int pID, String pName, String pTelephone) {
		this.pID = pID;
		this.pName = pName;
		this.pTelephone = pTelephone;
	}
	//setters
	public abstract void setPID(int pID);

	public abstract void setPName(String pName);

	public abstract void setPTelephone(String pTelephone);

	//getters
	public abstract int getPID();

	public abstract String getPName();

	public abstract String getPTelephone();
}
