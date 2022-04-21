package com.solvd.realstateagency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.realstateagency.building.Apartment;
import com.solvd.realstateagency.building.House;
import com.solvd.realstateagency.building.Zone;
import com.solvd.realstateagency.person.Company;
import com.solvd.realstateagency.person.Customer;
import com.solvd.realstateagency.person.Owner;

public class Main {
	
	private static final Logger LOGGER = LogManager.getLogger(MainOld.class);
	
	public static void main (String[] args) {
		
		//create objects
		Company sinat = new Company(11111111, "SINAT", "3735444828");
		Customer keith = new Customer(42189423, "Keith Denysiuk", "3735404649");
		Owner bruno = new Owner(42222597, "Bruno Diaz", "3773508669");
		House matheuSt = new House(11111, "58 Matheu St, Cnel Du Graty, Chaco", 150); //need to add the characteristic
		Apartment lasHerasAv = new Apartment(21112, "1150 Las Heras Avenue, Resistencia, Chaco", 50); //need to add the characteristic
		Apartment marmolSt = new Apartment(21113, "545 Jose Marmol St, Resistencia, Chaco", 30); //need to add the characteristic
	
		//add characteristics
		matheuSt.setHasHouseYard(true);
		lasHerasAv.setUniqueRoom(false);
		marmolSt.setUniqueRoom(true);
		
		//set zone
		matheuSt.setZone(Zone.RESIDENTIAL);
		lasHerasAv.setZone(Zone.SURBURBAN);
		marmolSt.setZone(Zone.DOWNTOWN);
		
		
		
		
	}

}
