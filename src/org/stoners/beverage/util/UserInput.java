package org.stoners.beverage.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UserInput {
	private BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
	
	public int toInt() {
		String userInputStr;
		try {
			userInputStr = inputReader.readLine();
		} catch (IOException e) {
			userInputStr = "";
		}
		int userInput;
		try {
			userInput = Integer.parseInt(userInputStr);
		}
		catch(NumberFormatException e) {
			userInput = 0;
		}
		return userInput;
	}
	
	public float toFloat(){
		String userInputStr;
		try {
			userInputStr = inputReader.readLine();
		} catch (IOException e) {
			userInputStr = "";
		}
		float userInput;
		try {
			userInput = Float.parseFloat(userInputStr);
		}
		catch(NumberFormatException e) {
			userInput = 0;
		}
		return userInput;
	}
}