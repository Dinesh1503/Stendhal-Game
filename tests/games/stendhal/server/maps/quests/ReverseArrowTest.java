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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.item.token.Token;
import games.stendhal.server.entity.mapstuff.portal.Door;
import games.stendhal.server.entity.mapstuff.sign.Sign;
import games.stendhal.server.entity.npc.NPCList;
import games.stendhal.server.maps.MockStendlRPWorld;
//import games.stendhal.server.maps.quests.ReverseArrow.ReverseArrowCheck;
import marauroa.common.game.RPClass;
import utilities.PlayerTestHelper;
import utilities.QuestHelper;

public class ReverseArrowTest {

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MockStendlRPWorld.get();
		QuestHelper.setUpBeforeClass();
		StendhalRPZone zone = new StendhalRPZone("int_ados_reverse_arrow");
		MockStendlRPWorld.get().addRPZone(zone);
		MockStendlRPWorld.get().addRPZone(new StendhalRPZone("0_semos_mountain_n2"));

		if (!RPClass.hasRPClass("door")) {
			Door.generateRPClass();
		}
		if (!RPClass.hasRPClass("sign")) {
			Sign.generateRPClass();
		}

	}
	
	public List<Token> tokens;

	@Before
	public void setUpArrow1() {	
		tokens = new LinkedList<Token>();
        // arrow 1:            			
		// * * 0 * * 
		// * 1 2 3 * 
		// 4 5 6 7 8
		final Token token0 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token0.setPosition(10, 8);
		tokens.add(token0);
		final Token token1 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token1.setPosition(9, 9);
		tokens.add(token1);
		final Token token2 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token2.setPosition(10, 9);
		tokens.add(token2);
		final Token token3 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token3.setPosition(11, 9);
		tokens.add(token3);
		final Token token4 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token4.setPosition(8, 10);
		tokens.add(token4);
		final Token token5 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token5.setPosition(9, 10);
		tokens.add(token5);
		final Token token6 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token6.setPosition(10, 10);
		tokens.add(token6);
		final Token token7 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token7.setPosition(11, 10);
		tokens.add(token7);
		final Token token8 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token8.setPosition(12, 10);
		tokens.add(token8);
		
	}
	@Before
	public void setUpArrow2() {	
		tokens = new LinkedList<Token>();
        // arrow 2:            			
		// * * 0 * * 
		// * 1 * 2 * 
		// 3 4 5 6 7
		// * * 8 * *
		final Token token0 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token0.setPosition(10, 8);
		tokens.add(token0);
		final Token token1 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token1.setPosition(9, 9);
		tokens.add(token1);
		final Token token2 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token2.setPosition(11, 9);
		tokens.add(token2);
		final Token token3 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token3.setPosition(8, 10);
		tokens.add(token3);
		final Token token4 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token4.setPosition(9, 10);
		tokens.add(token4);
		final Token token5 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token5.setPosition(10, 10);
		tokens.add(token5);
		final Token token6 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token6.setPosition(11, 10);
		tokens.add(token6);
		final Token token7 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token7.setPosition(12, 10);
		tokens.add(token7);
		final Token token8 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token8.setPosition(10, 11);
		tokens.add(token8);
		
	}
	
	public void setUpWrongAnswer() {	
		tokens = new LinkedList<Token>();
        // wrong answer:            			
		// * * * * * 
		// 0 1 * 2 * 
		// 3 4 5 6 7
		// * * 8 * *
		final Token token0 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token0.setPosition(8, 9);
		tokens.add(token0);
		final Token token1 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token1.setPosition(9, 9);
		tokens.add(token1);
		final Token token2 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token2.setPosition(11, 9);
		tokens.add(token2);
		final Token token3 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token3.setPosition(8, 10);
		tokens.add(token3);
		final Token token4 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token4.setPosition(9, 10);
		tokens.add(token4);
		final Token token5 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token5.setPosition(10, 10);
		tokens.add(token5);
		final Token token6 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token6.setPosition(11, 10);
		tokens.add(token6);
		final Token token7 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token7.setPosition(12, 10);
		tokens.add(token7);
		final Token token8 = (Token) SingletonRepository.getEntityManager().getItem("arrow game token");
		token8.setPosition(10, 11);
		tokens.add(token8);
		
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		MockStendlRPWorld.reset();
		NPCList.get().clear();
	}


	/**
	 * Tests for getSlotName.
	 */
	@Test
	public void testGetSlotName() {
		assertEquals("reverse_arrow", new ReverseArrow().getSlotName());
	}

	/**
	 * Tests for addToWorld.
	 */
	@Test
	public void testAddToWorld() {

		ReverseArrow arrowquest = new ReverseArrow();
		arrowquest.addToWorld();
	}
	
	@Test
	public void testCheck() {
		ReverseArrow arrowquest = new ReverseArrow();
		ReverseArrow.ReverseArrowCheck check = arrowquest.new ReverseArrowCheck();
		arrowquest.addToWorld();
		arrowquest.player = PlayerTestHelper.createPlayer("bob");
		boolean result = check.checkBoard();
		assertFalse(result);
		
		setUpArrow1();
		arrowquest.tokens = tokens;
		result = check.checkBoard();
		assertTrue(result);		
		
		setUpArrow2();
		arrowquest.tokens = tokens;
		result = check.checkBoard();
		assertTrue(result);
		
		setUpWrongAnswer();
		arrowquest.tokens = tokens;
		result = check.checkBoard();
		assertFalse(result);
		
	}


	/**
	 * Tests for finish.
	 */
	@Test
	public void testFinish() {
		ReverseArrow arrowquest = new ReverseArrow();
		arrowquest.addToWorld();
		arrowquest.player = PlayerTestHelper.createPlayer("bob");
		assertNotNull(arrowquest.player);
		arrowquest.finish(false, null);
		assertNotNull(arrowquest.player);

		arrowquest.finish(true, null);
		assertNull(arrowquest.player);
	}

}
