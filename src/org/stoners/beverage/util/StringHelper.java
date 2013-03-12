package org.stoners.beverage.util;

public class StringHelper {
	private static final char[] LOWERCASE_VOWELS = new char[] { 'a', 'e', 'i', 'o', 'u' };
	
	/**
	 *  prefixes str with "a " or "an ", capitalized appropriately
	 */
	public static String addArticle(String str) {
		if (str == null || str == "")
			return str; // do nothing
		
		char[] chars = str.toCharArray();
		char first = chars[0];
		
		if (!Character.isAlphabetic(first))
			return str; // do nothing

		boolean isVowel = contains(LOWERCASE_VOWELS, Character.toLowerCase(first));
		String rest = Character.toLowerCase(first) + str.substring(1);
		if (Character.isUpperCase(first)) {
			if (isVowel) {
				str = "An " + rest;
			} else {
				str = "A " + rest;
			}
		} else {
			if (isVowel) {
				str = "an " + rest;
			} else {
				str = "a " + rest;
			}
		}
		
		return str;
	}
	
	public static String commaDelimit(String... strs) {
		return join(true, ", ", strs);
	}
	
	public static String join(boolean discardBlanks, String delimiter, String... strs) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].isEmpty() && discardBlanks)
				continue;
			sb.append(strs[i]);
			if (i < strs.length - 1)
				sb.append(delimiter);
		}
		
		return sb.toString();
	}
	
	private static boolean contains(char[] chars, char ch) {
		for (char element : chars) {
			if (element == ch)
				return true;
		}
		
		return false;
	}
}
