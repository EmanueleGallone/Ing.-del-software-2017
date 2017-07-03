package it.polimi.ingsw.ps11.controller.server.login;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.loaders.Loader;

public class Register {

	private ArrayList<User> users = new ArrayList<>();
	
	public Register() {
	
	}
	
	private User getById(String id){
		for(User u : users){
			if(u.getId().equals(id))
				return u;
		}
		return null;
	}
	
	public boolean search(User user){
		User oldUser = getById(user.getId());
		if(oldUser != null){
			return oldUser.getPw().equals(user.getPw());
		}
		return false;
	}
	
	public boolean addNew(User newUser){
		User user = getById(newUser.getId()); // Prima di aggiungere un nuovo utente controlla se è già presente
		if(user == null){
			users.add(newUser);
			save();
			return true;
		}
		return false;
	}
	
	public void save(){
//		String reg = new JsonAdapter().toJson(this);
//		CustomFileReaderWriter.writeFile(this.registerUrl, reg);
		new Loader(FileRegistry.login_registry).write(this);
	}
}
