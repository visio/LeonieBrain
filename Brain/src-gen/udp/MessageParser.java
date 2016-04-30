package udp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.yakindu.scr.brain.BrainStatemachine;

import main.Start;
import vbrain.Person;
import vbrain.PersonList;

public class MessageParser {

	// Expected form of message: #SENDER#DATA
	public static boolean ParseMessage(String message) {
		//System.out.println(message);
		Start start = Start.instanceOf();
		BrainStatemachine brain = start.getBrain();
		PersonList personList = Start.getPersonList();

		// Get sender and process message
		String sender;
		String data;

		// Capture sender in group 1 and message in group 2
		// Pattern explanation:
		// \\A# --> first character is a '#'
		// ([\\w]*)# --> capture any number of word-characters, up to the last #
		// in the string. Store in group 1
		// ([\\S]*) --> capture every following non-whitespace-character in
		// group 2
		Pattern pattern = Pattern.compile("\\A#([\\w]*)#([\\S\\D]*)#");
		Matcher m = pattern.matcher(message);
		if (m.find()) {

			sender = m.group(1);
			data = m.group(2);

			//System.out.println(sender + ": " + data);

			// Decide what should be done, depending on sender
			switch (sender) {
			case "VBRAIN": // Pattern vbrainPattern =
							// Pattern.compile("\\A#([\\w]*)#([\\S]*)");
							// Matcher vbrainbM = vbrainPattern.matcher(data);
							// System.out.println(data);
							// if(vbrainbM.find()){

				if (data.contains("#STAT#")) {
					String dataStat = data.substring(6);
					//System.out.println("Statische Daten: " + dataStat);
					String[] attributePartsVBS = dataStat.split(";");

					int faceId = Integer.parseInt(attributePartsVBS[0]);
					System.out.println("Face ID: " + faceId);

					
					if (personList.getPersonByFaceID(faceId) != null) {
						// Person already exists
						System.out.println("Person exists");

					} else {

						Person p = new Person(personList.getUnusedPersonID(), brain, dataStat);
						System.out.println(p.toString());
						personList.addPerson(p);
						System.out.println("Person ID: " + p.getPersonID());
					}
					
					personList.setCurrPersonByFaceID(faceId);

				} else if (data.contains("#DYN#")) {
					String dataDyn = data.substring(5);
					//System.out.println("Dynamische Daten: " + dataDyn);
					String[] attributePartsVBD = dataDyn.split(";");

					if (attributePartsVBD[0].contains("1")) {
						//System.out.println("Face found");


						if(attributePartsVBD.length > 1){
							//Gesicht hat schon eine FaceID von VBRain bekommen --> nach 5 Frames
							brain.getSCIVBrain().setCountFoundFaces(1);
							int faceId = Integer.parseInt(attributePartsVBD[1]);
							System.out.println("Face ID: " + faceId);
							Person p = personList.getPersonByFaceID(faceId);
							if (p != null) {
								p.addDynData(dataDyn, brain);
								System.out.println(p.getCurrDynData().toString());
							}
							personList.setCurrPersonByFaceID(faceId);
						}else{
							//noch keine FaceID, weil noch vor 5 Frames
							//System.out.println("No face ID");
							personList.setCurrPerson(null);
						}

					} else {
						brain.getSCIVBrain().setCountFoundFaces(0);
						// System.out.println(" no face");
					}
				} else if (data.contains("#EMOTION#")) {
					String dataEmo = data.substring(9);
					// Emotion e;
					// e.fromInt(Integer.parseInt(vbrainbM.group(2)));

					System.out.println("Emotion: " + dataEmo);

					Person p = personList.getCurrPerson();
					if (p != null) {
						p.getCurrDynData().setEmotion(Integer.parseInt(dataEmo), brain);
						System.out.println(p.toString());
					}
				}
				// }

				// TODO: Die Variablen

				return true;
			// break;

			case "HBRAIN":
				//System.out.println("HBrain: " + data);
				if (data.contains("1")) {
					brain.getSCIHBrain().setTTSReady(false);
					System.out.println("TSS jabbering");
				} else if(data.contains("0")){
					brain.getSCIHBrain().setTTSReady(true);
					System.out.println("TTS ready");
				}

				return true;
			// break;

			case "NOISEDETECTION":
				// #NOISEDETECTION#1;30;32# [0]: (bool)found [1]:
				// (int)angle_body [2]: (int)angle_noise
				String[] attributePartsND = data.split(";");
				if (attributePartsND[0].contains("1")) {
					System.out.println("Noise detected: " + attributePartsND[1]);
					brain.getSCIKinect2().setNoiseDetected(true);
					brain.getSCIKinect2().setNoiseAngle(Integer.parseInt(attributePartsND[1]));
				} else {
					System.out.println("No noises");
					brain.getSCIKinect2().setNoiseDetected(false);
				}
				return true;
			// break;

			case "HANDGESTURES":
				String[] attributePartsHG = data.split(";");
				// System.out.println(attributePartsHG[0]);
				if (attributePartsHG[0].contains("1")) {
					System.out.println("Handgestutre detected: " + attributePartsHG[1]);
					brain.getSCILeapMotion().setGestureDetected(true);
					brain.getSCILeapMotion().setGesture(attributePartsHG[1]);
				} else {
					System.out.println("Handgestutre not detected");
					brain.getSCILeapMotion().setGestureDetected(true);
				}
				return true;
			// break;

			case "SMARTCONTROL":
				System.out.println("SMARTCONTROL");

				return true;
			// break;

			case "STT":
				System.out.println("Input text: " + data);
				brain.getSCISTT().setSpeakerMsg(data);
				String filterBubble = brain.getSCISTT().getFilterBubble();
				
				if(filterBubble == ""){
					if (data.contains("yes") || data.contains("yep") ||data.contains("ja") ||data.contains("si") ||data.contains("yeah") ||data.contains("correct") ||data.contains("ok") ||data.contains("alright")||data.contains("okay")){
						brain.getSCISTT().setFilteredMsg("yes");
					}
					
					if (data.contains("no") || data.contains("nope") ||data.contains("nein") ||data.contains("nada") ||data.contains("cancel") ||data.contains("nö")){
						brain.getSCISTT().setFilteredMsg("no");
					}
					
				}else{
					if (data.contains(filterBubble)){
						brain.getSCISTT().setFilteredMsg(data);
					}else{
						brain.getSCISTT().setFilteredMsg("");
					}
				}
				System.out.println("Filtered text: " + brain.getSCISTT().getFilteredMsg());
				
				brain.getSCISTT().setSTTReady(true);
				return true;
			// break;

			case "NAV":
				System.out.println("NAV: " + data);
				//Arrived waypoint by pilot:  #NAV##ARR_WP#1#   //#NAV##ARR_WP#1# (=> arrived at global waypoint 
				//Path blocked:  #NAV##PATH_BLOCKED#1#      	//#NAV##PATH_BLOCKED#1#  (=> path is blocked
				//Bumpered: #NAV##BUMPERED#1#            		//#NAV##BUMPERED#1#  (=> leonie is bumpered
				if (data.contains("#ARR_WP#")) {
					System.out.println("Arrived at next waypoint: ");
					brain.getSCIScitosRemoteControl().setArrivedWP(true);
				} else if (data.contains("#PATH_BLOCKED#1")) {
					System.out.println("No way found");
					brain.getSCIScitosRemoteControl().setBlocked(true);
				} else if (data.contains("#BUMPERED#1")) {
					System.out.println("Leonie was bumperd");
					brain.getSCIScitosRemoteControl().setBumpered(true);
				}

				return true;
			// break;

			case "ATTRACT":
				System.out.println("Attractiveness: " + data);
				return true;
			// break;

			case "":
			default:
				System.out.println(sender + ": " + data);
				return false;
			// break;
			}
		}

		System.out.println("Unfound: " + m.toString() + "\n" + message);

		return false;
	}

}
