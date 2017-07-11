package it.polimi.ingsw.ps11.controller.server.login;
/**
 * <h3> User. </h3>
 * <p> Classe che rappresenta un giocatore connesso, contiene il nome dello stesso e la relativa password.</p>
 * @see Register
 */
public class User {
	
	private String id;
	private String pw;
	
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass().equals(this.getClass())){
			User other = (User) obj;
			if(other.id.equals(this.id) && other.pw.equals(this.pw))
				return true;
		}
		return false;
	}
}