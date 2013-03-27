package logic;

import logic.messages.IMessage;

public interface IObserver {

	void notify(Observable sender, IMessage eventMessage);
	
}
