package org.stoners.beverage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.stoners.beverage.model.Coffee;
import org.stoners.beverage.model.CoffeeType;
import org.stoners.beverage.util.Choices;

public class Main {
	private MenuPrinter menuPrinter = new MenuPrinter(System.out);
	private BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		new Main().doMain(args);
		// done to get out of static land.  static is like creep, it turns everything static that it touches.
		// if everything's static, you essentially just have free-floating functions that 
		// are no longer bound an instance.  i.e., non-object oriented C code.  if things are
		// tied to instances, you can easily create a new instance that injects
		// a special TestBufferedReader that automates answers for testing purposes, for ex.
		// you can set static values too, but it's not as clean.  something else
		// in the system that uses that static variable might break or interact unexpectedly with it.
	}
	
	public void doMain(String[] args) throws IOException {
		menuPrinter.printMenu("Enter anything", Choices.getSizes(new Coffee(CoffeeType.UNSPECIFIED)));
		inputReader.readLine();
	}
}