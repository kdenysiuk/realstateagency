package com.solvd.realstateagency.building;

public class Apartment extends Building {
	private boolean uniqueRoom;

	public Apartment(int hID, String adress, int superface) {
		super(hID, adress, superface);
	}
	
	//setters
	public void setUniqueRoom(boolean uniqueRoom) {
		this.uniqueRoom = uniqueRoom;
	}
	
	//getters
	public boolean getUniqueRoom() {
		return uniqueRoom;
	}
	
}
