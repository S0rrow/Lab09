package edu.handong.csee.java.Lab09;
import java.util.Scanner;

public class MarketingAnalyzer {
	private double highestSales=0.0;
	private double averageSales=0.0;
	private Salesman[] team;
	public static void main(String[] args) {
		MarketingAnalyzer Analyzer = new MarketingAnalyzer();
		Analyzer.getData();
		Analyzer.computeAverage();
		Analyzer.computeHighestSales();
		Analyzer.printResult();
		
	}
	
	public void getData() {
		
		System.out.println("Enter the number of salesman: ");
		Scanner keyboard = new Scanner(System.in);
		
		int num_salesman = keyboard.nextInt();
		
		team = new Salesman[num_salesman];
		
		for(int i=0;i<num_salesman;i++) {
			System.out.println("Enter data for associate number:"+(i+1));
			System.out.println("Give the name: ");
			keyboard.nextLine();
			String name = keyboard.nextLine();
			System.out.print("Sales: ");
			double sales = keyboard.nextDouble();
			team[i] = new Salesman();
			team[i].setmName(name);
			team[i].setmSales(sales);
		}
	}
	
	public void computeAverage() {
		double sum = 0.0;
		for(int i=0;i<team.length;i++) {
			sum = sum + team[i].getmSales();
		}
		this.averageSales = sum/team.length;
	}
	
	public void computeHighestSales() {
		double HSales =0.0;
		for(int i=0;i<team.length;i++) {
			if(HSales < team[i].getmSales()) {
				HSales = team[i].getmSales();
			}
		}
		this.highestSales = HSales;
	}
	
	public void printResult() {
		System.out.println("Average: "+ this.averageSales);
		System.out.println("Salesman who has the highest sales: ");
		for(int i=0;i<team.length;i++) {
			if(team[i].getmSales()==highestSales) {
				System.out.println("Name: "+team[i].getmName());
				System.out.println("Sales: "+team[i].getmSales());
			}
		}
	}
}
