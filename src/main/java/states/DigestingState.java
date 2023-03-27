package states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;
public class DigestingState extends State  {

    private final int remainingWakeTime;

    DigestingState(int duration, int remainingWakeTime){
        super(duration);
        this.remainingWakeTime = remainingWakeTime;
    }

    @Override
    public State successor(Cat kitten) {
        logger.info("Getting in a playful mood!");
        return new PlayfulState(remainingWakeTime - kitten.getDigest());
    }
}
