package org.stoners.beverage.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.PrintStream;

import org.stoners.beverage.model.Beverage;
import org.stoners.beverage.model.CoffeeType;
import org.stoners.beverage.MenuPrinter;
import org.stoners.beverage.model.*;

public class Orders {
	private MenuPrinter menuPrinter = new MenuPrinter(System.out);
	private PrintStream out = new PrintStream(System.out);
	public List<Beverage> orderList = new ArrayList<>();
	
	public void addOrder() {
		List<CoffeeType> coffeeType = new ArrayList<>(Arrays.asList(CoffeeType.values()));
		coffeeType.remove(CoffeeType.UNSPECIFIED);
		out.printf("\n%s\n\n", "What type of coffee would you like?");
		CoffeeType userInput = (CoffeeType) menuPrinter.handleSelection("Make your selection", coffeeType);
		Coffee coffee = Coffee.newInstance(userInput);
		out.printf("\n%s\n\n", "What kind of roast do you prefer?");
		RoastLevel userRoast = (RoastLevel) menuPrinter.handleSelection(coffee.getAvailableRoastLevels());
		coffee.setRoastLevel(userRoast);
		orderList.add(coffee);
	}
	
	public void editOrder() {
		
	}
	
	public void removeOrder() {
		orderList.remove(menuPrinter.handleSelection(orderList));
	}
	
	public void printOrders() {
		out.printf("\n%s\n\n", "Your order summary is:");
		for (int i=0; i<orderList.size(); i++) {
			out.printf("%s\n", orderList.get(i).toString());
		}
		System.out.println();
	}
}
