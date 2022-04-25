package com.solvd.realstateagency.person;

import com.solvd.realstateagency.util.CustomLinkedlist;
import com.solvd.realstateagency.building.Building;
import com.solvd.realstateagency.exception.InvalidAmountException;
import com.solvd.realstateagency.exception.InvalidNumberException;
import com.solvd.realstateagency.innterface.IBuyable;
import com.solvd.realstateagency.innterface.ISellable;

public class Owner extends Person implements IBuyable, ISellable {
	private double moneyAvailable;
	public CustomLinkedlist<Building> properties = new CustomLinkedlist<>();
	
	//constructor
	public Owner(int pID, String pName, String pTelephone) {
		super(pID, pName, pTelephone);
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
