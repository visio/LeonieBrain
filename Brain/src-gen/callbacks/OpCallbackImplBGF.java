package callbacks;

import java.util.Random;

import Persons.PersonList;
import main.Start;
import modules.Modules;

public class OpCallbackImplBGF implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIBGFOperationCallback
{
	
	private PersonList personList = Start.instanceOf().getPersonList();
	private Modules modules = Start.instanceOf().getModules();
	
	
	// ---- Brain General Functions Interface ---- //
	public void printToConsole(String msg){
		System.out.println(msg);
		System.out.println(personList.toString());
		System.out.println(Start.instanceOf().getPersonList().getCurrPerson().isKnown());
	}
	
	public long getRandNum(long max) {
		Random randGen = new Random();
		long randNum = randGen.nextInt((int)max);
		System.out.println("New random number: " + randNum);
		return randNum;
	}
}
