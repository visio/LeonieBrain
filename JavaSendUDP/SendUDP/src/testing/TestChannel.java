package testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

import udp.SendUDP;

public class TestChannel
{
	/**
	 * Demo app to send Strings via UDP using channels
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		System.out.println("Starting...");

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		String sentence = null;

		InetAddress senderAdress = InetAddress.getLoopbackAddress();// InetAddress.getLocalHost();// getByName("134.103.110.161");
		int senderPort = 9999;
		SendUDP ssc = new SendUDP(senderAdress, senderPort);
		
		InetAddress targetAdress = InetAddress.getLoopbackAddress();// InetAddress.getLocalHost();// getByName("134.103.110.161");
		int targetPort = 8888;
		
		while (true)
		{
			System.out.println("Type message: ");
			sentence = inFromUser.readLine();
//			sentence = "Test";
			ssc.sendChannel(sentence, targetAdress, targetPort);
		}
	}
}
