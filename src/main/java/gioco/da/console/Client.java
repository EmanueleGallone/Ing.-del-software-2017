package gioco.da.console;

import java.net.Socket;

public class Client {
	private Socket socket;
	private Player player;
	
	
	
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setPosition(int position){
		this.player.setPosition(position);
	}
	
	

}
