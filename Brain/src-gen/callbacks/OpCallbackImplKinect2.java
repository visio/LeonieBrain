package callbacks;

import communication.Communication;
import main.Start;
import modules.Modules;

public class OpCallbackImplKinect2 implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCIKinect2OperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCIKinect2OperationCallback
{
	
	private Modules modules = Start.getModules();
	
	public void sendNoiseDetectionOnOff(boolean inOnOff){
		Communication.sendMessage("#NOISEDETECTION#" + (inOnOff?"1":"0") + "#", modules.get("NoiseDetection"));
	}
}
