package com.solvd.realstateagency.building;

public class Office extends Building {
	private boolean multiOffice;
	
	public Office(int hID, String adress, int superface) {
		super(hID, adress, superface);
	}
	
	//setters
	public void setmultiOffice(boolean multiOffice) {
		this.multiOffice = multiOffice;
	}
	
	//getters
	public boolean getUniqueOffice() {
		return multiOffice;
	}
	
}
