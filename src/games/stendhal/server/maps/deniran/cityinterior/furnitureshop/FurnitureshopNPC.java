/***************************************************************************
 *                     Copyright © 2020 - Arianne                          *
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

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import games.stendhal.server.core.config.ZoneConfigurator;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.core.pathfinder.FixedPath;
import games.stendhal.server.core.pathfinder.Node;
import games.stendhal.server.entity.CollisionAction;
import games.stendhal.server.entity.Outfit;

import games.stendhal.server.entity.npc.SpeakerNPC;


public class FurnitureshopNPC implements ZoneConfigurator {

	@Override
	public void configureZone(final StendhalRPZone zone, final Map<String, String> attributes) {
		buildNPC(zone);
	}

	private void buildNPC(final StendhalRPZone zone) {
		final SpeakerNPC npc = new SpeakerNPC("Gareth");

		final List<Node> nodes = Arrays.asList(
				new Node(6, 5),
				new Node(9, 5)
		);

		
		npc.addGreeting("Welcome to Deniran's furniture shop. Ask me about my #job.");
		npc.addJob("I manage this furniture shop. Ask me for #help");
		npc.addHelp("If you would like to sell something, ask me about my #prices and I will tell you what I #offer.");
		

		

		npc.setPosition(10, 19);
		npc.setPath(new FixedPath(nodes, true));
		npc.setCollisionAction(CollisionAction.STOP);
		npc.setOutfit(new Outfit("body=1,head=0,mouth=2,eyes=1,dress=46,mask=1,hair=3"));

		zone.add(npc);
	}
}

