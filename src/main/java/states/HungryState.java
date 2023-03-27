package states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;
public class HungryState extends State {

     HungryState(int duration ){
        super(duration);
    }

    public State feed(Cat Momo){
        logger.info("Now you feed me...");
        return new DigestingState(Momo.getDigest(), getDuration() - getTime());
    }

    @Override
    public State successor(Cat Momo) {
        logger.info("HUNGRY...");
        return new DeadState();
    }
}
