package states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;
public class SleepingState extends State{

    public SleepingState(int duration){
        super(duration);
    }

    public State successor(Cat Momo){
        logger.info("I am getting HUNGRY");
        return new HungryState(Momo.getAwake());
    }
}
