package pos.games;

import java.util.ArrayList;

public class Game {
	
	private Board board;
	private ArrayList<Player> players = new ArrayList<>();
	
	public Game(Board board) {
		this.board = board;
	}
	
	public Game(Board board, ArrayList<Player> players) {
		this(board);
		this.players = players;
	}
	
	public void addPlayer(Player player){
		players.add(player);
	}
	
	public void removePlayer(Player player){
		players.remove(player);
	}
}
