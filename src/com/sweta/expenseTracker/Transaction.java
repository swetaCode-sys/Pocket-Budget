package com.sweta.expenseTracker;

public class Transaction {
	
	private String type;
	private String category;
	private double Amount;
	private String date;
	
	public Transaction(String type, String category, double Amount, String date) {
		this.type = type;
		this.category = category;
		this.Amount = Amount;
		this.date = date;
	}
	
	public String getType() {
		return type;
	}
	
	public String getCategory() {
		return category;
	}
	
	public double getAmount() {
		return Amount;
	}
	
	public String getDate() {
		return date;
	}
	
	
	@Override
	public String toString() {
		return date+ " | " + type + " | " +category+ " | $" +Amount;
	}

}

