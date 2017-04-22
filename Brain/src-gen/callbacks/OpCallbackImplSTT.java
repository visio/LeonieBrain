package callbacks;


import communication.Communication;
import main.Start;
import modules.Modules;
import modules.parser.STT;

public class OpCallbackImplSTT implements
	org.yakindu.scr.braganca.IBragancaStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.speechandpersonrecognition.ISpeechAndPersonRecognitionStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.test_stt_smalltalk.ITest_STT_SmalltalkStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.test_stt_yesno.ITest_STT_YesNoStatemachine.SCISTTOperationCallback,
	org.yakindu.scr.test_stt_names.ITest_STT_NamesStatemachine.SCISTTOperationCallback
{
	
	private Modules modules = Start.instanceOf().getModules();
	
	public String getSpokenText() {
		return ((STT)modules.getParser("STT")).getSpokenText();
	}
	
	public String getAnswer() {
		return ((STT)modules.getParser("STT")).getAnswer();
	}

	public String getInstruction() {
		return ((STT)modules.getParser("STT")).getInstruction();
	}

	public String getObject() {
		return ((STT)modules.getParser("STT")).getObject();
	}

	public void sendSpeechDetectionOff() {
		Communication.sendMessage("#STT#0#", modules.get("STT"));
	}

	public void sendSpeechDetectionSmalltalk() {
		Communication.sendMessage("#STT#1#", modules.get("STT"));
		
		STT stt = (STT)Start.getModules().getParser("STT");
		stt.setSpokenText("");
		stt.setInstruction("");
		stt.setObject("");
		stt.setSpokenTextReceived(false);
		stt.setIncomprehensible(false);
		stt.setActionReceived(false);
	}

	public void sendSpeechDetectionYesNo() {
		Communication.sendMessage("#STT#2#", modules.get("STT"));
		
		STT stt = (STT)Start.getModules().getParser("STT");
		stt.setSpokenText("");
		stt.setInstruction("");
		stt.setObject("");
		stt.setSpokenTextReceived(false);
		stt.setIncomprehensible(false);
		stt.setActionReceived(false);
	}

	public void sendSpeechDetectionName() {
		Communication.sendMessage("#STT#3#", modules.get("STT"));
		
		STT stt = (STT)Start.getModules().getParser("STT");
		stt.setSpokenText("");
		stt.setInstruction("");
		stt.setObject("");
		stt.setSpokenTextReceived(false);
		stt.setIncomprehensible(false);
		stt.setActionReceived(false);
	}



}
