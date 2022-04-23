package com.solvd.realstateagency.building;

public class Building {
	private int hID;
	private String adress;
	protected double superface;
	private Zone zone;
	private double rentPrice;
	private double salePrice;
	
	//constructor
	public Building(int hID, String adress, double superface) {
		this.hID = hID;
		this.adress = adress;
		this.superface = superface;
	
	}
	
	//setters
	public void setHID(int hID) {
		this.hID = hID;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public void setSuperface(int superface) {
		this.superface = superface;
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
	public double getSuperface() {
		return superface;
	}
	public Zone getZone() {
		return zone;
	}
	public String getAdress() {
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
	
}

