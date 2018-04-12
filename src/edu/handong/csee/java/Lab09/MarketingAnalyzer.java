package edu.handong.csee.java.Lab09;

import java.util.ArrayList;
import java.util.Scanner;//import scanner for input.
/**
 * 
 * @author s0rrow
 *
 */
public class MarketingAnalyzer {// This class is main class for getting data and printing out results.
	private double highestSales=0.0;// Declare local double variable for highest sales.
	private double averageSales=0.0;// Declare local double variable for average sales.
	ArrayList<Salesman> Info = new ArrayList<Salesman>();// Declare an arraylist with type as class Salesman.
	
	public static void main(String[] args) {// This is main method for computing and printing.
		MarketingAnalyzer Analyzer = new MarketingAnalyzer();// Initiate instance.
		Analyzer.getData();// Use method getData from instance.
		Analyzer.computeAverage();// Use method computeAverage from instance.
		Analyzer.computeHighestSales();// Use method computeHighestSales from instance.
		Analyzer.printResult();// Use method to print results.
	}
	
	public void getData() {// This method is for getting data by checking whether the user will input additional data or not.
		Scanner keyboard = new Scanner(System.in);// Initiate scanner for input.
		boolean done = false;
		while(!done) {// Start a loop that ends when user inputs anything else than yes.
			System.out.println("Give the name: ");// Direct user what to type.
			String name = keyboard.nextLine();// Assign next given string to a variable.
			System.out.print("Sales: ");// Direct user what to type.
			double sales = keyboard.nextDouble();// Assign next given double to a variable.
			Salesman team = new Salesman();// Declare a new instance variable.
			team.setmName(name);// Assign string to instance.
			team.setmSales(sales);// Assign double to instance.
			Info.add(team);// Assign instance to arraylist.
			
			System.out.println("Anymore data for salesman?:");// Check whether the user will input additional data or not.
			keyboard.nextLine();// Delete enter left.
			String yesno = keyboard.nextLine();// Get the next given string.
			if(!yesno.equalsIgnoreCase("yes")) {//check whether the answer is yes or no.
				done = true;// If yes, set done to true so that the loop continues.
			}
		}
		keyboard.close();// Free the memory allocated to keyboard.
	}
	
	public void computeAverage() {// This method is for computing average of sales.
		double sum = 0.0;// Declare and initiate a double variable.
		for(int i=0;i<Info.size();i++) {// Start a loop that increases from 0 by 1 until size of arraylist
			double sales = (Info.get(i)).getmSales();
			sum = sum + sales;// Get the sales and add it to the sum.
		}
		this.averageSales = sum/Info.size();// Compute average and assign it to local variable averageSales.
	}
	
	public void computeHighestSales() {// This method is for computing highest sales.
		double HSales =0.0;// Declare and initiate a double variable.
		for(int i=0;i<Info.size();i++) {// Start a loop that increases from 0 by 1 until length of array; which is number of salesman.
			if(HSales <(Info.get(i)).getmSales()) {// Set the condition, if local double variable of method is smaller than sales of current index,
				HSales = (Info.get(i)).getmSales();// Reassign that value to local double variable.
			}
		}
		this.highestSales = HSales;// Assign computed highest value of sales to local double variable highestSales. 
	}
	
	public void printResult() {// This method is for printing out the results.
		System.out.println("Average: "+ this.averageSales);// Let the user know the average of sales.
		System.out.println("Salesman who has the highest sales: ");// Direct user what information will come next.
		for(int i=0;i<Info.size();i++) {//// Start a loop that increases from 0 by 1 until length of array; which is number of salesman.
			if((Info.get(i)).getmSales()==highestSales) {// Set the condition for getting which salesman has the highest sales.
				System.out.println("Name: "+(Info.get(i)).getmName());// Print the name of salesman.
				System.out.println("Sales: "+(Info.get(i)).getmSales());// Print the sales of salesman.
			}
		}
	}
}
