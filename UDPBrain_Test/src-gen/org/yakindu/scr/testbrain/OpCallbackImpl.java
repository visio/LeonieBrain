package org.yakindu.scr.testbrain;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.yakindu.scr.testbrain.ITestBrainStatemachine.SCIPrintDataInterfaceOperationCallback;
import org.yakindu.scr.testbrain.ITestBrainStatemachine.SCIUdpInterfaceOperationCallback;

import mainTest.Test;
import udp.ReceiveUDP;
import udp.SendStringSocket;

public class OpCallbackImpl implements SCIUdpInterfaceOperationCallback, SCIPrintDataInterfaceOperationCallback
{
//	@Override
//	public void receive()
//	{
//		String result = null;
//		try
//		{
//			ReceiveUDP receiveUDP = new ReceiveUDP(InetAddress.getByName("134.103.109.51"), 8888);
//
//			result = receiveUDP.receiveChannel(true, InetAddress.getByName("134.103.205.227"), 9999);
//		} catch (UnknownHostException e)
//		{
//			e.printStackTrace();
//		}
//
//		Test.instanceOf().getTestBrain().getSCIUdpInterface().setData(result.trim());
//		System.out.println("receive test output: " + result);
//	}
	
	@Override
	public void receive()
	{
		String result = null;
		ReceiveUDP receiveUDP = null;
		try
		{
			receiveUDP = new ReceiveUDP(InetAddress.getByName("134.103.109.51"), 8888);
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result = receiveUDP.receiveSocket();
		Test.instanceOf().getTestBrain().getSCIUdpInterface().setData(result.trim());
		System.out.println("receive test output: " + result);
	}
	
	@Override
	public void print()
	{
		SendStringSocket sss = new SendStringSocket();
		try
		{
			sss.send(Test.instanceOf().getTestBrain().getSCIUdpInterface().getData(), InetAddress.getByName("134.103.120.108"), 8888);
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
//		System.out.println(Test.instanceOf().getTestBrain().getSCIUdpInterface().getData());		
	}
}
