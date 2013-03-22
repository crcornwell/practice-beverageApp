package org.stoners.beverage;

import java.io.PrintStream;
import java.util.List;

/**
 * 
 * @author clr
 *
 */
public class MenuPrinter {
	private PrintStream out;
	
	public MenuPrinter(PrintStream out) {
		this.out = out;
	}
	
	// List<? extends Object> says any subclass of Object up to and including Object is allowed
	// in place of T in List<T>
	public void printMenu(String prompt, List<? extends Object> choices) {
		for (int i = 0; i < choices.size(); i++) {
			out.printf("%d. %s\n", i + 1, choices.get(i).toString().replaceAll("_", " "));
		}
		out.print(prompt + ": ");
	}
}
