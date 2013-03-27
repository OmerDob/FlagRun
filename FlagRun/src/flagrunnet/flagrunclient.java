package flagrunnet;

import java.io.*;
import java.net.*;

import globaldata.*;

/**
 * Flag Run Client
 * @author Maxim Arav
 * @since 27/03/2013
 */
public class flagrunclient
{
	/// Data Members ////////////////////////////////////////////////////////////////////
	private DatagramSocket m_clientSocket;
	private InetAddress m_serverAdress;
	private Socket m_tcpSocket; 
	
	/// Ctor & Dtor /////////////////////////////////////////////////////////////////////
	
	/**
	 * The Ctor of the class
	 */
	public flagrunclient()
	{
		try {
			m_serverAdress = InetAddress.getByName(netsettings.SERVER_IP);
			m_clientSocket = new DatagramSocket();
			m_tcpSocket = new Socket(m_serverAdress, netsettings.CLIENT_PORT_TCP);
		} catch (SocketException e) {
			// TODO : add handle
		} catch (UnknownHostException e) {
			// TODO : add handle
		} catch (IOException e) {
			// TODO : add handle
		}
	}
	
	/// Public Methods //////////////////////////////////////////////////////////////////
	
	/**
	 * Starts the client get loop
	 */
	public void startClient()
	{
		/*Thread t = new Thread(new Receive());
		t.start();*/
	}
	
	/**
	 * 
	 * @param cl The class to serilaze and send
	 */
	public void sendUdpClass(Serializable cl)
	{
		byte[] yourBytes = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;
	
		  try {
			out = new ObjectOutputStream(bos);
		    out.writeObject(cl);
		    yourBytes = bos.toByteArray();

		} catch (IOException e) {

		}   

		if (yourBytes != null) sendUdpMessage(yourBytes);
	}
	
	/**
	 * Sends udp message to server
	 * @param message The message to send to client
	 */
	public void sendUdpMessage(byte[] message)
	{
		// Create a package to send
		DatagramPacket pack = new DatagramPacket(message, message.length);
		pack.setPort(netsettings.CLIENT_PORT_UDP);
		pack.setAddress(m_serverAdress);
		
		try {
			m_clientSocket.send(pack);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param message The message to send to server
	 */
	public void sendTcpMessage(byte[] message)
	{
		
	}
	
}
