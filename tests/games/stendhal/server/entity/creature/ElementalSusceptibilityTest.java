package games.stendhal.server.entity.creature;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import games.stendhal.common.constants.Nature;
import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.maps.MockStendlRPWorld;
import marauroa.common.Log4J;
import marauroa.server.game.db.DatabaseFactory;
import utilities.RPClass.CreatureTestHelper;



public class ElementalSusceptibilityTest {
	@Before
	public void setUp() {
		MockStendlRPWorld.get();
		CreatureTestHelper.generateRPClasses();
		Log4J.init();
		new DatabaseFactory().initializeDatabase();
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testElementalSusceptibility() {
		//Create elemental centaurs for testing
		Creature solar = SingletonRepository.getEntityManager().getCreature("solar centaur");
		Creature glacier = SingletonRepository.getEntityManager().getCreature("glacier centaur");
		
		//Check if monster is susceptible to their own nature
		assertEquals(solar.getSusceptibility(Nature.FIRE) < 1.0, true);
		assertEquals(glacier.getSusceptibility(Nature.ICE) < 1.0, true);
		
		//Check if monster is susceptible to the opposite nature
		assertEquals(solar.getSusceptibility(Nature.ICE) > 1.0, true);
		assertEquals(glacier.getSusceptibility(Nature.FIRE) > 1.0, true);
	}
}
