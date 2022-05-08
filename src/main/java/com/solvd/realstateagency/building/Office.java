package com.solvd.realstateagency.building;

public class Office extends Building {
	private boolean multiOffice;
	
	public Office(int hID, String address, int surface) {
		super(hID, address, surface);
	}
	
	//setters
	public void setMultiOffice(boolean multiOffice) {
		this.multiOffice = multiOffice;
	}
	
	//getters
	public boolean getUniqueOffice() {
		return multiOffice;
	}
	
}
