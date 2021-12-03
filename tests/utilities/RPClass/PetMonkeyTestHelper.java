package utilities.RPClass;

import games.stendhal.server.entity.creature.PetMonkey;
import marauroa.common.game.RPClass;

public class PetMonkeyTestHelper {
	
	public static void generateRPClasses() {
		
		PetTestHelper.generateRPClasses();
		
		if (!RPClass.hasRPClass("pet_monkey")) {
			PetMonkey.generateRPClass();
		}
	}
}