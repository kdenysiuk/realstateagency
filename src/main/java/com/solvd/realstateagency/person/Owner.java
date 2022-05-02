package com.solvd.realstateagency.person;

import com.solvd.realstateagency.util.CustomLinkedlist;
import com.solvd.realstateagency.building.Building;
import com.solvd.realstateagency.exception.InvalidAmountException;
import com.solvd.realstateagency.exception.InvalidNumberException;
import com.solvd.realstateagency.innterface.IBuy;
import com.solvd.realstateagency.innterface.ISell;

public class Owner extends Person implements IBuy, ISell {
	private double moneyAvailable;
	public CustomLinkedlist<Building> properties = new CustomLinkedlist<>();
	
	//constructor
	public Owner(int pID, String pName, String pTelephone) {
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
	public void setMoneyAvailable(int moneyAvailable) throws InvalidNumberException {
		if (moneyAvailable < 0) {
			throw new InvalidNumberException();
		}
		this.moneyAvailable = moneyAvailable;
	}
	
	//getters
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
