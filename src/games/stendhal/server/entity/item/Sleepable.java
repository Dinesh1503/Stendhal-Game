package games.stendhal.server.entity.item;

import java.util.Map;

import games.stendhal.server.entity.RPEntity;
import games.stendhal.server.entity.status.SleepingStatus;
import games.stendhal.server.entity.status.SleepingStatusHandler;
import games.stendhal.server.entity.status.StatusList;


/**
 * Consumable item that can be used to cure/prevent a single or multiple status effects.
 *
 */
public class Sleepable extends Item {

	/**
	 * Constructor: Creates a status-healing item.
	 *
	 * @param name
	 * @param clazz
	 * @param subclass
	 * @param attributes
	 */
	public Sleepable(final String name, final String clazz, final String subclass, final Map<String, String> attributes) {
		super(name, clazz, subclass, attributes);
		setMenu("Sleep|Use");
		
	}

	/**
	 * Copy constructor.
	 *
	 * @param item
	 * 			Item to copy.
	 */
	public Sleepable(final Sleepable item) {
		super(item);
	}

	/**c
	 * Initializes list of immunizations.
	 *
	 * @param i
	 * 			List of status effect names to be added.
	 */

	@Override
	public boolean onUsed(final RPEntity user) {
		SleepingStatusHandler handler = new SleepingStatusHandler();
		SleepingStatus sleeping = new SleepingStatus();
		StatusList sl = new StatusList(user);
		handler.inflict(sleeping, sl, null);
		handler.remove(sleeping, sl);
		
		return true;
	}
}
