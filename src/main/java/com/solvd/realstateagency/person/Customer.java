package com.solvd.realstateagency.person;

import com.solvd.realstateagency.util.CustomLinkedlist;
import com.solvd.realstateagency.building.Building;
import com.solvd.realstateagency.exception.InvalidNumberException;
import com.solvd.realstateagency.innterface.IRentable;

public class Customer extends Person implements IRentable {
	private int salary;
	public CustomLinkedlist<Building> properties = new CustomLinkedlist<>();

	//constructor
	public Customer(int pID, String pName, String pTelephone) {
		super(pID, pName, pTelephone);
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
	public void rent() {
		System.out.println("I want to rent a property.");
	}
	
}
