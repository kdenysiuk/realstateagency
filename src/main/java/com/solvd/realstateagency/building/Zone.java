package com.solvd.realstateagency.building;

public class Zone {
	private String zoneName;
	private boolean zoneYard;
	private int zonePrice = 1;
	private int zoneYardPrice = zonePrice / 3;
	
	//constructor
	public Zone(String zoneName, int zonePrice) {
		this.zoneName = zoneName;
		this.zonePrice = zonePrice;
	}
	
	//setters
	public void setZoneName(String zonePrice) {
		this.zoneName = zonePrice;
	}
	public void setZoneYard(boolean zoneYard) {
		this.zoneYard = zoneYard;
	}
	public void setZonePrice(int zonePrice) {
		this.zonePrice = zonePrice;
	}
	public void setZone(int zoneYardPrice) {
		this.zoneYardPrice = zoneYardPrice;
	}
	
	//getters
	public String getZoneName() {
		return zoneName;
	}
	public boolean getZoneYard() {
		return zoneYard;
	}
	public int getZonePrice() {
		return zonePrice;
	}
	public int getZoneYardPrice() {
		return zoneYardPrice;
	}
	
}
