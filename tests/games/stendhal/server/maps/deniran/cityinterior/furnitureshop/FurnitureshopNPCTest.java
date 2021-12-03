/* $Id$ */
/***************************************************************************
 *                   (C) Copyright 2003-2011 - Stendhal                    *
 ***************************************************************************
 ***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 ***************************************************************************/
package games.stendhal.server.maps.deniran.cityinterior.furnitureshop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static utilities.SpeakerNPCTestHelper.getReply;

import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.npc.fsm.Engine;
import utilities.QuestHelper;
import utilities.ZonePlayerAndNPCTestImpl;

/**
 * @author Martin Fuchs
 */
public class FurnitureshopNPCTest extends ZonePlayerAndNPCTestImpl {

	private static final String ZONE_NAME = "int_deniran_furniture_shop";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		QuestHelper.setUpBeforeClass();
		setupZone(ZONE_NAME);
	}

	public FurnitureshopNPCTest() {
		setNpcNames("Gareth");
		setZoneForPlayer(ZONE_NAME);
		addZoneConfigurator(new FurnitureshopNPC(), ZONE_NAME);
	}

	/**
	 * Test for Hi.
	 */
	@Test
	public void testHi() {
		final SpeakerNPC npc = getNPC("Gareth");
		final Engine en = npc.getEngine();

		assertTrue(en.step(player, "hi Gareth"));
		assertEquals("Welcome to Deniran's furniture shop. Ask me about my #job.", getReply(npc));


		
	}
	// Test for help.
	@Test
	public void testHelp() {
		final SpeakerNPC npc = getNPC("Gareth");
		final Engine en = npc.getEngine();
		
		assertTrue(en.step(player, "hi Gareth"));
		assertEquals("Welcome to Deniran's furniture shop. Ask me about my #job.", getReply(npc));

		assertTrue(en.step(player, "help"));
		assertEquals("If you would like to sell something, ask me about my #prices and I will tell you what I #offer.", getReply(npc));


		
	}

	
	// Test for quest.
		@Test
		public void testQuest() {
			final SpeakerNPC npc = getNPC("Gareth");
			final Engine en = npc.getEngine();
			
			assertTrue(en.step(player, "hi Gareth"));
			assertEquals("Welcome to Deniran's furniture shop. Ask me about my #job.", getReply(npc));

			assertFalse(en.step(player, "quest"));

		}
		
		public void testExists() {
			assertNotNull(SingletonRepository.getRPWorld().getRPZone(ZONE_NAME));

		}
		

	
}
