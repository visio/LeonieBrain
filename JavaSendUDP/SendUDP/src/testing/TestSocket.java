package testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

import udp.SendUDP;

/**
 * Demo app to send Strings via UDP using simple sockets
 * 
 * @param args
 */
public class TestSocket {
	public static void main(String[] args) {
		System.out.println("Starting...");

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		String sentence = null;

		while (true) {
			try {
				System.out.println("Type message: ");
				sentence = inFromUser.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try
			{
				InetAddress senderAdress = InetAddress.getLoopbackAddress();
				int senderPort = 9999;
				new SendUDP(senderAdress, senderPort).sendSocket(sentence, InetAddress.getByName("192.168.178.38"), 8888);
			} catch (UnknownHostException e)
			{
				e.printStackTrace();
			}
		}
	}
}
