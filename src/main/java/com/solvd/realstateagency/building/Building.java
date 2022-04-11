package com.solvd.realstateagency.building;

public class Building {
	private int hID;
	private String adress;
	protected int superface;
	private Zone zoneName;
	private int rentPrice;
	private double salePrice;
	
	//constructor
	public Building(int hID, String adress, int superface) {
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
	public void setZone(Zone zoneName) {
		this.zoneName = zoneName;
	}
	public void setRentPrice(int rentPrice) {
		this.rentPrice = getSuperface() * getZoneName().getZonePrice();
	}
	public void setSalePrice (double salePrice) {
		this.salePrice = salePrice;
	}

	//getters
	public int setHID() {
		return hID;
	}
	public int getSuperface() {
		return superface;
	}
	public Zone getZoneName() {
		return zoneName;
	}
	public String getAdress() {
		return adress;
	}
	public int getRentPrice() {
		return rentPrice;
	}
	public double getSalePrice() {
		return salePrice;
	}
	
	
}

