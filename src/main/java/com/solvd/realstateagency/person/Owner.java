package com.solvd.realstateagency.person;

import java.util.ArrayList;
import com.solvd.realstateagency.util.CustomLinkedlist;
import com.solvd.realstateagency.building.Building;
import com.solvd.realstateagency.exception.InvalidAmountException;
import com.solvd.realstateagency.exception.InvalidNumberException;
import com.solvd.realstateagency.innterface.IBuyable;
import com.solvd.realstateagency.innterface.ISellable;

public class Owner extends Person implements IBuyable, ISellable {
	private int moneyAvailable;
	CustomLinkedlist<Building> properties = new CustomLinkedlist<Building>();
	
	//constructor
	public Owner(int pID, String pName, String pTelephone) {
		super(pID, pName, pTelephone);
	}
	
	//setters
	public void setMoneyAvailable(int moneyAvailable) {
		if (moneyAvailable < 0) {
			throw new InvalidNumberException();
		}
		this.moneyAvailable = moneyAvailable;
	}
	
	//getters
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
	public void sell(int propertyPrice, int index) {
		moneyAvailable = moneyAvailable + propertyPrice;
		properties.removeElementAt(index);
	}

}
