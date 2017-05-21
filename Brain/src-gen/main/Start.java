package main;

import java.util.List;
import java.util.Vector;

import Persons.PersonList;
import communication.Communication;
import modules.Modules;

public class Start{
	
	private static Start instance = null;
	
	private Statemachine statemachine;
	private static PersonList personList;
	private static Modules modules;
	private static GUI gui;
	
	// ---- Communication -----------------------------------------------------
	static private int UDPListeningPort = 50000;
	static private int TCPListeningPort = 50001;
	// ------------------------------------------------------------------------
	
	public static void main(String[] args) throws Exception{
		Start t = Start.instanceOf();
		
		//Load modules and personList
		modules = new Modules(t);
		personList = new PersonList();
		
		// Start listening for messages via UDP or TCP
		Communication.receive(modules.get("brain"));
		
		//Show GUI
		gui = new GUI(t);
		
	}
	
	
	private Start(){
//----> For using Brain w/o CNS Monitor:
//		modules.setIpAndPortOldSchool();
		
//---->	For testing personList:
//		Person p = new Person();
//		p.setGender(false, brain);
//		p.setFirstName("Leonie", brain);
//		personList.addPerson(p);
//		personList.save();
	}
	
	public static Start instanceOf(){
		if(instance==null)
			instance = new Start();
		
		return instance;
	}
	
	public void runStatemachine(Start inStart){
		
		//Remove all parsed informations in the modules
		inStart.modules.removeParsedInformation();
		
		Statemachine sm = this.statemachine;
		System.out.println("----------  Statemachine " + this.statemachine.getName() + " start  ----------");
		sm.initAndEnter();
		
		new Thread(new Runnable() {
		    public void run() {
		    	while (statemachine != null)
				{
		    		sm.runCycle();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		    	
		    	System.out.println("----------   Statemachine " + sm.getName() + " end   ----------");
		    }
		}).start();
		
	}
	
	public static int getUDPListeningPort() {
		return UDPListeningPort;
	}


	public static int getTCPListeningPort() {
		return TCPListeningPort;
	}


	public void setStatemachine(String statemachineName, Start inStart){
		if (statemachineName != null) {
			this.statemachine = new Statemachine(statemachineName, inStart); //Braganca, SpeechAndPersonRecognition, ...
			//this.statemachine.re
		}else{
			this.statemachine = null;
		}
		
	}
	
	public Statemachine getStatemachine(){
		return statemachine;
	}

	public static PersonList getPersonList(){
		return personList;
	}

	public static Modules getModules(){
		return modules;
	}
	
	public GUI getGui(){
		return gui;
	}
	
	public Vector<String> getStatemachineNames(){
		List<Class<?>> classes = ClassFinder.find("org.yakindu.scr");
		Vector<String> classNames = new Vector<String>();
		for (Class<?> clazz : classes) {
			if (clazz.getSimpleName().contains("Statemachine") && !clazz.isInterface()) {
				classNames.add(clazz.getSimpleName().substring(0, clazz.getSimpleName().lastIndexOf("Statemachine")));
				//classNames.add(clazz.getSimpleName());
			}
		}
		//System.out.println(classNames.toString());
		return classNames;
	}
}
