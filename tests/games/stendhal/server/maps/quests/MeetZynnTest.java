/* $Id$ */
/***************************************************************************
 *                   (C) Copyright 2003-2010 - Stendhal                    *
 ***************************************************************************
 ***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 ***************************************************************************/
package games.stendhal.server.maps.quests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.npc.fsm.Engine;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.maps.semos.library.HistorianGeographerNPC;
import utilities.PlayerTestHelper;
import utilities.QuestHelper;

public class MeetZynnTest {

	private Player player = null;
	private SpeakerNPC npc = null;
	private Engine en = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		QuestHelper.setUpBeforeClass();
	}

	@Before
	public void setUp() {
		StendhalRPZone zone = new StendhalRPZone("admin_test");
		PlayerTestHelper.generateNPCRPClasses();
		new HistorianGeographerNPC().configureZone(zone, null);
		npc = SingletonRepository.getNPCList().get("Zynn Iwuhos");
		en = npc.getEngine();

		AbstractQuest quest = new MeetZynn();
		quest.addToWorld();

		player = PlayerTestHelper.createPlayer("bob");
	}

	@Test
	public void testQuest() {

		npc = SingletonRepository.getNPCList().get("Zynn Iwuhos");
		en = npc.getEngine();

		en.step(player, "hi");
		en.step(player, "history");
		assertEquals(player.getXP(),5);
		
		en.step(player, "news");
		assertEquals(player.getXP(),10);
		
		en.step(player, "geography");
		assertEquals(player.getXP(),15);

		en.step(player, "places");
		assertEquals(player.getXP(),20);
		
		en.step(player, "Faiumoni");
		assertEquals(player.getXP(),25);
		
		en.step(player, "Semos");
		assertEquals(player.getXP(),30);
		
		en.step(player, "Ados");
		assertEquals(player.getXP(),35);
		
		en.step(player, "Or'ril");
		assertEquals(player.getXP(),40);
		
		en.step(player, "Nalwor");
		assertEquals(player.getXP(),45);
		
		en.step(player, "Deniran");
		assertEquals(player.getXP(),50);
		
		en.step(player, "use");
		assertEquals(player.getXP(),55);
		
		en.step(player, "levels");
		assertEquals(player.getXP(),60);
		
		en.step(player, "naming");
		assertEquals(player.getXP(),65);
		
		en.step(player, "positioning");
		assertEquals(player.getXP(),70);
		
		en.step(player, "get");
		assertEquals(player.getXP(),75);
		
		en.step(player, "SPS");
		assertEquals(player.getXP(),80);
		
		en.step(player, "Io");
		assertEquals(player.getXP(),85);

	}
}
