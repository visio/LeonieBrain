package modules.parser;

import org.yakindu.scr.brain.BrainStatemachine;
import main.*;

public class Attr2 implements Iparser{

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {
		   System.out.println("Attractiveness: " + data);
		    float att = Float.parseFloat(data);
		    brain.getSCICurrPerson().setAttractiveness(att);
		    start.getPersonList().save();
		    return true;
		}
}
