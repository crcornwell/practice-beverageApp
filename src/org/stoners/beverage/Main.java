package org.stoners.beverage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.PrintStream;


import org.stoners.beverage.model.Coffee;
import org.stoners.beverage.model.CoffeeType;
import org.stoners.beverage.util.Choices;
import org.stoners.beverage.util.Orders;
import org.stoners.beverage.util.UserInput;

public class Main {
	private MenuPrinter menuPrinter = new MenuPrinter(System.out);
	private Orders orders = new Orders();
	private UserInput userInput = new UserInput();
	private PrintStream out = new PrintStream(System.out);

	public static void main(String[] args) {
		new Main().doMain(args);
		// done to get out of static land.  static is like creep, it turns everything static that it touches.
		// if everything's static, you essentially just have free-floating functions that 
		// are no longer bound an instance.  i.e., non-object oriented C code.  if things are
		// tied to instances, you can easily create a new instance that injects
		// a special TestBufferedReader that automates answers for testing purposes, for ex.
		// you can set static values too, but it's not as clean.  something else
		// in the system that uses that static variable might break or interact unexpectedly with it.
	}
	
	public void doMain(String[] args) {
		//menuPrinter.printMenu("Enter anything", Choices.getSizes(new Coffee(CoffeeType.UNSPECIFIED)));
		//inputReader.readLine();
		boolean exitSwitch = false;
		
		out.printf("%s\n\n", "Welcome to Cornwell's Cafe, what can we do for you today?");
		while(!exitSwitch) {
			if (orders.orderList.isEmpty()) {
				List<MenuOptions> menuOptions = new ArrayList<>();
				menuOptions.add(MenuOptions.ADD_AN_ORDER);
				menuOptions.add(MenuOptions.EXIT);
				menuPrinter.printMenu("Make your selection", menuOptions);
				int userInput;
				userInput = this.userInput.toInt();
				switch(userInput) {
				case 1: 
					orders.addOrder();
					orders.printOrders();
					continue;
				case 2:
					exitSwitch = true;
					out.printf("\n%s\n\n", "Thanks for stopping by!");
					break;
				default:
					out.printf("\n%s\n\n", "You've made an invalid selection, please try again.");
				}
			}
			else {
				menuPrinter.printMenu("Make your selection", Arrays.asList(MenuOptions.values()));
				int userInput;
				userInput = this.userInput.toInt();
				switch(userInput) {
				case 1: 
					orders.addOrder();
					orders.printOrders();
					continue;
				case 2:
					orders.editOrder();
					orders.printOrders();
					continue;
				case 3:
					orders.removeOrder();
					orders.printOrders();
					continue;
				case 4:
					exitSwitch = true;
					out.printf("\n%s\n\n", "Thanks for stopping by!");
					break;
				default:
					out.printf("\n%s\n\n", "You've made an invalid selection, please try again.");
					
				}
			}
		}
	}
}