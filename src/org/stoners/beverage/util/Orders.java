package org.stoners.beverage.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.PrintStream;

import org.stoners.beverage.model.Beverage;
import org.stoners.beverage.MenuPrinter;
import org.stoners.beverage.model.*;

public class Orders {
	private MenuPrinter menuPrinter = new MenuPrinter(System.out);
	private UserInput userInput = new UserInput();
	private PrintStream out = new PrintStream(System.out);
	public List<Beverage> orderList = new ArrayList<>();
	
	public void addOrder() {
		out.printf("\n%s\n\n", "What type of coffee would you like?");
		menuPrinter.printMenu("Make your selection", Arrays.asList(CoffeeType.values()));
		int userInput = this.userInput.toInt();
		Coffee coffee = new Coffee(CoffeeType.values()[userInput-1]);
		orderList.add(coffee);
	}
	
	public void editOrder() {
		
	}
	
	public void removeOrder() {
		
	}
	
	public void printOrders() {
		for (int i=0; i<orderList.size(); i++) {
			out.printf("%s\n", orderList.get(i).toString());
		}
	}
}
