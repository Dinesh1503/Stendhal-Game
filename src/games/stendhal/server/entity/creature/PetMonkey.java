package games.stendhal.server.entity.creature;

import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.entity.player.Player;
import marauroa.common.game.RPClass;
import marauroa.common.game.RPObject;
import marauroa.common.game.SyntaxException;

public class PetMonkey extends Pet {
	/** the logger instance. */
	private static final Logger logger = Logger.getLogger(PetMonkey.class);
	
	@Override
	void setUp() {
		HP = 100;
		//the amount of healing when the animal eats
		incHP = 5;
		ATK = 15;
		DEF = 50;
		XP = 100;
		baseSpeed = 0.9;

		setAtk(ATK);
		setDef(DEF);
		setXP(XP);
		setBaseHP(HP);
		setHP(HP);
	}
	
	public static void generateRPClass() {
		try {
			final RPClass PetMonkey = new RPClass("pet_monkey");
			PetMonkey.isA("pet");
		} catch (final SyntaxException e) {
			logger.error("cannot generate RPClass", e);
		}
	}
	
	public PetMonkey() {
		this(null);
	}
	
	public PetMonkey(final Player owner) {
		// call set up before parent constructor is called as it needs those
		// values
		super();
		setOwner(owner);
		setUp();
		setRPClass("pet_monkey");
		put("type", "pet_monkey");
		if (owner != null) {
			// add pet to zone and create RPObject.ID to be used in setPet()
			owner.getZone().add(this);
			owner.setPet(this);
		}
		update();
		stealFromNearestPlayer(400.0);
	}
	
	public PetMonkey(final RPObject object, final Player owner) {
		super(object, owner);
		setRPClass("pet_monkey");
		put("type", "pet_monkey");
		update();
	}
	
	@Override
	protected List<String> getFoodNames() {
		return Arrays.asList("banana");
	}
	
	/**
	 * Does this domestic animal take part in combat?
	 *
	 * @return true, if it can be attacked by creatures, false otherwise
	 */
	@Override
	protected boolean takesPartInCombat() {
		return true;
	}
	
	//stealItem contains the logic to steal an item from a player and give it to a pet owner.
	public void stealItem(Player player) {
		if (player.isEquipped("banana")) {
			player.drop("banana");
			owner.equipToInventoryOnly(SingletonRepository.getEntityManager().getItem("banana"));	
		} 
	}
	
	//stealFromNearestPlayer contains the logic for the pet to find the nearest player to steal from.
	public void stealFromNearestPlayer(Double range) {
		Double squaredDistance = range * range;
		Player nearestPlayer = null;
		for (final Player player : getZone().getPlayers()) {
			if (!(player.getName().equals(owner.getName())) && this.squaredDistance(player) < squaredDistance) {
				nearestPlayer = player;
				squaredDistance = this.squaredDistance(player);
			}
		} if (!(nearestPlayer == null)) {
			setMovement(nearestPlayer, 0, 0, getMovementRange());
			stealItem(nearestPlayer);
		}
	}
	
}