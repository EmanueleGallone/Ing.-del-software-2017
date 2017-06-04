package it.polimi.ingsw.ps11.network.genericMessage;

public abstract class Message<T> {

	private T content;
	
	public Message(T message) {
		this.content = message;
	}
	
	
	public T getContent(){
		return content;
	}
	
	public abstract void gAccept(GenericRecogniser recogniser);

}
