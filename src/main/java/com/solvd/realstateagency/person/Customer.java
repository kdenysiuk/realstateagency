package com.solvd.realstateagency.person;

import java.util.ArrayList;
import com.solvd.realstateagency.util.CustomLinkedlist;
import com.solvd.realstateagency.building.Building;
import com.solvd.realstateagency.exception.InvalidAmountException;
import com.solvd.realstateagency.exception.InvalidNumberException;
import com.solvd.realstateagency.innterface.IBuyable;
import com.solvd.realstateagency.innterface.IRent;

public class Customer extends Person implements IRent, IBuyable {
	private int salary;
	private int moneyAvailable;
	CustomLinkedlist<Building> properties = new CustomLinkedlist<Building>();
	
	
	//constructor
	public Customer(int pID, String pName, String pTelephone) {
		super(pID, pName, pTelephone);
	}
	
	//setters
	public void setSalary(int salary) {
		if (salary < 0) {
			throw new InvalidNumberException();
		}
		this.salary = salary;
	}
	public void setMoneyAvailable(int moneyAvailable) {
		if (moneyAvailable < 0) {
			throw new InvalidNumberException();
		}
		this.moneyAvailable = moneyAvailable;
	}
	
	//getters
	public int getSalary() {
		return salary;
	}
	public int getMoneyAvailable() {
		return moneyAvailable;
	}
	
	@Override
	public void buy(int propertyPrice, Building property) {
		if (moneyAvailable < propertyPrice) {
			throw new InvalidAmountException();
		} 
		moneyAvailable = moneyAvailable - propertyPrice;
		properties.addElement(property);
	}

	@Override
	public void rent() {
		System.out.println("I want to rent a property.");
	}
	
}
