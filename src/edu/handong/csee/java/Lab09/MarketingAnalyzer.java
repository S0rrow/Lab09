package edu.handong.csee.java.Lab09;
import java.util.Scanner;//import scanner for input.
/**
 * 
 * @author s0rrow
 *
 */
public class MarketingAnalyzer {// This class is main class for getting data and printing out results.
	private double highestSales=0.0;// Declare local double variable for highest sales.
	private double averageSales=0.0;// Declare local double variable for average sales.
	private Salesman[] team;// Declare array with Salesman class type.
	public static void main(String[] args) {// This is main method for computing and printing.
		MarketingAnalyzer Analyzer = new MarketingAnalyzer();// Initiate instance.
		Analyzer.getData();// Use method getData from instance.
		Analyzer.computeAverage();// Use method computeAverage from instance.
		Analyzer.computeHighestSales();// Use method computeHighestSales from instance.
		Analyzer.printResult();// Use method to print results.
	}
	
	public void getData() {// This method is for getting data by number of salesman given.
		System.out.println("Enter the number of salesman: ");// Direct user what to type.
		Scanner keyboard = new Scanner(System.in);// Initiate scanner for input.
		
		int num_salesman = keyboard.nextInt();// Assign given integer to a variable.
		
		team = new Salesman[num_salesman];// Initiate an array with memory space according to number of salesman.
		
		for(int i=0;i<num_salesman;i++) {// Start a loop that increases from 0 by 1 until number of salesman.
			System.out.println("Enter data for associate number:"+(i+1));// Show user the index of array they're assigning.
			System.out.println("Give the name: ");// Direct user what to type.
			keyboard.nextLine();// Get a character to clear out new line character.
			String name = keyboard.nextLine();// Assign next give string to a variable.
			System.out.print("Sales: ");// Direct user what to type.
			double sales = keyboard.nextDouble();// Assign next given double to a variable.
			team[i] = new Salesman();// Index an array.
			team[i].setmName(name);// Assign name of salesman to array.
			team[i].setmSales(sales);// Assign sales of salesman to array.
		}
	}
	
	public void computeAverage() {// This method is for computing average of sales.
		double sum = 0.0;// Declare and initiate a double variable.
		for(int i=0;i<team.length;i++) {// Start a loop that increases from 0 by 1 until length of array; which is number of salesman.
			sum = sum + team[i].getmSales();// Get the sales and add it to the sum.
		}
		this.averageSales = sum/team.length;// Compute average and assign it to local variable averageSales.
	}
	
	public void computeHighestSales() {// This method is for computing highest sales.
		double HSales =0.0;// Declare and initiate a double variable.
		for(int i=0;i<team.length;i++) {// Start a loop that increases from 0 by 1 until length of array; which is number of salesman.
			if(HSales < team[i].getmSales()) {// Set the condition, if local double variable of method is smaller than sales of current index,
				HSales = team[i].getmSales();// Reassign that value to local double variable.
			}
		}
		this.highestSales = HSales;// Assign computed highest value of sales to local double variable highestSales. 
	}
	
	public void printResult() {// This method is for printing out the results.
		System.out.println("Average: "+ this.averageSales);// Let the user know the average of sales.
		System.out.println("Salesman who has the highest sales: ");// Direct user what information will come next.
		for(int i=0;i<team.length;i++) {//// Start a loop that increases from 0 by 1 until length of array; which is number of salesman.
			if(team[i].getmSales()==highestSales) {// Set the condition for getting which salesman has the highest sales.
				System.out.println("Name: "+team[i].getmName());// Print the name of salesman.
				System.out.println("Sales: "+team[i].getmSales());// Print the sales of salesman.
			}
		}
	}
}
