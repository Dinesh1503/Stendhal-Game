package games.stendhal.server.entity.status;

//import games.stendhal.server.core.events.TurnNotifier;
import games.stendhal.server.entity.Entity;
import games.stendhal.server.entity.RPEntity;

///import games.stendhal.server.core.events.TurnListener;
//import games.stendhal.server.core.events.TurnNotifier;
//import games.stendhal.server.entity.Entity;

public class SleepingStatusHandler implements StatusHandler<SleepingStatus> {

	
	/**
	 * inflicts a status
	 *
	 * @param status Status to inflict
	 * @param statusList StatusList
	 * @param attacker the attacker
	 */
	@Override
	public void inflict(SleepingStatus status, StatusList statusList, Entity attacker) {
	
		RPEntity entity = statusList.getEntity();
		entity.heal();
		statusList.addInternal(status);
		
	}
	
	/**
	 * removes a status
	 *
	 * @param status Status to inflict
	 * @param statusList StatusList
	 */
	@Override
	public void remove(SleepingStatus status, StatusList statusList) {
		statusList.removeInternal(status);
	}
}
