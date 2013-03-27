package flagrunnet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


import java.util.Observable;          //Observable is here
import globaldata.netsettings;

/**
 * 
 * @author Maxim Arav
 * @since 27/03/2013
 */
public class flugrunserverudpthread implements Runnable
{
	public class servergotudpmessage extends Observable {}
	public servergotudpmessage m_udpmessageevent;
	
	@Override
	public void run() 
	{
        DatagramSocket serverSocket;
        byte[] receiveData = new byte[1024];
        
		try 
		{
			serverSocket = new DatagramSocket(netsettings.SERVER_PORT_UDP);
		} 
		catch (SocketException e1) 
		{
			return;
		}
           
        while(true)
        {
        	try 
        	{
	           DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	           serverSocket.receive(receivePacket);
	           InetAddress IPAddress = receivePacket.getAddress();
	           gotmessage mes = new gotmessage();
	           mes.m_user = IPAddress;
	           mes.m_dataGot = receiveData;
	           m_udpmessageevent.notifyObservers(mes);
        	} 
        	catch (IOException e) 
        	{
        		// TODO : do something with it
        		return;
        	}
        }
	}
}
