package com.solvd.realstateagency.building;

public class House extends Building {
	private boolean hasHouseYard;

	public House(int hID, String address, int surface) {
		super(hID, address, surface);
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
