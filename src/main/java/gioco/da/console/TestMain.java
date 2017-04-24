package gioco.da.console;

public class TestMain {

	public static void main(String[] args) {

		GameMaster gameMaster = new GameMaster();
		
		PartitaController controller;
		
		//emulazione di Connection Accept
		Client c = new Client();
		c.setPlayer(new Player("Mario"));
		c.getPlayer().setPosition(2);
		Client c2 = new Client();
		c2.setPlayer(new Player("Ken"));
		
		//aggiungo i client al gameMaster
		gameMaster.add(c);
		gameMaster.add(c2);
		
		//creo una nuova partita e la prendo dal gameMaster
		Partita game = gameMaster.getPartita(0);
		
		//delego la partita al controller
		controller = new PartitaController(game, new PartitaView());
		
		controller.gioca();
		
	}

}
