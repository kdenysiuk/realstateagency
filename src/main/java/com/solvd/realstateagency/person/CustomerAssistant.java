package com.solvd.realstateagency.person;

import com.solvd.realstateagency.innterface.IWork;

public class CustomerAssistant extends Employee implements IWork {
	
	//constructor
	public CustomerAssistant(int pID, int emplID, String pName, String pTelephone) {
		super(pID, emplID, pName, pTelephone);
	}
	
	@Override
	public void work() {
		System.out.println("I'm working here.");
	}

}
