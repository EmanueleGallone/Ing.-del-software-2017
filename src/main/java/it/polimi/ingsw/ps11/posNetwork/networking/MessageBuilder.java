package it.polimi.ingsw.ps11.posNetwork.networking;

import it.polimi.ingsw.ps11.cranio.JsonAdapter;
import it.polimi.ingsw.ps11.posNetwork.messages.Message;
public class MessageBuilder {
	private JsonAdapter json = new JsonAdapter();
	
	public String serialize(Message<?> message){
		String ser = new String();
		try{
			ser = json.toJson(new Wrapper(message));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ser;
	}
	
	
	public Message<?> deserialize(String message){
		Message<?> m = null;
		try{
			m = json.fromJson(message, Wrapper.class).getMessage();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	private class Wrapper {

		private Message<?> message;
		
		public Wrapper(Message<?> message) {
			this.message = message;
		}
		
		public Message<?> getMessage() {
			return message;
		}
	}
}
