package games.stendhal.server.entity.status;

public class SleepingStatus extends Status{

	/**
	 * Create the status
	 */
	public SleepingStatus() {
		super("sleeping");
	}

	/**
	 * returns the status type
	 *
	 * @return StatusType
	 */
	@Override
	public StatusType getStatusType() {
		return StatusType.SLEEPING;
	}	
}
