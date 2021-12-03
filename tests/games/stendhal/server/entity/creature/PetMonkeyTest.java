package games.stendhal.server.entity.creature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.BeforeClass;
import org.junit.Test;
import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.maps.MockStendlRPWorld;
import utilities.PlayerTestHelper;
import utilities.RPClass.PetMonkeyTestHelper;

public class PetMonkeyTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PetMonkeyTestHelper.generateRPClasses();
		MockStendlRPWorld.get();
	}
	
	@Test
	public void testOwnerItemIncrease() {
		final StendhalRPZone zone = new StendhalRPZone("zone");
		final Player owner = PlayerTestHelper.createPlayer("owner");
		final Player testPlayer = PlayerTestHelper.createPlayer("testPlayer");
		zone.add(owner);
		zone.add(testPlayer);
		testPlayer.equipToInventoryOnly(SingletonRepository.getEntityManager().getItem("banana"));
		final PetMonkey monkey = new PetMonkey(owner);
		zone.add(monkey);
		monkey.stealFromNearestPlayer(400.0);
		assertEquals(true, owner.isEquipped("banana"));
	}
	
	@Test 
	public void testPlayerItemDecrease() {
		final StendhalRPZone zone = new StendhalRPZone("zone");
		final Player owner = PlayerTestHelper.createPlayer("owner");
		final Player testPlayer = PlayerTestHelper.createPlayer("testPlayer");
		zone.add(owner);
		zone.add(testPlayer);
		testPlayer.equipToInventoryOnly(SingletonRepository.getEntityManager().getItem("banana"));
		final PetMonkey monkey = new PetMonkey(owner);
		zone.add(monkey);
		monkey.stealFromNearestPlayer(400.0);
		assertFalse(testPlayer.isEquipped("banana"));
	}
}