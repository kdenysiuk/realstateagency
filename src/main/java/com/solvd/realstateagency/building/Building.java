package com.solvd.realstateagency.building;

import com.solvd.realstateagency.main.Main;
import com.solvd.realstateagency.person.Customer;
import com.solvd.realstateagency.person.Owner;
import com.solvd.realstateagency.util.CustomLinkedlist;
import com.solvd.realstateagency.util.TransactionQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Building {
	private int hID;
	private String address;
	private double surface;
	private Zone zone;
	private double rentPrice;
	private double salePrice;
	private static final Logger LOGGER = LogManager.getLogger(Main.class);
	static Scanner input = new Scanner(System.in);
	public static CustomLinkedlist<Building> availableForYou = new CustomLinkedlist<>();
	
	//constructor
	public Building(int hID, String address, double surface) {
		this.hID = hID;
		this.address = address;
		this.surface = surface;
	
	}
	
	//setters
	public void setHID(int hID) {
		this.hID = hID;
	}
	public void setAddress(String address) {
		this.address = address;
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
		return address;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public double getSalePrice() {
		return salePrice;
	}

	public double calculatePrice(double zonePrice, double surface) {
		return zonePrice * surface;
	}

	public static void rentAvailableBuilding (Customer person){
		int c = 0;
		int choice;
		LOGGER.info("Which property do you want to rent?: ");
		for (int i = 0; i < availableForYou.size(); i++) {
			LOGGER.info("Option " + (c+1) +": " + availableForYou.getElementAt(c).getElement().getAddress() + " Price per month: AR$ " + availableForYou.getElementAt(c).getElement().getRentPrice());
		}
		try{
			choice = input.nextInt() - 1;
			person.rent(availableForYou.getElementAt(choice).getElement());
			TransactionQueue.storeTransactionOrder(availableForYou.getElementAt(choice).getElement().getAddress() + " was rented.");
		} catch(Exception e) {
			LOGGER.info(e.getMessage());
		}
		LOGGER.info("Transaction done!");

	}

	public static void buyAvailableBuilding (Owner person){
		int c = 0;
		int choice;
		LOGGER.info("Which property do you want to buy?: ");
		for (int i = 0; i < availableForYou.size(); i++) {
			LOGGER.info("Option " + (c+1) +": " + availableForYou.getElementAt(c).getElement().getAddress() + " Price: AR$ " + availableForYou.getElementAt(c).getElement().getSalePrice());
		}
		try{
			choice = input.nextInt() - 1;
			person.buy(availableForYou.getElementAt(choice).getElement());
			TransactionQueue.storeTransactionOrder(availableForYou.getElementAt(choice).getElement().getAddress() + " was bought.");
		} catch(Exception e) {
			LOGGER.info(e.getMessage());
		}
		LOGGER.info("Transaction done!");
	}

}

