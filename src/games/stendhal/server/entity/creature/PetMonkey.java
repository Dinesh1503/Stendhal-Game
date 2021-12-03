package games.stendhal.server.entity.creature;

import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import games.stendhal.server.entity.player.Player;
import marauroa.common.game.RPObject;

public class PetMonkey extends Pet {
	private static final Logger logger = Logger.getLogger(PetMonkey.class);
	
	@Override
	void setUp() {
		
	}
	
	public static void generateRPClass() {

	}
	
	public PetMonkey() {
		this(null);
	}
	
	public PetMonkey(final Player owner) {
		super();
	}
	
	public PetMonkey(final RPObject object, final Player owner) {
		super(object, owner);
	}
	
	@Override
	protected List<String> getFoodNames() {
		return Arrays.asList("");
	}
	
	
	public void stealItem(Player player) {
	
	}
	
	public void stealFromNearestPlayer(Double range) {
	
	}
	
}
