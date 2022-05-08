package com.solvd.realstateagency.main;

import com.solvd.realstateagency.building.Apartment;
import com.solvd.realstateagency.building.Building;
import com.solvd.realstateagency.building.House;
import com.solvd.realstateagency.building.Zone;
import com.solvd.realstateagency.exception.InvalidNumberException;
import com.solvd.realstateagency.exception.InvalidOptionException;
import com.solvd.realstateagency.person.Customer;
import com.solvd.realstateagency.person.Owner;
import com.solvd.realstateagency.util.TransactionQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
	
	private static final Logger LOGGER = LogManager.getLogger(Main.class);
	
	public static void main (String[] args) throws InvalidNumberException {

		//create objects
		Agency sinat = new Agency(2073456767, "SINAT", "3735444828");
		Customer keith = new Customer(42189423, "Keith Denysiuk", "3735404649");
		Owner bruno = new Owner(42222597, "Bruno Diaz", "3773508669");
		House matheuSt = new House(11111, "58 Matheu St, Cnel Du Graty, Chaco", 150); //need to add the characteristic
		Apartment lasHerasAv = new Apartment(21112, "1150 Las Heras Avenue, Resistencia, Chaco", 50); //need to add the characteristic
		Apartment marmolSt = new Apartment(21113, "545 Jose Marmol St, Resistencia, Chaco", 30); //need to add the characteristic

		sinat.propertiesAvailable.add(matheuSt);
		sinat.propertiesAvailable.add(lasHerasAv);
		sinat.propertiesAvailable.add(marmolSt);

		//add characteristics
		matheuSt.setHasHouseYard(true);
		lasHerasAv.setUniqueRoom(false);
		marmolSt.setUniqueRoom(true);
		
		//set zone
		matheuSt.setZone(Zone.RESIDENTIAL);
		lasHerasAv.setZone(Zone.SUBURBAN);
		marmolSt.setZone(Zone.DOWNTOWN);
		
		//set rent prices
		sinat.propertiesAvailable.forEach((x) -> x.setRentPrice(x.calculatePrice(x.getZone().getRentPrice(), x.getSurface())));
		keith.setSalary(120000);

		//set sale prices
		sinat.propertiesAvailable.forEach((x) -> x.setSalePrice(x.calculatePrice(x.getZone().getSalePrice(), x.getSurface())));
		bruno.setMoneyAvailable(150000000);

		//Application

		try (Scanner input = new Scanner(System.in)){
			int choice;
			boolean flag = true;
			while(flag){
				LOGGER.info("Who are you?:"
						+ "\nOption 1: Keith Denysiuk (Renting Customer)"
						+ "\nOption 2: Bruno Diaz (Buying Customer)"
						+ "\nOption 3: SINAT (Company)"
						+ "\nOption 4: EXIT");
				choice = input.nextInt();
				switch(choice){
					case 1:
						LOGGER.info("Hello, here is your information:");
						Agency.showRentingInfo(keith);
						Agency.asCustomerOption();
						Agency.showAvailableRentingPropertiesList(sinat.propertiesAvailable, Building.availableForYou, keith);
						Building.rentAvailableBuilding(keith);
						//flag = false;
						break;
					case 2:
						LOGGER.info("Hello, here is your information:");
						com.solvd.realstateagency.main.Agency.showBuyingInfo(bruno);
						com.solvd.realstateagency.main.Agency.asCustomerOption();
						Agency.showAvailableBuyingPropertiesList(sinat.propertiesAvailable, Building.availableForYou, bruno);
						Building.buyAvailableBuilding(bruno);
						//flag = false;
						break;
					case 3:
						LOGGER.info("Hello, here is your information:");
						Agency.showCompanyInfo(sinat);
						Agency.asCompanyOption(sinat.propertiesAvailable);
						//flag = false;
						break;
					case 4:
						LOGGER.info("The application was ended!");
						flag = false;
						break;
					default:
						LOGGER.info("Invalid option, try again!");
				}
			}

			LOGGER.info("\nThe transactions done were:");
			TransactionQueue.getTransactionOrderStored();

		} catch (InvalidOptionException e) {
			throw new RuntimeException(e);
		}
	}
}
