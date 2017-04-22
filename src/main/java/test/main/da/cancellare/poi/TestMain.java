package test.main.da.cancellare.poi;

public class TestMain {

	public static void main(String[] args) {
		GameMaster gameMaster = new GameMaster();
		
		Client c = new Client();
		c.setPlayer(new Player());
		Client c2 = new Client();
		c2.setPlayer(new Player());
		gameMaster.add(c);
		gameMaster.add(c2);
		
		Partita game = gameMaster.getPartita(0);		
		System.out.println(game.toString());
		game.nuovoTurno();
		System.out.println(game.toString());
		
		
		
		

	}

}
