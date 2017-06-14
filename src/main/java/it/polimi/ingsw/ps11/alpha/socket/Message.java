package it.polimi.ingsw.ps11.alpha.socket;

public abstract class Message<T> {

	private T content;
	
	public Message(T message) {
		this.content = message;
	}
	
	public T getContent(){
		return content;
	}
}
