package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import states.*;



public class Cat {
	private static final Logger logger = LogManager.getLogger();

	private State state;

	// initially, animals are sleeping

	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;

		state = new SleepingState(sleep);
	}

	public void tick(){
		this.state = state.tick(this);

	}

	/**
	 * This would be a user interaction: feed the cat to change its state!
	 */
	public void feed(){
		if (!isHungry())
			throw new IllegalStateException("Can't stuff a cat...");

		logger.info("You feed the cat...");

		// change state and reset the timer
		this.state = ((HungryState) state).feed(this);
	}

	public int getDigest(){
		return digest;
	}
	public  int getSleeping(){
		return sleep;
	}

	public int getAwake(){
		return awake;
	}
	public boolean isAsleep() {
		return state instanceof SleepingState;
	}

	public boolean isPlayful() {
		return state instanceof PlayfulState;
	}

	public boolean isHungry() {
		return state instanceof HungryState;
	}

	public boolean isDigesting() {return state instanceof DigestingState;}

	public boolean isDead() {
		return state instanceof DeadState;
	}

	@Override
	public String toString() {
		return name;
	}

}
