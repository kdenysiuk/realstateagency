package com.solvd.realstateagency.exception;

public class InvalidAmountException extends RuntimeException {
	public InvalidAmountException() {
		super("You can't afford this property. You haven't got enough money.");
	}
}
