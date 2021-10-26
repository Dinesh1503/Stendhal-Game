package games.stendhal.server.events;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import games.stendhal.server.entity.player.*;
import utilities.PlayerTestHelper;

import org.junit.Test;

public class BestiaryEventTest {

	@Test
	public void test() {
	final Player tester = PlayerTestHelper.createPlayer("tester");
	
	BestiaryEvent bestiary = new BestiaryEvent(tester);
	assertThat(bestiary.get("enemies"), is(";;"));
	
	}

}

// need to check list called sb for any entries with name = "???
//  split sb by semi colon - that becomes a list then we iterate through the list 
// toString method to make sb into a string 
// so 
// sb to string -> sb_string 
// split sb_string by semi colon 
// create new bestiary and check if sb is empty assert.equals(sb, "")

//@Test
//public void testTextEvent() {
//	TextEvent event = new TextEvent("text");
//	
//

