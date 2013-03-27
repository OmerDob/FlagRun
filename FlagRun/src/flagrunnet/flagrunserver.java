package flagrunnet;

import java.util.Observable;

public class flagrunserver 
{
	// Data members /////////////////////////////////////////////////////////////////////
	private Thread m_udpthread;
	private Thread m_tcpthread;
	private flugrunserverudpthread m_udplistener;
	private flagrunservertcpthread m_tcplistener;
	
	// Ctor & Dtor //////////////////////////////////////////////////////////////////////
	
	public flagrunserver()
	{
		m_udplistener = new flugrunserverudpthread();
		m_tcplistener = new flagrunservertcpthread();
		m_udpthread = new Thread(m_udplistener);
		m_tcpthread = new Thread(m_tcplistener);
	}
	
	// Proporties ///////////////////////////////////////////////////////////////////////
	
	public Observable getUdpMessageEvent()
	{
		return m_udplistener.m_udpmessageevent;
	}
	
	public Observable getTcpMessageEvent()
	{
		// TODO : implament
		return null;
	}
	
	// Public methods ///////////////////////////////////////////////////////////////////
	
	public void startServer()
	{
		m_udpthread.start();
		m_tcpthread.start();
	}
	
	/**
	 * Stops server
	 */
	public void stopServer()
	{
		m_udpthread.interrupt();
		m_tcpthread.interrupt();
	}
}

