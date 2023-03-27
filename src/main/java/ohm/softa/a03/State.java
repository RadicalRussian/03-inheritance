package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
    protected static final Logger logger = LogManager.getLogger();

    private int t = 0;

    public int getTime() {
        return t;
    }

    public int getDuration() {
        return duration;
    }

    private final int duration;

    protected State(int duration){
        this.duration = duration;
    }

    final State tick(Cat kitten) {
        // time goes by...
        t = t + 1;

        if(t < duration) {
            logger.info("Still in {}", getClass().getSimpleName());
            return this;
        } else {
            return successor(kitten);
        }
    }

    public abstract State successor(Cat kitten);

}


