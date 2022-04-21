package com.solvd.realstateagency.building;

public enum Zone {
	DOWNTOWN("downtown area", 750), 
	RESIDENTIAL("residential area", 500), 
	SURBURBAN("surburban area", 250);

	private final String zone;
	private final double price;

	private Zone(String zone, double price) {
		this.zone = zone;
		this.price = price;
	}

}

/*
 * public class Zone { private String zoneName; private boolean zoneYard;
 * private int zonePrice = 1; private int zoneYardPrice = zonePrice / 3;
 * 
 * //constructor public Zone(String zoneName, int zonePrice) { this.zoneName =
 * zoneName; this.zonePrice = zonePrice; }
 * 
 * //setters public void setZoneName(String zonePrice) { this.zoneName =
 * zonePrice; } public void setZoneYard(boolean zoneYard) { this.zoneYard =
 * zoneYard; } public void setZonePrice(int zonePrice) { this.zonePrice =
 * zonePrice; } public void setZone(int zoneYardPrice) { this.zoneYardPrice =
 * zoneYardPrice; }
 * 
 * //getters public String getZoneName() { return zoneName; } public boolean
 * getZoneYard() { return zoneYard; } public int getZonePrice() { return
 * zonePrice; } public int getZoneYardPrice() { return zoneYardPrice; }
 * 
 * }
 */
