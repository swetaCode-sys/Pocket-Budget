package com.sweta.expenseTracker;
import java.util.ArrayList;

public class ExpenseTracker {
	
	private ArrayList<Transaction> transactions;
	
	public ExpenseTracker(){
		transactions = new ArrayList<>();
	}
	
	public void addTransactions(Transaction t) {
		transactions.add(t);
	}
	
	public void viewTransactions() {
		if(transactions.isEmpty()) {
			System.out.println("No transactions found.");
			return;
		}
		
		for(Transaction t : transactions) {
			System.out.println(t);
		}
	}
	
	public double getBalance() {
		double balance = 0;
		
		for(Transaction t : transactions) {
			if(t.getType().equalsIgnoreCase("Income")) {
				balance += t.getAmount();
			}
			else {
				balance -= t.getAmount();
			}
		}
		return balance;
	}
	
	public int gettransactionCount() {
		return transactions.size();
	}
	
	public void deleteTransaction(int indexD) {
		transactions.remove(indexD);
	}
	
	public Transaction searchTransaction(int indexS) {
		if(indexS >= 0 && indexS < transactions.size()) 
			return transactions.get(indexS);
		return null;
	}
}
