/* $Id$ */
package games.stendhal.server.entity.item;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.maps.MockStendlRPWorld;
import marauroa.common.Log4J;
import utilities.PlayerTestHelper;
import utilities.RPClass.ItemTestHelper;

public class SleepableTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Log4J.init();
		MockStendlRPWorld.get();
		ItemTestHelper.generateRPClasses();

		MockStendlRPWorld.get().addRPZone(new StendhalRPZone("int_semos_guard_house", 100, 100));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PlayerTestHelper.removeAllPlayers();
	}

	/**
	 * Tests for describe.
	 */
	@Test
	public void testDescribe() {
		final Sleepable bed = (Sleepable) SingletonRepository.getEntityManager().getItem("sleepable");
		assertThat(bed.describe(), is("You see a bed and you can sleep in it."));
	}

	
	/**
	 * Test when player attempts to use ring without equipping it to slot.
	 */
	@Test
	public void testOnUsedOnGround() {
		final Player romeo = PlayerTestHelper.createPlayer("romeo");
		final Sleepable bed = (Sleepable) SingletonRepository.getEntityManager().getItem("sleepable");

		assertTrue(bed.onUsed(romeo));
	}

}
