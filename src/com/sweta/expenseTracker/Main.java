package com.sweta.expenseTracker;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpenseTracker tracker = new ExpenseTracker();
		
		int choice;
		
		do {
			System.out.println("=====EXPENSE TRACKER=====");
			System.out.println("1.Add Transactions");
			System.out.println("2.View Transactions");
			System.out.println("3.View Balance");
			System.out.println("4.Delete a transaction");
			System.out.println("5.Search a transaction");
			System.out.println("6.Exit");
			
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				String type;
				
				while(true) {
					System.out.println("Type (Income/Expense): ");
					type = sc.nextLine();

					if(type.equalsIgnoreCase("Income") || type.equalsIgnoreCase("Expense")) {
						break;
					}
						
					System.out.println("Invalid type! Please enter only Income or Expense.");
					
				}			

				System.out.println("Category: ");
				String category = sc.nextLine();
				
				double amount;
				while(true) {
					try {
						System.out.println("Amount: ");
						amount = sc.nextDouble();
						sc.nextLine();
						if(amount < 0) {
							System.out.println("Please enter a positive amount");
							continue;					
						}
						else {
							break;
						}
					}
					catch(InputMismatchException e) {
						System.out.println("Invalid input! Please enter a numeric amount.");
						sc.nextLine();
						continue;
					}
				}
				
				
				String date = LocalDate.now().toString();
				
				Transaction t = new Transaction(type, category, amount, date);
				
				tracker.addTransactions(t);
				
				System.out.println("Transaction added.");
				break;
			
			case 2: 
				tracker.viewTransactions();
				break;
			
			case 3:
				System.out.println("Current Balance: $" +tracker.getBalance());
				break;
				
			case 4:
				tracker.viewTransactions();
				System.out.println("Enter the transaction index number to be deleted");
				int indexD = sc.nextInt();
				
				if(indexD >= 0 && indexD <= tracker.gettransactionCount()) { 
					tracker.deleteTransaction(indexD);
					System.out.println("Transaction deleted successfully");
				}
				else 
					System.out.println("Invalid Index.");
				break;
			
			case 5:
				tracker.viewTransactions();			
				System.out.println("Enter the transactions index number you want to search: ");
				int indexS = sc.nextInt();
				
				Transaction t1 = tracker.searchTransaction(indexS);
				
				if(t1 != null)
					System.out.println(t1);
				else
					System.out.println("Invalid index");
				break;
			
			default:
				System.out.println("Invalid choice.");
			}
			
		}while(choice != 4);
		
		sc.close();
	}
}
