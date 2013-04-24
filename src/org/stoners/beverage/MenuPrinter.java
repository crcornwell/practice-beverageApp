package org.stoners.beverage;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;
import java.io.BufferedReader;

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
	
	private int readInt() {
		String userInputStr;
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			userInputStr = inputReader.readLine();
		} catch (IOException e) {
			userInputStr = "";
		}
		int userInput;
		try {
			userInput = Integer.parseInt(userInputStr);
		} catch(NumberFormatException e) {
			userInput = 0;
		}
		return userInput;
	}
	
	public <T> Object handleSelection(List<? extends Object> choices) {
		return handleSelection("Make a selection", choices);
	}
	
	public <T> Object handleSelection(String prompt, List<? extends Object> choices) {
		boolean exitSwitch=false;
		int userInput=0;
		while(!exitSwitch) {
			printMenu(prompt, choices);
			userInput = readInt();
			if (userInput>0 && userInput<=choices.size()) {
				exitSwitch = true;
			}
			else
				out.printf("\n%s\n\n", "You've made an invalid selection, please try again");
		}
		return choices.get(userInput-1);
	}
	
	public boolean handleBoolean(List<? extends Object> choices) {
		Booleans yesNo = (Booleans) handleSelection(choices);
		switch (yesNo) {
		case YES : return true;
		default : return false;
		}
	}
}
