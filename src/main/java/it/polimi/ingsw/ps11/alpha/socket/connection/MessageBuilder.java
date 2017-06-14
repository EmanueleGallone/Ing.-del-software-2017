package it.polimi.ingsw.ps11.alpha.socket.connection;

import it.polimi.ingsw.ps11.alpha.socket.Message;
import it.polimi.ingsw.ps11.cranio.json.JsonAdapter;


public class MessageBuilder<T extends Message<?>> {
	
	private JsonAdapter json = new JsonAdapter();
	
	public String serialize(T message){
		String ser = new String();
		try{
			Wrapper<T> wrapper = new Wrapper<T>(message);
			ser = json.toJson(wrapper);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ser;
	}
	
	
	public T deserialize(String message){
		try{
			Wrapper<T> wrapper = json.fromJson(message, Wrapper.class);
			return wrapper.getMessage();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private class Wrapper<K extends Message<?>> {

		private K message;
		
		public Wrapper(K message) {
			this.message = message;
		}
		
		public K getMessage() {
			return message;
		}
	}
}
