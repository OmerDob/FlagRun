package logic.messages;

public class UserMessage implements IMessage {
	
	// Data Members
	private String _messageText;
	private Boolean _isVibratingMessage;
	
	// Default Constructor
	public UserMessage(String messageText, Boolean isVibrating)
	{
		set_Message(messageText);
		set_IsVibratingMessage(isVibrating);
	}

	// Getters & Setters
	public String get_Message()
	{
		return (_messageText);
	}
	
	public void set_Message(String newMessage)
	{
		_messageText = newMessage;
	}
	
	public Boolean get_IsVibratingMessage()
	{
		return (_isVibratingMessage);
	}
	
	public void set_IsVibratingMessage(Boolean newValue)
	{
		_isVibratingMessage = newValue;
	}
	
}
