package com.solvd.realstateagency.person;

import com.solvd.realstateagency.exception.InvalidAmountException;
import com.solvd.realstateagency.util.CustomLinkedlist;
import com.solvd.realstateagency.building.Building;
import com.solvd.realstateagency.exception.InvalidNumberException;
import com.solvd.realstateagency.innterface.IRent;

public class Customer extends Person implements IRent {
	private int salary;
	public CustomLinkedlist<Building> properties = new CustomLinkedlist<>();

	//constructor
	public Customer(int pID, String pName, String pTelephone) {
		super(pID, pName, pTelephone);
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

	//setters
	public void setSalary(int salary) throws InvalidNumberException {
		if (salary < 0) {
			throw new InvalidNumberException();
		}
		this.salary = salary;
	}
	
	//getters
	public int getSalary() {
		return salary;
	}

	@Override
	public void rent(Building property) {
		if (salary * 0.5 < property.getRentPrice()) {
			throw new InvalidAmountException();
		}
		properties.addElement(property);
	}
	
}
