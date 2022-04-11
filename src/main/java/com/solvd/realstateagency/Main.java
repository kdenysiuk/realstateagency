package com.solvd.realstateagency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.realstateagency.building.Apartment;
import com.solvd.realstateagency.building.Building;
import com.solvd.realstateagency.building.House;
import com.solvd.realstateagency.building.Zone;
import com.solvd.realstateagency.exception.InvalidNumberException;
import com.solvd.realstateagency.exception.InvalidOptionException;
import com.solvd.realstateagency.exception.NullBuildingException;
import com.solvd.realstateagency.person.Company;
import com.solvd.realstateagency.person.Customer;
import com.solvd.realstateagency.person.Owner;
import com.solvd.realstateagency.util.CustomLinkedlist;

import java.util.Scanner;
import java.util.LinkedList;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) throws InvalidOptionException {
		Scanner input = new Scanner(System.in);
		
		
		//I set some values for testing:
		Company com1 = new Company(11111111, "SINAT", "3735444828");
		Customer cust1 = new Customer(42189423, "Keith Denysiuk", "3735404649");
		Owner own1 = new Owner(42222597, "Bruno Diaz", "3773508669");
		House how1 = new House(11111, "58 Matheu St, Cnel Du Graty, Chaco", 150); //need to add the characteristic
		Apartment apt1 = new Apartment(21112, "1150 Las Heras Avenue, Resistencia, Chaco", 50); //need to add the characteristic
		Apartment apt2 = new Apartment(21113, "545 Jose Marmol St, Resistencia, Chaco", 30); //need to add the characteristic
		Zone downtownArea = new Zone("Downtown Area", 750);
		Zone residentialArea = new Zone("Residential Area", 500);
		Zone suburbanArea = new Zone("Suburban Area", 250);
		

		how1.setZone(residentialArea);
		how1.setRentPrice(how1.getSuperface());
		apt1.setZone(suburbanArea);
		apt1.setRentPrice(apt1.getSuperface());
		apt2.setZone(downtownArea);
		apt2.setRentPrice(apt1.getSuperface());
		
		//I set some amount of money for each person
		try {
			com1.setMoneyAvailable(1000000000);
			cust1.setMoneyAvailable(550000);
			own1.setMoneyAvailable(3750000);
		} catch (InvalidNumberException e) {
			e.printStackTrace();
		}
		
		//Let's assign a sale price for each property
		how1.setSalePrice(9500000);
		apt1.setSalePrice(2000000);
		apt2.setSalePrice(1500000);
		
		CustomLinkedlist<Building> availableProperties = new CustomLinkedlist<Building>();
		availableProperties.addElement(how1);
		availableProperties.addElement(apt1);
		availableProperties.addElement(apt2);
		
		//Let's make properties be owned by the real state agency
		
		
		//Let's see if each person can buy a property
		
		
		int properties;
		properties = 3;
		
		Building[] arrBuilding = new Building[properties];
		
		arrBuilding[0] = how1;
		arrBuilding[1] = apt1;
		arrBuilding[2] = apt2;
		
		int choise;
		String choise2;
		boolean choise3 = false;
		
		boolean flag;
		flag = true;
		
		//here starts the application:
		LOGGER.info("Which type of building do you want to choose?:"
				+"\nOption 1: Apartment"
				+"\nOption 2: House"
				+"\nOption 3: Office"
				+"\nOption 4: Premises");
		while(flag == true) {
			try {
				choise = input.nextInt();
				switch(choise) {
				case 1:
					LOGGER.info("Do you want a unique room apartment? (y/n)");
					while(flag == true) {
							choise2 = input.next();
							if (choise2.equalsIgnoreCase("y")) {
								LOGGER.info("You chose an Apartment with a unique room.");
								flag = false;
								choise3= true;
							} else if (choise2.equalsIgnoreCase("n")){
								LOGGER.info("You chose an Apartment with two or more rooms.");
								flag = false;
								choise3= false;
							} else {
								throw new InvalidOptionException();
								//LOGGER.info("Invalid option, try again.");
							}
					}
					break;
				case 2:
					LOGGER.info("Do you want to have houseyard too? (y/n)");
					while(flag == true) {
							choise2 = input.next();
							if (choise2.equalsIgnoreCase("y")) {
								LOGGER.info("You chose an house with houseyard.");
								flag = false;
								choise3= true;
							} else if (choise2.equalsIgnoreCase("n")){
								LOGGER.info("You chose an house without houseyard.");
								flag = false;
								choise3= false;
							} else {
								throw new InvalidOptionException();
								//LOGGER.info("Invalid option, try again.");
							}
					}
					break;
				case 3:
					LOGGER.info("Do you want a multi-office room? (y/n)");
					while(flag == true) {

							choise2 = input.next();
							if (choise2.equalsIgnoreCase("y")) {
								LOGGER.info("You chose a multi-office room.");
								flag = false;
								choise3= true;
							} else if (choise2.equalsIgnoreCase("n")){
								LOGGER.info("You a only office.");
								flag = false;
								choise3= false;
							} else {
								throw new InvalidOptionException();
								//LOGGER.info("Invalid option, try again.");
							}
					}
					break;
					
				case 4:
					LOGGER.info("Do you want an industries premises? (y/n)");
					while(flag == true) {
							choise2 = input.next();
							if (choise2.equalsIgnoreCase("y")) {
								LOGGER.info("You chose an industries premises.");
								flag = false;
								choise3= true;
							} else if (choise2.equalsIgnoreCase("n")) {
								LOGGER.info("You chose an non industries premises.");
								flag = false;
								choise3= false;
							} else {
								throw new InvalidOptionException();
								//LOGGER.info("Invalid option, try again.");
							}
					}
					break;
					
				default:
					throw new InvalidOptionException();
					//LOGGER.info("Invalid option, try again.");
				}
			} catch(InvalidOptionException e) {
				LOGGER.info(e.getMessage());
			}
			
		}
		
		LinkedList<Building> propertiesAvailable = new LinkedList<Building>();
		LOGGER.info("Enter your salary in AR$: ");
		try {
			cust1.setSalary(input.nextInt());
		} catch (InvalidNumberException e) {
			LOGGER.error(e.getMessage());
		}
		
		//I have to change this part of the code, for replacing the "hascaracteristic" of building class with characteristics for each child class.
		for (int i=0; i<properties; i++) {
			if (cust1.getSalary() * 0.5 >= arrBuilding[i].getRentPrice()) {
				propertiesAvailable.add(arrBuilding[i]);
			}
		}
		
		if (propertiesAvailable.size()<1) {
			throw new NullBuildingException();
		}
		
		LOGGER.info("The available properties for you are: ");
		
		for (int i=0; i<propertiesAvailable.size(); i++) {
			LOGGER.info("Adress: "+propertiesAvailable.get(i).getAdress()+" Price per month: AR$ "+propertiesAvailable.get(i).getRentPrice());
		}
	}

}
