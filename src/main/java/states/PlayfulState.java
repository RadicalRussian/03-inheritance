package states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;
public class PlayfulState extends State{

    PlayfulState(int duration){
        super(duration);
    }

    public State successor(Cat cat){
        logger.info("GETTING TIRED");
        return new SleepingState(cat.getSleeping());
    }
}
