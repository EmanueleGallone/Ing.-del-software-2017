package it.polimi.ingsw.ps11.network.messages;

public class Message {
	
	private String type, object;
	
	
	public Message(String type, String object) {
		this.type = type;
		this.object = object;
	}
	
	public Class<? extends CommandInterface> getType() {
		try {
			return (Class<? extends CommandInterface>) Class.forName(type);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DefaultCommand.class;
	}
	
	public String getObject() {
		return object;
	}
}
