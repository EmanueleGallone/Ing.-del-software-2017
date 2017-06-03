package it.polimi.ingsw.ps11.network.newClient;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.google.gson.Gson;

import it.polimi.ingsw.ps11.cranio.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.events.EventListener;
import it.polimi.ingsw.ps11.cranio.resources.Resource;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
import it.polimi.ingsw.ps11.mvc.view.View;
import it.polimi.ingsw.ps11.network.Connection;
import it.polimi.ingsw.ps11.network.messages.DefaultCommand;
import it.polimi.ingsw.ps11.network.messages.InputChangeEvent;
import it.polimi.ingsw.ps11.network.messages.Message;
import it.polimi.ingsw.ps11.network.messages.CommandInterface;
import it.polimi.ingsw.ps11.network.messages.CommandRecognizer;

public class ClientController implements CommandRecognizer {
	
	private View view;
	private Connection connection;
	
	
	public ClientController(View view , Connection connection) {
		this.view = view;
		this.connection = connection;
	}
	
// _________________________________________________________________
	
	public void start(){
		try {
			connection.on();
			connection.inputChangeEvent(getServerListener());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
// _________________________ EVENT LISTENER ________________________
	
	EventListener<InputChangeEvent> serverListener = new EventListener<InputChangeEvent>() {
		@Override
		public void handle(InputChangeEvent message) {
			
			
			
			ArrayList<Class<?>> list = new ArrayList<>();
			list.add(DevelopmentCard.class);
			list.add(Resource.class);
			list.add(Tower.class);
			
			JsonAdapter jsonAdapter = new JsonAdapter(list);
			
			CommandInterface command = jsonAdapter.fromJson(message.getMessage().getObject(), message.getMessage().getType());
			execute(command);
		}
	};
	
	public EventListener<InputChangeEvent> getServerListener() {
		return serverListener;
	}
	
//____________________________ COMMAND INTERPRETER _____________________________
	
	public void execute(CommandInterface command){
		command.accept(this);
	}
	
	@Override
	public void execute(DefaultCommand command) {
		view.out("Comando non riconosciuto");
	}
}
