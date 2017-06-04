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
import it.polimi.ingsw.ps11.network.messages.Sendable;
import it.polimi.ingsw.ps11.network.newClient.messages.ClientRecognizer;
import it.polimi.ingsw.ps11.network.newServer.messages.Default;
import it.polimi.ingsw.ps11.network.newServer.messages.ServerMessageVisitor;
import it.polimi.ingsw.ps11.network.newServer.messages.ServerRecognizer;
import it.polimi.ingsw.ps11.network.messages.CommandRecognizer;

public class ClientController implements ServerRecognizer {
	
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
		public void handle(InputChangeEvent e) {
			/*
			JsonAdapter jsonAdapter = new JsonAdapter();
			
			Class<? extends ServerMessageVisitor> type = e.getMessage().getType();

			
			ServerMessageVisitor data = jsonAdapter.fromJson(e.getMessage().getObject(),type);
			execute(data);*/
		}
	};
	
	public EventListener<InputChangeEvent> getServerListener() {
		return serverListener;
	}

	
//____________________________ COMMAND EXECUTOR _____________________________
	
	
	public void execute(ServerMessageVisitor data){
		data.accept(this);
	}


	@Override
	public void execute(Default command) {
		// TODO Auto-generated method stub
		
	}

}
