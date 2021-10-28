package games.stendhal.server.maps.nalwor.forest;

import static org.junit.Assert.*;
import static utilities.SpeakerNPCTestHelper.getReply;
import org.junit.Test;
import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.npc.fsm.Engine;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.maps.MockStendlRPWorld;
import utilities.PlayerTestHelper;

public class DojoTest {
	@Test
	public void test() {
		final StendhalRPZone nalworForest = new StendhalRPZone("0_nalwor_forest_n");
		MockStendlRPWorld.get().addRPZone(nalworForest);
		new Dojo().configureZone(nalworForest, null);
		final SpeakerNPC npc = SingletonRepository.getNPCList().get("Omura Sumitada");
		final Player tester = PlayerTestHelper.createPlayer("tester");
		tester.setAtk(10000);
		final Engine en = npc.getEngine();
		en.step(tester, "hi");
		en.step(tester, "fee");
		assertEquals("At your level of experience, your attack strength is too high to train here at this time.", getReply(npc));
	}

}
