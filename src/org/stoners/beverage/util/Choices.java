package org.stoners.beverage.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.stoners.beverage.model.Beverage;
import org.stoners.beverage.model.Coffee;
import org.stoners.beverage.model.RoastLevel;
import org.stoners.beverage.model.Size;

/**
 * This class separates the logic for determining the possible values for every
 * property into its own class.  SUPER IMPORTANT COMMENTS ON INHERITANCE BELOW!
 */
public class Choices {

	public static List<Size> getSizes(Beverage beverage) { 
		List<Size> result = null;
		
		if (beverage instanceof Coffee) {
			// 'instanceof' checks if an object is an instance of the given type.
			
			// GOING UP THE INHERITANCE CHAIN (from subclass to superclass)
			// Coffee -> Beverage -> Object
			// String -> CharSequence -> Object
			// Integer -> Number -> Object
			
			// going from subclass to superclass, specific to general, is SAFE: 
			// a String is always an Object, Coffee is always a Beverage.
			// thus no casting or type-checking is necessary when assigning to
			// the more general type or passing it as method arguments; you can assign a String to
			// an Object variable, pass a Coffee into a method expecting a Beverage and it'll
			// just work.  (it's implicitly cast as the target type).  (explanation of casts is below)

			// GOING DOWN THE INHERITANCE CHAIN (from superclass to subclass)
			// Object -> Beverage -> Coffee
			// Object -> CharSequence -> String
			// Object -> Number -> Integer
			// going in the opposite direction, from general to specific, class to subclass,
			// IS UNSAFE (not all Objects are Strings, iow), so type-checking and explicit
			// casting is required.  if you have a Beverage variable that refers to an object of 
			// type FruitSmoothie, and explicitly cast it to a Coffee, you get a ClassCastException
			
			// 'beverage' by itself evaluates to a Beverage object cause that's what it's typed as.
			// the ACTUAL type of the object that 'beverage' REFERS TO can be Beverage, 
			// Coffee, or (when it's added) FruitSmoothie.  or even subclasses we didn't write,
			// added by some mysterious third-party developer who forked our project and calls this
			// method in his code.
			
			// after we determined the ACTUAL type using 'instanceof', to force it to be evaluated as 
			// that type we explicitly cast it by putting the other type in parens in front.  
			// '(Coffee) beverage' evaluates to a Coffee object.
			
			// remove the cast and you get an infinite loop because it picks getSizes(Beverage) 
			// not getSizes(Coffee) 
			result = getSizes((Coffee) beverage);
		} 
		/* TODO
		else if (beverage instanceof FruitSmoothie) {
			result = getSizes((FruitSmoothie) beverage);
		}
		else {
		
		}
		*/
		return result;
	}
	
	// methods with the same name but different params are considered "overloaded".
	// the method chosen is inferred based on the types/number of the params you pass in
	public static List<Size> getSizes(Coffee coffee) {
		List<Size> sizes = new ArrayList<>();//"diamond" operator, <>, new with Java 1.7, saves you from repeating 'Size'
		
		// "switch-case statement"
		switch (coffee.getType()) {
		case SUMATRA:
			sizes.add(Size.SMALL);
			break;
		case MOCHA:
		case CAPPUCINO: // cases "fall-through" to following case if "break" is omitted
			sizes.add(Size.LARGE);
			break;
		default: // 'default' catches all other cases
			sizes.addAll(Arrays.asList(Size.values()));
			// break optional on last case
		}

		// remove placeholder for empty value
		sizes.remove(Size.UNSPECIFIED);
		
		return sizes;
	}

	public static List<RoastLevel> getRoastLevels(Coffee coffee) {
		List<RoastLevel> roasts = new ArrayList<>(Arrays.asList(RoastLevel.values()));
		roasts.remove(RoastLevel.UNSPECIFIED);
		
		// Arrays.asList converts arrays to a **fixed-size** List<T>.  also takes 0 or more
		// arguments (that's what '...' on a method parameter type means.  0 or more
		// arguments can be passed in either as successive, comma-separated arguments 
		// or as an array.)  hover over 'asList' to see javadoc and method signature
		
		// Enum.values() is a method all enums inherit that returns all enum values as an array
		// of type RoastLevel[] in this case
		
		// passing a List into a new ArrayList(..) constructor makes a new, **unfixed-size** list
		// that copies the contents of the passed-in list
		
		// I did it this way cause defaulting to all then removing ones you don't need
		// is another way to do it that you might prefer
		switch (coffee.getType()) {
		case MOCHA:
		case CAPPUCINO:
			// remove all except DARK
			roasts.retainAll(Arrays.asList(RoastLevel.DARK)); //  Arrays.asList is also a convenient way to get a collection
			break;
			// TODO
		}
		
		return roasts;
	}

	public static boolean getWhippedDefault(Coffee coffee) {
		switch (coffee.getType()) {
		case CAPPUCINO:
			return true;
		default: // 'default' catches all other cases
			return false;
		} // breaks omitted because returns render them unnecessary
	}

	public static boolean isWhippedSelectable(Coffee coffee) {
		switch (coffee.getType()) {
		case CAPPUCINO:
			return false;
		default:
			return true;
		}
	}

	public static boolean getFoamyDefault(Coffee coffee) {
		return false;
	}

	public static boolean isFoamySelectable(Coffee coffee) {
		switch (coffee.getType()) {
		case CAPPUCINO:
			return true;
		default:
			return false;
		}
	}
}
