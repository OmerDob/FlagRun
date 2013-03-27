package logic.messages;

public class PropertyChanged implements IMessage {

	// Data Members
	private Object _updatedModel;
	private Object _propertyName;
	
	// Default Constructor
	public PropertyChanged(Object sender, Object propertyName)
	{
		set_updatedModel(sender);
		set_propertyName(propertyName);
	}
	
	// Getters & Setters
	public Object get_updatedModel() {
		return _updatedModel;
	}
	
	public void set_updatedModel(Object _updatedModel) {
		this._updatedModel = _updatedModel;
	}

	public Object get_propertyName() {
		return _propertyName;
	}

	public void set_propertyName(Object _propertyName) {
		this._propertyName = _propertyName;
	}
	
}
