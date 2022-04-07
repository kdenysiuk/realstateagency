package com.solvd.realstateagency.exception;

public class NullBuildingException extends RuntimeException {
	public NullBuildingException(){
		super("No buildings available");
	}
}
