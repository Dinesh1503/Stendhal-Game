package games.stendhal.server.entity.item.scroll;

import static games.stendhal.common.constants.Actions.TELEPORT;
import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.actions.CommandCenter;
import games.stendhal.server.actions.admin.TeleportAction;
import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPWorld;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.item.ConsumableItem;
import games.stendhal.server.entity.item.consumption.Poisoner;
import games.stendhal.server.entity.player.Player;
//import games.stendhal.server.entity.status.StatusType;
import games.stendhal.server.maps.MockStendlRPWorld;
import marauroa.server.game.db.DatabaseFactory;
import utilities.PlayerTestHelper;
import utilities.RPClass.ItemTestHelper;

public class TeleportPoisonedTest {
	private static StendhalRPZone playerzone;
	private final static int Xpos = 10;
	private final static int Ypos = 10;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new DatabaseFactory().initializeDatabase();
		MockStendlRPWorld.get();
		CommandCenter.register(TELEPORT, new TeleportAction(), 400);
	}

	/**
	 * Tests for teleportpoisoned.
	 */
	/**
	 * Tests for teleportpoisoned.
	 */
	@Test
	public final void testPoisonedTeleport() {
		SingletonRepository.getRPWorld().addRPZone(new StendhalRPZone("0_semos_city", 100, 100));
        SingletonRepository.getRPWorld().addRPZone(new StendhalRPZone("0_semos_canyon", 100, 100));
		SingletonRepository.getEntityManager();
		ItemTestHelper.generateRPClasses();
		PlayerTestHelper.generatePlayerRPClasses();
		final Map<String, String> attributes = new HashMap<String, String>();
		attributes.put("amount", "1000");
		attributes.put("regen", "200");
		attributes.put("frequency", "1");
		attributes.put("id", "1");
		final StendhalRPWorld world = SingletonRepository.getRPWorld();
		final StendhalRPZone zone = new StendhalRPZone("test");
		world.addRPZone(zone);
		final ConsumableItem c200_1 = new ConsumableItem("cheese", "", "", attributes);
		zone.add(c200_1);
		final Poisoner poisoner = new Poisoner();
		final Player bob = PlayerTestHelper.createPlayer("player");
		SingletonRepository.getRPWorld().getZone("0_semos_canyon").add(bob);
		poisoner.feed(c200_1, bob);
		Map<String, String> attributes2 = new HashMap<String, String>();
		attributes2.put("quantity", "1");
		attributes2.put("menu", "Use|Use");
		final MarkedScroll scroll = new MarkedScroll("marked scroll", "", "", attributes2);
		bob.equip("bag", scroll);
		
		assertFalse(scroll.onUsed(bob));

	}

}
