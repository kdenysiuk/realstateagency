package com.solvd.realstateagency.building;

public class House extends Building {
	private boolean hasHouseYard;

	public House(int hID, String adress, int superface) {
		super(hID, adress, superface);
	}

	//setters
	public void setHasHouseYard(boolean hasHouseYard) {
		this.hasHouseYard = hasHouseYard;
	}
	
	//getters
	public boolean getHasHouseYard() {
		return hasHouseYard;
	}
	
}
