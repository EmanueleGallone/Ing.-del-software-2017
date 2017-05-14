package provaGab.ProvaServerGame;

public class Metodo_di_esecuzione {

	/* Parte il server e si mette in ascolto di connessioni in arrivo sulla porta tramite run() in ciclo continuo.
	 * Ogni volta che una si connette, si crea il client che richiede un nome e abilita lo scambio di messaggi con il server.
	 * Inserisce il client tra le connessioni in attesa (waitingGame).
	 * Quando ci sono almeno 2 connessioni in attesa, si crea la lobby. 
	 * Se ce ne sono più di 2 le passa direttamente alla lobby.
	 * La lobby aspetta tutte le connessioni in arrivo fino ad un massimo di altre 2 per 60 secondi.
	 * Arrivati al max di giocatori o scaduto il timer, crea la partita e ripulisce la lista dei giocatori in attesa.
	 * La partita crea board, view di ogni giocatore e setto il modello MVC, creando model e controller
	 */
	
	
}
