package it.polimi.ingsw.ps11.posNetwork.messages;

public abstract class Message<T> {

	private T content;
	
	public Message(T message) {
		this.content = message;
	}
	
	
	public T getContent(){
		return content;
	}
	
	public abstract void gAccept(GenericRecogniser recogniser);
	
	/*
	public Class<?> getType() {
		
		Class<?> klass;
		
		try {
			klass = Class.forName(type);
		} catch (ClassNotFoundException e) {
			klass = Object.class;
			e.printStackTrace();
		}
		return klass;
	}
	*/
}
