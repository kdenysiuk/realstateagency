package com.solvd.realstateagency.building;

public class Building {
	private int hID;
	private String adress;
	protected double surface;
	private Zone zone;
	private double rentPrice;
	private double salePrice;
	
	//constructor
	public Building(int hID, String adress, double superface) {
		this.hID = hID;
		this.adress = adress;
		this.surface = superface;
	
	}
	
	//setters
	public void setHID(int hID) {
		this.hID = hID;
	}
	public void setAddress(String adress) {
		this.adress = adress;
	}
	public void setSurface(int surface) {
		this.surface = surface;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	/*
	 * public void setRentPrice(int rentPrice) { this.rentPrice = getSuperface() *
	 * getZoneName().getZonePrice(); } public void setSalePrice (double salePrice) {
	 * this.salePrice = salePrice; }
	 */

	//getters
	public int setHID() {
		return hID;
	}
	public double getSurface() {
		return surface;
	}
	public Zone getZone() {
		return zone;
	}
	public String getAddress() {
		return adress;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public double getSalePrice() {
		return salePrice;
	}

	public double calculatePrice(double zonePrice, double superface) {
		return zonePrice * superface;
	}

	public boolean getUniqueRoom() {
		return false;
	}
}

