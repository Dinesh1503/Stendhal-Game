package games.stendhal.server.entity.status;
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
//import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.assertNotNull;

//import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.core.engine.StendhalRPZone;
//import games.stendhal.server.core.engine.SingletonRepository;
//import games.stendhal.server.entity.item.ConsumableItem;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.maps.MockStendlRPWorld;
import marauroa.common.Log4J;
//import games.stendhal.server.maps.MockStendlRPWorld;
import utilities.PlayerTestHelper;
//import static org.junit.Assert.*;
import utilities.RPClass.ItemTestHelper;


public class SleepingStatusTests {
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


	
	@Test
	public void testSleepingStatusExists() {
		SleepingStatus status = new SleepingStatus();
		assertNotNull(status);
	}
	
	@Test
	public void SleepingStatusTest() {
		SleepingStatus status = new SleepingStatus();
		assertTrue(status.getStatusType().equals(StatusType.SLEEPING));
	}
	
	/*
	 * Test if the healing status heals a player.
	 */
	@Test
	public void testHealingSleepingStatus() {

		final Player sleep = PlayerTestHelper.createPlayer("sleepingBOB");
		
		final Player awake = PlayerTestHelper.createPlayer("awakeBOB");

		
		sleep.damage(15, null);
		awake.damage(15, null);
		
		SleepingStatusHandler Handler = new SleepingStatusHandler();
		StatusList StatusList = new StatusList(sleep);
		SleepingStatus Status = new SleepingStatus();
		
		Handler.inflict(Status, StatusList, null);
		
		assertTrue(sleep.getHP() > awake.getHP());
	}

}
