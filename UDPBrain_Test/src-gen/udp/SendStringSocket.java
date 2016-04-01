package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SendStringSocket {
	
	private DatagramSocket socket;

	/**
	 * 
	 * @param message the Message
	 * @param targetAdress IP adress of the target
	 * @param targetPort Port of the target
	 */
	public void send(String message, InetAddress targetAdress, int targetPort)
	{
		DatagramPacket request = null;
		try
		{
			socket = new DatagramSocket();
			byte[] sendData = message.getBytes();

			request = new DatagramPacket(sendData, sendData.length, targetAdress, targetPort);
			socket.send(request);
		} catch (SocketException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Packet versendet: " + request.getAddress() + ":" + request.getPort() + " -> "
				+ new String(request.getData()));
	}
}
