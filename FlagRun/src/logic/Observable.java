package logic;

import java.util.ArrayList;

import logic.messages.IMessage;

public abstract class Observable {
	
	// Data Members
	private ArrayList<IObserver> _observersList;
	
	// Default constructor
	public Observable()
	{
		_observersList = new ArrayList<IObserver>();
	}

	public void subscribe(IObserver subscriber)
	{
		if (!_observersList.contains(subscriber))
		{
			_observersList.add(subscriber);
		}
	}
	
	public void unsubscribe(IObserver unsubscriber)
	{
		_observersList.remove(unsubscriber);
	}
	
	protected void notify(IMessage eventMessage)
	{
		for (IObserver currObserver : _observersList)
		{
			currObserver.notify(this, eventMessage);
		}
	}
}
