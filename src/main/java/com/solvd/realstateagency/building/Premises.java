package com.solvd.realstateagency.building;

public class Premises extends Building {
	private boolean industriesType;
	
	public Premises(int hID, String address, int surface) {
		super(hID, address, surface);
	}
	
	//setters
	public void setIndustriesType(boolean industriesType) {
		this.industriesType = industriesType;
	}
	
	//getters
	public boolean getIndustriesType() {
		return industriesType;
	}
	
}
