package com.solvd.realstateagency.company;

import com.solvd.realstateagency.building.Building;
import com.solvd.realstateagency.exception.InvalidAmountException;
import com.solvd.realstateagency.exception.InvalidNumberException;
import com.solvd.realstateagency.innterface.IBuy;
import com.solvd.realstateagency.innterface.ISell;
import com.solvd.realstateagency.util.CustomLinkedlist;

public class Company implements IBuy, ISell {
	private int CUIT;
	private String pName;
	private String pTelephone;
	private double moneyAvailable;
	CustomLinkedlist<Building> properties = new CustomLinkedlist<Building>();

	//constructor
	public Company (int CUIT, String pName, String pTelephone) {
		this.CUIT = CUIT;
		this.pName = pName;
		this.pTelephone = pTelephone;
	}
	
	//setters
	public void setMoneyAvailable(int moneyAvailable) throws InvalidNumberException {
		if (moneyAvailable < 0) {
			throw new InvalidNumberException();
		}
		this.moneyAvailable = moneyAvailable;
	}
	public void setPID(int pID) {
		this.CUIT = pID;
	}
	public void setPName(String pName) {
		this.pName = pName;
	}
	public void setPTelephone(String pTelephone) {
		this.pTelephone = pTelephone;
	}

	//getters
	public int getCUIT() {
		return CUIT;
	}
	public String getPName() {
		return pName;
	}
	public String getPTelephone() {
		return pTelephone;
	}
	public double getMoneyAvailable() {
		return moneyAvailable;
	}
	
	@Override
	public void buy(Building property) {
		if (moneyAvailable < property.getSalePrice()) {
			throw new InvalidAmountException();
		} 
		moneyAvailable = moneyAvailable - property.getSalePrice();
		properties.addElement(property);
	}
	
	@Override
	public void sell(int propertyPrice, int index) {
		moneyAvailable = moneyAvailable + propertyPrice;
		properties.removeElementAt(index);
	}

}
