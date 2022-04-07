package com.solvd.realstateagency.building;

public class Premises extends Building {
	private boolean industriesType;
	
	public Premises(int hID, String adress, int superface) {
		super(hID, adress, superface);
	}
	
	//setters
	public void setIndustriesType(boolean industiresType) {
		this.industriesType = industiresType;
	}
	
	//getters
	public boolean getIndustriesType() {
		return industriesType;
	}
	
}
