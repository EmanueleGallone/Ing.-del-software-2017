package it.polimi.ingsw.ps11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import it.polimi.ingsw.ps11.controller.server.gameServer.PlayerFactory;
import it.polimi.ingsw.ps11.model.bonus.EnableHarvestBonus;
import it.polimi.ingsw.ps11.model.bonus.EnableProductionBonus;
import it.polimi.ingsw.ps11.model.bonus.GainResourceForEveryCardYouHave;
import it.polimi.ingsw.ps11.model.bonus.IncrementResourceBonus;
import it.polimi.ingsw.ps11.model.bonus.ResourceExchangeBonus;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.cards.list.LeaderCard;
import it.polimi.ingsw.ps11.model.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.game.Colors;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.json.JsonAdapter;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.CouncilPrivilege;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.model.zones.CouncilPalace;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.Market;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.model.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.model.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.model.zones.towers.YellowTower;
import it.polimi.ingsw.ps11.view.textualView.TextualView;
import it.polimi.ingsw.ps11.view.viewGenerica.View;

public class MainTest {
	
	public static void main(String[] args){
		
		PlayerFactory factory = new PlayerFactory();

		Player player =factory.newPlayer(0);
		player.setName("Giocatore 1");
		player.setColor(Colors.RED);
		
		Player player2 = factory.newPlayer(1);
		player2.setName("Giocatore 2");
		player2.setColor(Colors.GREEN);
		
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);
		players.add(player2);
		
		Game game = new Game(players);
		
		View view = new TextualView();
		YellowCard card = new YellowCard();
		card.setName("Funziona");
		
		Type type = new TypeToken<ArrayList<YellowCard>>(){}.getType();
		ArrayList<YellowCard> cards = new JsonAdapter().fromJson(readFile("settings\\YellowCards"), type);
		
		game.getBoard().getTower(YellowTower.class).getFloor(0).setCard(cards.get(0).clone());
		game.getBoard().getTower(YellowTower.class).getFloor(1).setCard(cards.get(1).clone());
		game.getBoard().getTower(YellowTower.class).getFloor(2).setCard(cards.get(2).clone());
		game.getBoard().getTower(YellowTower.class).getFloor(3).setCard(cards.get(3).clone());
		game.getBoard().getDices().rollDices();
		
		view.update(game);
		//view.update(player2);
		
		card.addCost(new ResourceList(new Coin(5)));
		player2.getCardManager().addCard(card.clone());
		
		view.update(game.getBoard());
		
		view.run();
		
		
		
		

		//String gString = adapter.toJson(game);
		//System.out.println(gString);
		
		//Game game2 = adapter.fromJson(gString, Game.class);
		//System.out.println(game2.getBoard());
		
//		Client client = new SocketClient(view);
//		player2.getCardManager().addCard(card.clone());
//		card.addCost(new ResourceList(new Coin(10)));
//		player2.getCardManager().addCard(card.clone());
//		
//		client.temp(game, player2);

		//inizializzaCarte();
		//inizializzatore();		
	}
	
	
	
	
	
	
	
	public static void writeFile(String fileName, String testo){
		
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(testo);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public static String readFile(String fileName){
		
		BufferedReader reader = null;
		String testo = new String();
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine())!= null) {
				testo = testo + line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return testo;
	}
	
 
 
	public static Board inizializzatore(){
		
		ArrayList<Class<?>> list = new ArrayList<>();
		list.add(DevelopmentCard.class);
		list.add(Resource.class);
		list.add(Tower.class);
		
		JsonAdapter gAdapter = new JsonAdapter(list);
		
// ___________ TUTTE LE TORRI ____________________________
		
		GreenTower greenTower = new GreenTower();
		greenTower.addFloor(new Floor(1));
		greenTower.addFloor(new Floor(3));
		
		ResourceList resource = new ResourceList();
		
		resource.setResource(new Wood(1));
		greenTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new Wood(2));
		greenTower.addFloor(new Floor(7,resource.clone()));
		
		
		BlueTower blueTower = new BlueTower();
		resource = new ResourceList();
		
		blueTower.addFloor(new Floor(1));
		blueTower.addFloor(new Floor(3));
		
		resource.setResource(new Stone(1));
		blueTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new Stone(2));
		blueTower.addFloor(new Floor(7,resource.clone()));
		
		
		YellowTower yellowTower = new YellowTower();
		resource = new ResourceList();
		
		yellowTower.addFloor(new Floor(1));
		yellowTower.addFloor(new Floor(3));
		
		resource.setResource(new MilitaryPoint(1));
		yellowTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new MilitaryPoint(2));
		yellowTower.addFloor(new Floor(7,resource.clone()));
		
	
		PurpleTower purpleTower = new PurpleTower();
		resource = new ResourceList();
		
		purpleTower.addFloor(new Floor(1));
		purpleTower.addFloor(new Floor(3));
		
		resource.setResource(new Coin(1));
		purpleTower.addFloor(new Floor(5,resource.clone()));
		resource.setResource(new Coin(2));
		purpleTower.addFloor(new Floor(7,resource.clone()));
		
		ArrayList<Tower> towers = new ArrayList<>();
		towers.add(greenTower);
		towers.add(blueTower);
		towers.add(yellowTower);
		towers.add(purpleTower);
		
 // ________ MARKET ________________________________________________
		
		Market market = new Market(2);
		
		resource = new ResourceList(new Coin(5));
		market.addActionSpace(new ActionSpace(resource.clone()));
		
		resource = new ResourceList(new Servant(5));
		market.addActionSpace(new ActionSpace(resource.clone()));
		
		resource = new ResourceList();
		resource.setResource(new Coin(2));
		resource.setResource(new MilitaryPoint(3));
		market.addActionSpace(new ActionSpace(resource.clone()));
		
		resource = new ResourceList(new CouncilPrivilege(2));
		market.addActionSpace(new ActionSpace(resource.clone()));
		
  // ___________________________________________________
		
		
		Board board = new Board(towers, market, new CouncilPalace());
		writeFile("settings\\board", gAdapter.toJson(board));
		return board;
	}
	
	public static void inizializzaCarte(){
		
		JsonAdapter gAdapter = new JsonAdapter(); //per la scrittura su file
		
		ResourceList resourceList = new ResourceList();
		
		//INIZIO CARTE VERDI
		
		GreenCard avampostoCommerciale = new GreenCard(); //creazione carta
		avampostoCommerciale.setPeriod(1);
		avampostoCommerciale.setName("Avamposto Commerciale");
		avampostoCommerciale.setActiveValue(1); //setto il valore per il quale è possibile attivare il bonus permanente
		resourceList.setResource(new Coin(1)); //setto la resourceList per il bonus
		avampostoCommerciale.addPermanentBonus(new IncrementResourceBonus(resourceList.clone())); //attribuzione del bonus permanente alla carta
		
		GreenCard bosco = new GreenCard();
		bosco.setActiveValue(2);
		bosco.setPeriod(1);
		bosco.setName("Bosco");
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(1));
		bosco.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		bosco.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard borgo = new GreenCard();
		borgo.setName("Borgo");
		borgo.setPeriod(1);
		borgo.setActiveValue(3);
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(1));
		resourceList.setResource(new Coin(1));
		borgo.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard monastero = new GreenCard();
		monastero.setPeriod(1);
		monastero.setName("Monastero");
		monastero.setActiveValue(6);
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2));
		resourceList.setResource(new Servant(1));
		monastero.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(1));
		resourceList.setResource(new Stone(1));
		monastero.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard foresta = new GreenCard();
		foresta.setPeriod(1);
		foresta.setName("Foresta");
		foresta.setActiveValue(5);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(1));
		foresta.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(3));
		foresta.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard rocca = new GreenCard();
		rocca.setPeriod(1);
		rocca.setName("Rocca");
		rocca.setActiveValue(5);
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2));
		resourceList.setResource(new Stone(1));
		rocca.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard citta = new GreenCard();
		citta.setActiveValue(6);
		citta.setPeriod(1);
		citta.setName("Citta'");
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(3));
		citta.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new CouncilPrivilege(1));
		citta.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard cavaGhiaia = new GreenCard();
		cavaGhiaia.setActiveValue(4);
		cavaGhiaia.setName("Cava Di Ghiaia");
		cavaGhiaia.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		cavaGhiaia.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		cavaGhiaia.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		//INIZIO SECONDO PERIODO
		
		GreenCard eremo = new GreenCard();
		eremo.setActiveValue(2);
		eremo.setName("Eremo");
		eremo.setPeriod(2);
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(1));
		eremo.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		eremo.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard villaggioMinerario = new GreenCard();
		villaggioMinerario.setActiveValue(4);
		villaggioMinerario.setName("Villaggio Minerario");
		villaggioMinerario.setPeriod(2);
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(2));
		resourceList.setResource(new Stone(1));
		villaggioMinerario.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList.setResource(new Servant(1));
		resourceList.setResource(new Stone(2));
		villaggioMinerario.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard ducato = new GreenCard();
		ducato.setActiveValue(6);
		ducato.setPeriod(2);
		ducato.setName("Ducato");
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(4));
		ducato.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList.setResource(new Coin(1));
		resourceList.setResource(new Wood(2));
		resourceList.setResource(new Stone(1));
		ducato.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard maniero = new GreenCard();
		maniero.setActiveValue(5);
		maniero.setPeriod(2);
		maniero.setName("Maniero");
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2));
		resourceList.setResource(new Servant(2));
		maniero.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard possedimento = new GreenCard();
		possedimento.setActiveValue(4);
		possedimento.setPeriod(2);
		possedimento.setName("Possedimento");
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(2));
		resourceList.setResource(new Wood(1));
		possedimento.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList= new ResourceList();
		resourceList.setResource(new Coin(1));
		resourceList.setResource(new Wood(2));
		possedimento.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard villaggioMontano = new GreenCard();
		villaggioMontano.setActiveValue(3);
		villaggioMontano.setName("Villaggio Montano");
		villaggioMontano.setPeriod(2);
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(1));
		villaggioMontano.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(1));
		resourceList.setResource(new Wood(2));
		villaggioMontano.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard cavaDiPietra = new GreenCard();
		cavaDiPietra.setActiveValue(3);
		cavaDiPietra.setPeriod(2);
		cavaDiPietra.setName("Cava Di Pietra");
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(1));
		cavaDiPietra.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(3));
		cavaDiPietra.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard minieraOro = new GreenCard();
		minieraOro.setActiveValue(1);
		minieraOro.setPeriod(2);
		minieraOro.setName("Miniera d'oro");
		resourceList = new ResourceList();
		resourceList.setResource( new Coin(1));
		minieraOro.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList.setResource(new Coin(2));
		minieraOro.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		//INIZIO TERZO PERIODO
		
		GreenCard castello = new GreenCard();
		castello.setActiveValue(4);
		castello.setName("Castello");
		castello.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(2));
		resourceList.setResource(new Coin(2));
		castello.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(3));
		resourceList.setResource(new Servant(1));
		castello.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard cittaFortificata = new GreenCard();
		cittaFortificata.setActiveValue(2);
		cittaFortificata.setName("Citta' Fortificata");
		cittaFortificata.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2));
		resourceList.setResource(new Servant(1));
		cittaFortificata.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(1));
		resourceList.setResource(new Servant(2));
		cittaFortificata.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard colonia = new GreenCard();
		colonia.setActiveValue(5);
		colonia.setPeriod(3);
		colonia.setName("Colonia");
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2));
		colonia.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		resourceList.setResource(new Wood(1));
		colonia.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard santuario = new GreenCard();
		santuario.setActiveValue(1);
		santuario.setName("Santuario");
		santuario.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(1));
		santuario.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList.setResource(new Coin(1));
		santuario.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard cavaDiMarmo = new GreenCard();
		cavaDiMarmo.setActiveValue(2);
		cavaDiMarmo.setName("Cava di Marmo");
		cavaDiMarmo.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(3));
		cavaDiMarmo.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList.setResource(new VictoryPoint(1));
		resourceList.setResource(new Servant(2));
		cavaDiMarmo.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard provincia = new GreenCard();
		provincia.setActiveValue(6);
		provincia.setName("Provincia");
		provincia.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new CouncilPrivilege(1));
		resourceList.setResource(new Stone(1));
		provincia.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		resourceList.setResource(new Stone(1));
		provincia.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard cittaMercantile = new GreenCard();
		cittaMercantile.setActiveValue(1);
		cittaMercantile.setName("Citta' Mercantile");
		cittaMercantile.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(3));
		cittaMercantile.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList.setResource(new Coin(1));
		resourceList.setResource(new Servant(1));
		cittaMercantile.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		
		GreenCard tenuta = new GreenCard();
		tenuta.setActiveValue(3);
		tenuta.setName("Tenuta");
		tenuta.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(1));
		resourceList.setResource(new Wood(1));
		tenuta.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList.setResource(new VictoryPoint(2));
		resourceList.setResource(new Wood(2));
		tenuta.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		ArrayList<GreenCard> greenDeck = new ArrayList<GreenCard>(); 
		Type type = new TypeToken<ArrayList<GreenCard>>(){}.getType();
		greenDeck.add(tenuta); 
		greenDeck.add(cittaMercantile); 
		greenDeck.add(provincia);
		greenDeck.add(cavaDiMarmo);
		greenDeck.add(santuario);
		greenDeck.add(colonia);
		greenDeck.add(cittaFortificata);
		greenDeck.add(castello);
		greenDeck.add(minieraOro);
		greenDeck.add(cavaDiPietra);
		greenDeck.add(villaggioMontano);
		greenDeck.add(possedimento);
		greenDeck.add(maniero);
		greenDeck.add(ducato);
		greenDeck.add(villaggioMinerario);
		greenDeck.add(eremo);
		greenDeck.add(cavaGhiaia);
		greenDeck.add(citta);
		greenDeck.add(rocca);
		greenDeck.add(foresta);
		greenDeck.add(monastero);
		greenDeck.add(borgo);
		greenDeck.add(bosco);
		greenDeck.add(avampostoCommerciale);	
		
		writeFile("settings\\GreenCards", gAdapter.toJson(greenDeck, type));
		
		//FINE CARTE VERDI
		
		//INIZIO CARTE VIOLA
		
		PurpleCard campagnaMilitare = new PurpleCard();
		campagnaMilitare.setName("Campagna Militare");
		campagnaMilitare.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(3)); //richiede che il giocatore abbia 3 punti militari
		campagnaMilitare.addCost(resourceList.clone()); //come faccio a dirgli che quando prenderà la carta ne dovra' spendere 2 di militarypoints?
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		campagnaMilitare.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(3));
		campagnaMilitare.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard ospitareMendicanti = new PurpleCard();
		ospitareMendicanti.setName("Ospitare i Mendicanti");
		ospitareMendicanti.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(3));
		ospitareMendicanti.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(4));
		ospitareMendicanti.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		ospitareMendicanti.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard riparareChiesa = new PurpleCard();
		riparareChiesa.setName("Riparare la Chiesa");
		riparareChiesa.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(1));
		resourceList.setResource(new Stone(1));
		resourceList.setResource(new Coin(1));
		riparareChiesa.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(1));
		riparareChiesa.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		riparareChiesa.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard ingaggiareReclute = new PurpleCard();
		ingaggiareReclute.setName("Ingaggiare Reclute");
		ingaggiareReclute.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(4));
		ingaggiareReclute.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(5));
		ingaggiareReclute.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		ingaggiareReclute.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard combattereEresie = new PurpleCard();
		combattereEresie.setName("Combattere le Eresie");
		combattereEresie.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(5)); //anche qui, devo avere 5 military points ma ne devo spendere 3
		combattereEresie.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(2));
		combattereEresie.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList= new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		combattereEresie.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard sostegnoVaticano = new PurpleCard();
		sostegnoVaticano.setName("Sostegno al Vaticano");
		sostegnoVaticano.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(4)); //devo avere 4 military points e spenderne 2 per prendere la carta
		sostegnoVaticano.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(2));
		resourceList.setResource(new Stone(1));
		resourceList.setResource(new Wood(1));
		sostegnoVaticano.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(3));
		sostegnoVaticano.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList(new VictoryPoint(1));
		sostegnoVaticano.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard costruireMura = new PurpleCard();
		costruireMura.setName("Costruire le Mura");
		costruireMura.setPeriod(1);
		resourceList = new ResourceList(new Stone(3));
		costruireMura.addCost(resourceList.clone());
		resourceList = new ResourceList(new MilitaryPoint(2));
		resourceList.setResource(new CouncilPrivilege(1));
		costruireMura.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList(new VictoryPoint(3));
		costruireMura.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard innalzareStatua = new PurpleCard();
		innalzareStatua.setName("Innalzare una Statua");
		innalzareStatua.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		resourceList.setResource(new Wood(2));
		innalzareStatua.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new CouncilPrivilege(2)); //ATTENZIONE; questa carta prevede che i 2 favori del consiglio siano DIVERSI
		innalzareStatua.addInstantBonus( new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList(new VictoryPoint(4));
		innalzareStatua.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		//INIZIO SECONDO PERIODO
		
		PurpleCard ingaggiareSoldati = new PurpleCard();
		ingaggiareSoldati.setName("Ingaggiare Soldati");
		ingaggiareSoldati.setPeriod(2);
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(6));
		ingaggiareSoldati.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(6));
		ingaggiareSoldati.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		ingaggiareSoldati.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard scavareCanalizzazioni = new PurpleCard();
		scavareCanalizzazioni.setName("Scavare Canalizzazioni");
		scavareCanalizzazioni.setPeriod(2);
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(2));
		resourceList.setResource(new Coin(3));
		scavareCanalizzazioni.addCost(resourceList.clone());
		resourceList = new ResourceList();
		scavareCanalizzazioni.addInstantBonus(new EnableHarvestBonus(4)); //BONUS PARTICOLARE. DA DEFINIRE
		resourceList.setResource(new VictoryPoint(5));
		scavareCanalizzazioni.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard riparareAbbazia = new PurpleCard();
		riparareAbbazia.setPeriod(2);
		riparareAbbazia.setName("Riparare l'Abbazia");
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		resourceList.setResource(new Wood(2));
		resourceList.setResource(new Coin(2));
		riparareAbbazia.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(2));
		riparareAbbazia.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(6));
		riparareAbbazia.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard supportoRe = new PurpleCard();
		supportoRe.setPeriod(2);
		supportoRe.setName("Supporto al Re");
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(6)); //anche qui, il player deve avere 6 MP e spenderne 3
		supportoRe.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(5));
		resourceList.setResource(new CouncilPrivilege(1));
		supportoRe.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(3));
		supportoRe.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard sostegnoCardinale = new PurpleCard();
		sostegnoCardinale.setPeriod(2);
		sostegnoCardinale.setName("Sostegno al Cardinale");
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(7)); //player deve avere 7 MP e spenderne 4
		sostegnoCardinale.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(3));
		resourceList.setResource(new Wood(2));
		resourceList.setResource(new Stone(2));
		sostegnoCardinale.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(3));
		sostegnoCardinale.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		sostegnoCardinale.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard crociata = new PurpleCard();
		crociata.setPeriod(2);
		crociata.setName("Crociata");
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(8)); //player deve avere 8 MP e spenderne 4
		crociata.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(5));
		resourceList.setResource(new FaithPoint(1));
		crociata.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		crociata.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard costruireBastioni = new PurpleCard();
		costruireBastioni.setPeriod(2);
		costruireBastioni.setName("Costruire i Bastioni");
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(4));
		costruireBastioni.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(3));
		resourceList.setResource(new CouncilPrivilege(1));
		costruireBastioni.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(2));
		costruireBastioni.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard accogliereStranieri = new PurpleCard();
		accogliereStranieri.setPeriod(2);
		accogliereStranieri.setName("Accogliere gli Stranieri");
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(4));
		accogliereStranieri.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(5));
		accogliereStranieri.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		accogliereStranieri.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		//INIZIO TERZO PERIODO
		
		PurpleCard riparareCattedrale = new PurpleCard(); //CARTA DA RIVEDERE!
		riparareCattedrale.setPeriod(3);
		riparareCattedrale.setName("Riparare la Cattedrale");
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(3));
		resourceList.setResource(new Stone(3));
		resourceList.setResource(new Wood(3));
		riparareCattedrale.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		riparareCattedrale.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(1));
		riparareCattedrale.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//riparareCattedrale.addInstantBonus(new GetAnotherCardBonus(DevelopmentCard.class)); //ATTENZIONE. VA RIVISTA QUESTA CARTA! E DA' PROBLEMI IN SERIALIZZAZIONE!!!!!!!!!!!!!!!!!!!!!!
		
		PurpleCard commissionareArteSacra = new PurpleCard();
		commissionareArteSacra.setPeriod(3);
		commissionareArteSacra.setName("Commissionare Arte Sacra");
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(6));
		commissionareArteSacra.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(3));
		commissionareArteSacra.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(3));
		commissionareArteSacra.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard costruireTorri = new PurpleCard();
		costruireTorri.setPeriod(3);
		costruireTorri.setName("Costruire le Torri");
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(6));
		costruireTorri.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(4));
		resourceList.setResource(new CouncilPrivilege(1));
		costruireTorri.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		costruireTorri.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard ingaggiareMercenari = new PurpleCard();
		ingaggiareMercenari.setPeriod(3);
		ingaggiareMercenari.setName("Ingaggiare Mercenari");
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(8));
		ingaggiareMercenari.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(7));
		ingaggiareMercenari.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(6));
		ingaggiareMercenari.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard migliorareStrade = new PurpleCard();
		migliorareStrade.setPeriod(3);
		migliorareStrade.setName("Migliorare le Strade");
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(3));
		resourceList.setResource(new Coin(4));
		migliorareStrade.addCost(resourceList.clone());
		migliorareStrade.addInstantBonus(new EnableProductionBonus(3)); //attiva la produzione con valore 3
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		migliorareStrade.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard conquistaMilitare = new PurpleCard();
		conquistaMilitare.setPeriod(3);
		conquistaMilitare.setName("Conquista Militare");
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(12)); //il player deve avere 12 MP e spenderne 6
		conquistaMilitare.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(3));
		resourceList.setResource(new Wood(3));
		resourceList.setResource(new Coin(3));
		conquistaMilitare.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(7));
		conquistaMilitare.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard sostegnoPapa = new PurpleCard();
		sostegnoPapa.setPeriod(3);
		sostegnoPapa.setName("Sostegno al Papa");
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(10)); //player deve avere 10 MP e spenderne 5
		sostegnoPapa.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(4));
		resourceList.setResource(new Wood(3));
		resourceList.setResource(new Stone(3));
		sostegnoPapa.addCost(resourceList.clone());
		sostegnoPapa.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(2));
		sostegnoPapa.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(10));
		sostegnoPapa.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard guerraSanta = new PurpleCard();
		guerraSanta.setPeriod(3);
		guerraSanta.setName("Guerra Santa");
		resourceList = new ResourceList(new MilitaryPoint(15));// player deve avere 15 MP e spenderne 8
		guerraSanta.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(4));
		guerraSanta.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList(new VictoryPoint(8));
		guerraSanta.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		ArrayList<PurpleCard> purpleDeck = new ArrayList<PurpleCard>();
		type = new TypeToken<ArrayList<PurpleCard>>(){}.getType();
		
		purpleDeck.add(guerraSanta);
		purpleDeck.add(sostegnoPapa);
		purpleDeck.add(conquistaMilitare);
		purpleDeck.add(migliorareStrade);
		purpleDeck.add(ingaggiareMercenari);
		purpleDeck.add(costruireTorri);
		purpleDeck.add(commissionareArteSacra);
		purpleDeck.add(riparareCattedrale);
		purpleDeck.add(accogliereStranieri);
		purpleDeck.add(costruireBastioni);
		purpleDeck.add(crociata);
		purpleDeck.add(sostegnoCardinale);
		purpleDeck.add(supportoRe);
		purpleDeck.add(riparareAbbazia);
		purpleDeck.add(scavareCanalizzazioni);
		purpleDeck.add(ingaggiareSoldati);
		purpleDeck.add(innalzareStatua);
		purpleDeck.add(costruireMura);
		purpleDeck.add(sostegnoVaticano);
		purpleDeck.add(combattereEresie);
		purpleDeck.add(ingaggiareReclute);
		purpleDeck.add(riparareChiesa);
		purpleDeck.add(ospitareMendicanti);
		purpleDeck.add(campagnaMilitare);
		
		
		writeFile("settings\\PurpleCards", gAdapter.toJson(purpleDeck,type)); 
		
		//FINE CARTE VIOLA
		
		//INIZIO CARTE GIALLE
		ResourceList exchangeable = new ResourceList();
		ResourceList exchange = new ResourceList();
		
		YellowCard residenza = new YellowCard(); //bonus da rivedere
		residenza.setActiveValue(1);
		residenza.setPeriod(1);
		residenza.setName("Residenza");
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		residenza.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(1));
		residenza.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		exchange.setResource(new Coin(1));
		exchangeable.setResource(new CouncilPrivilege(1));
		residenza.addPermanentBonus(new ResourceExchangeBonus(exchange.clone(), exchangeable.clone()));
		
		YellowCard teatro = new YellowCard();
		teatro.setActiveValue(6);
		teatro.setName("Teatro");
		teatro.setPeriod(1);
		resourceList = new ResourceList();
		exchangeable = new ResourceList();
		exchange = new ResourceList();
		resourceList.setResource(new Coin(2));
		teatro.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(2));
		teatro.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(6));
		teatro.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(1));
		teatro.addPermanentBonus(new GainResourceForEveryCardYouHave(BlueCard.class, resourceList.clone()));
		
		YellowCard esattoria = new YellowCard();
		esattoria.setActiveValue(5);
		esattoria.setPeriod(1);
		esattoria.setName("Esattoria");
		resourceList = new ResourceList(new Wood(3));
		esattoria.addCost(resourceList.clone());
		resourceList = new ResourceList(new Stone(1));
		esattoria.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(5));
		esattoria.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList(new Coin(1));
		esattoria.addPermanentBonus(new GainResourceForEveryCardYouHave(GreenCard.class, resourceList.clone()));
		
		YellowCard arcoTrionfo = new YellowCard();
		arcoTrionfo.setActiveValue(6);
		arcoTrionfo.setPeriod(1);
		arcoTrionfo.setName("Arco di Trionfo");
		resourceList = new ResourceList(new Coin(2));
		arcoTrionfo.addCost(resourceList.clone());
		resourceList = new ResourceList(new Stone(2));
		arcoTrionfo.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(6));
		arcoTrionfo.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList(new VictoryPoint(1));
		arcoTrionfo.addPermanentBonus(new GainResourceForEveryCardYouHave(PurpleCard.class, resourceList));
		
		YellowCard zecca = new YellowCard();
		zecca.setActiveValue(5);
		zecca.setName("Zecca");
		zecca.setPeriod(1);
		resourceList = new ResourceList(new Wood(1));
		zecca.addCost(resourceList.clone());
		resourceList = new ResourceList(new Stone(3));
		zecca.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(5));
		zecca.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList(new Coin(1));
		zecca.addPermanentBonus(new GainResourceForEveryCardYouHave(YellowCard.class, resourceList.clone()));
		
		YellowCard falegnameria = new YellowCard();
		falegnameria.setActiveValue(4);
		falegnameria.setPeriod(1);
		falegnameria.setName("Falegnameria");
		resourceList = new ResourceList(new Coin(1));
		falegnameria.addCost(resourceList.clone());
		resourceList = new ResourceList(new Wood(2));
		falegnameria.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(3));
		falegnameria.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//va settato il bonus permanente
		
		YellowCard cappella = new YellowCard(); //bonus permanente da rivedere
		cappella.setPeriod(1);
		cappella.setName("Cappella");
		cappella.setActiveValue(2);
		resourceList = new ResourceList(new Wood(2));
		cappella.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(1));
		cappella.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		exchange = new ResourceList();
		exchangeable = new ResourceList();
		exchange.setResource(new Coin(1));
		exchangeable.setResource(new FaithPoint(1));
		cappella.addPermanentBonus(new ResourceExchangeBonus(exchange.clone(), exchangeable.clone())); //da cambiare
		
		YellowCard tagliapietre = new YellowCard();
		tagliapietre.setPeriod(1);
		tagliapietre.setName("Tagliapietre");
		tagliapietre.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(1));
		tagliapietre.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		tagliapietre.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(2));
		tagliapietre.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//mettere il bonus permanente
		
		//INIZIO SECONDO PERIODO
		
		YellowCard gildaScultori = new YellowCard();
		gildaScultori.setPeriod(2);
		gildaScultori.setName("Gilda degli Scultori");
		gildaScultori.setActiveValue(5);
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(4));
		gildaScultori.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(6));
		gildaScultori.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//settare il bonus permanente
		
		YellowCard gildaCostruttori = new YellowCard();
		gildaCostruttori.setPeriod(2);
		gildaCostruttori.setName("Gilda dei Costruttori");
		gildaCostruttori.setActiveValue(4);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(1));
		gildaCostruttori.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		gildaCostruttori.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		gildaCostruttori.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//settare il bonus permanente
		
		YellowCard gildaPittori = new YellowCard();
		gildaPittori.setPeriod(2);
		gildaPittori.setActiveValue(4);
		gildaPittori.setName("Gilda dei Pittori");
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(4));
		gildaPittori.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		gildaPittori.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//aggiungere bonus permanente
		
		YellowCard mercato = new YellowCard();
		mercato.setPeriod(2);
		mercato.setName("Mercato");
		mercato.setActiveValue(3);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(2));
		mercato.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(1));
		mercato.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(3));
		mercato.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//aggiungere bonus permanente
		
		YellowCard battistero = new YellowCard();
		battistero.setName("Battistero");
		battistero.setPeriod(2);
		battistero.setActiveValue(2);
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(3));
		battistero.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(2));
		resourceList.setResource(new FaithPoint(1));
		battistero.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//aggiungere bonus permanente
		
		YellowCard fortezza = new YellowCard();
		fortezza.setPeriod(2);
		fortezza.setName("Fortezza");
		fortezza.setActiveValue(6);
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(2));
		fortezza.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(2));
		fortezza.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		fortezza.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(8));
		fortezza.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2));
		resourceList.setResource(new VictoryPoint(2));
		fortezza.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		YellowCard tesoreria = new YellowCard();
		tesoreria.setActiveValue(3);
		tesoreria.setName("Tesoreria");
		tesoreria.setPeriod(2);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(3));
		tesoreria.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		tesoreria.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//aggiungere bonus permanente
		
		YellowCard caserma = new YellowCard();
		caserma.setActiveValue(1);
		caserma.setName("Caserma");
		caserma.setPeriod(2);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(1));
		caserma.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(1));
		caserma.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(3));
		caserma.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//aggiungere bonus permanente
		
		//INIZIO TERZO PERIODO
		
		YellowCard giardino = new YellowCard();
		giardino.setActiveValue(1);
		giardino.setName("Giardino");
		giardino.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(2));
		giardino.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(4));
		giardino.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		giardino.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(10));
		giardino.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(3));
		giardino.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		YellowCard banca = new YellowCard();
		banca.setPeriod(3);
		banca.setActiveValue(2);
		banca.setName("Banca");
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(3));
		banca.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(1));
		banca.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(3));
		banca.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(7));
		banca.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(5));
		banca.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		YellowCard basilica = new YellowCard();
		basilica.setPeriod(3);
		basilica.setName("Basilica");
		basilica.setActiveValue(1);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(1));
		basilica.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(4));
		basilica.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		resourceList.setResource(new FaithPoint(1));
		basilica.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//aggiungi bonus permanente
		
		YellowCard cattedrale = new YellowCard();
		cattedrale.setPeriod(3);
		cattedrale.setActiveValue(2);
		cattedrale.setName("Cattedrale");
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(4));
		cattedrale.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(4));
		cattedrale.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(7));
		resourceList.setResource(new FaithPoint(3));
		cattedrale.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(1));
		cattedrale.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		YellowCard fiera = new YellowCard();
		fiera.setActiveValue(4);
		fiera.setPeriod(3);
		fiera.setName("Fiera");
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(4));
		fiera.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(3));
		fiera.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(8));
		fiera.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList= new ResourceList();
		//aggiungere bonus
		
		YellowCard accademiaMilitare = new YellowCard();
		accademiaMilitare.setActiveValue(3);
		accademiaMilitare.setName("Accademia Militare");
		accademiaMilitare.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(1));
		accademiaMilitare.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(2));
		accademiaMilitare.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		accademiaMilitare.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(7));
		accademiaMilitare.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//aggiungi bonus permanente
		
		YellowCard palazzo = new YellowCard();
		palazzo.setActiveValue(6);
		palazzo.setName("Palazzo");
		palazzo.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(3));
		palazzo.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(3));
		palazzo.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(1));
		palazzo.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(9));
		palazzo.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//aggiungi bonus permanente
		
		YellowCard castelletto = new YellowCard();
		castelletto.setActiveValue(5);
		castelletto.setName("Castelletto");
		castelletto.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(2));
		castelletto.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(2));
		castelletto.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(4));
		castelletto.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(9));
		castelletto.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(2));
		resourceList.setResource(new CouncilPrivilege(1));
		castelletto.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		ArrayList<YellowCard> yellowDeck = new ArrayList<YellowCard>();
		type = new TypeToken<ArrayList<YellowCard>>(){}.getType();
		
		yellowDeck.add(castelletto);
		yellowDeck.add(palazzo);
		yellowDeck.add(accademiaMilitare);
		yellowDeck.add(fiera);
		yellowDeck.add(cattedrale);
		yellowDeck.add(basilica);
		yellowDeck.add(banca);
		yellowDeck.add(giardino);
		yellowDeck.add(caserma);
		yellowDeck.add(tesoreria);
		yellowDeck.add(fortezza);	
		yellowDeck.add(battistero);
		yellowDeck.add(mercato);
		yellowDeck.add(gildaPittori);
		yellowDeck.add(gildaCostruttori);
		yellowDeck.add(gildaScultori);
		yellowDeck.add(tagliapietre);
		yellowDeck.add(cappella);
		yellowDeck.add(falegnameria);
		yellowDeck.add(zecca);
		yellowDeck.add(arcoTrionfo);
		yellowDeck.add(esattoria);
		yellowDeck.add(teatro);
		yellowDeck.add(residenza);
		
		writeFile("settings\\YellowCards", gAdapter.toJson(yellowDeck,type));
		
		//FINE CARTE GIALLE
		
		//INIZIO CARTE BLU
		//DA RIVEDERE
		BlueCard badessa = new BlueCard();
		badessa.setName("Badessa");
		badessa.setPeriod(1);
		resourceList = new ResourceList(new Coin(3));
		badessa.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(1));
		//va aggiunto il bonus take another Card tra gli instant bonus
		
		BlueCard predicatore = new BlueCard();
		predicatore.setName("Predicatore");
		predicatore.setPeriod(1);
		resourceList = new ResourceList(new Coin(2));
		predicatore.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(4));
		predicatore.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//va aggiunto il malus che non prendi più le risorse dall'actionspace
		
		BlueCard dama = new BlueCard();
		dama.setName("Dama");
		dama.setPeriod(1);
		resourceList = new ResourceList(new Coin(4));
		dama.addCost(resourceList.clone());
		//va aggiunto il bonus che per ogni carta blu hai +2 e paghi -1moneta
		
		BlueCard cavaliere = new BlueCard();
		cavaliere.setName("Cavaliere");
		cavaliere.setPeriod(1);
		resourceList = new ResourceList(new Coin(2));
		cavaliere.addCost(resourceList.clone());
		resourceList = new ResourceList(new CouncilPrivilege(1));
		cavaliere.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//aggiungere il bonus che per le carte purple hanno +2 quando le prendi
		
		BlueCard contadino = new BlueCard();
		contadino.setName("Contadino");
		contadino.setPeriod(1);
		resourceList = new ResourceList(new Coin(3));
		contadino.addCost(resourceList.clone());
		contadino.addPermanentBonus(new EnableHarvestBonus(2));
		//il bonus permanente aumenta +2 quando attivi l'harvest
		
		BlueCard artigiano = new BlueCard();
		artigiano.setName("Artigiano");
		artigiano.setPeriod(1);
		resourceList = new ResourceList(new Coin(3));
		artigiano.addCost(resourceList.clone());
		artigiano.addPermanentBonus(new EnableProductionBonus(2));
		
		BlueCard costruttore = new BlueCard();
		costruttore.setName("Costruttore");
		costruttore.setPeriod(1);
		resourceList = new ResourceList(new Coin(4));
		costruttore.addCost(resourceList.clone());
		//aggiungere il bonus che per ogni carta gialla hai +2 e paghi -1 stone/wood
		
		BlueCard condottiero = new BlueCard();
		condottiero.setName("Condottiero");
		condottiero.setPeriod(1);
		resourceList = new ResourceList(new Coin(2));
		condottiero.addCost(resourceList.clone());
		resourceList = new ResourceList(new MilitaryPoint(3));
		condottiero.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//aggiungere il bonus che per le carte verdi hai +2
		
		//FINE PRIMO PERIODO
		
		BlueCard messoPapale = new BlueCard();
		messoPapale.setName("Messo Papale");
		messoPapale.setPeriod(2);
		resourceList = new ResourceList(new Coin(5));
		messoPapale.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(3));
		messoPapale.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		
		BlueCard fattore = new BlueCard();
		fattore.setName("Fattore");
		fattore.setPeriod(2);
		resourceList = new ResourceList(new Coin(4));
		fattore.addCost(resourceList.clone());
		fattore.addPermanentBonus(new EnableHarvestBonus(3));
		
		BlueCard messoReale = new BlueCard();
		messoReale.setName("Messo Reale");
		messoReale.setPeriod(2);
		resourceList = new ResourceList(new Coin(5));
		messoReale.addCost(resourceList.clone());
		resourceList = new ResourceList(new CouncilPrivilege(3)); //sulla carta c'è scritto che le 3 scelte devono essere diverse
		messoReale.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		
		BlueCard mecenate = new BlueCard();
		mecenate.setName("Mecenate");
		mecenate.setPeriod(2);
		resourceList = new ResourceList(new Coin(3));
		mecenate.addCost(resourceList.clone());
		//aggiungere come instant il bonus che puoi prendere una carta blu con valore 6 e pagare -2 monete
		
		BlueCard capitano = new BlueCard();
		capitano.setName("Capitano");
		capitano.setPeriod(2);
		resourceList = new ResourceList(new Coin(4));
		capitano.addCost(resourceList.clone());
		//aggiungere tra gli instant bonus che puoi prendere un carta verde con valore 6
		resourceList = new ResourceList(new MilitaryPoint(2));
		capitano.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		
		BlueCard studioso = new BlueCard();
		studioso.setName("Studioso");
		studioso.setPeriod(2);
		resourceList = new ResourceList(new Coin(4));
		studioso.addCost(resourceList.clone());
		studioso.addPermanentBonus(new EnableProductionBonus(3));
		
		BlueCard architetto = new BlueCard();
		architetto.setName("Architetto");
		architetto.setPeriod(2);
		resourceList = new ResourceList(new Coin(4));
		architetto.addCost(resourceList.clone());
		//aggiungere bonus che ti fa pescare carta gialla con valore 6 e paghi -1 stone/wood
		
		BlueCard eroe = new BlueCard();
		eroe.setName("Eroe");
		eroe.setPeriod(2);
		resourceList = new ResourceList(new Coin(4));
		eroe.addCost(resourceList.clone());
		resourceList = new ResourceList(new CouncilPrivilege(1));
		eroe.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//aggiungere il bonus che ti fa prendere una carta viola con valore 6
		
		//FINE SECONDO PERIODO
		
		BlueCard cardinale = new BlueCard();
		cardinale.setName("Cardinale");
		cardinale.setPeriod(3);
		resourceList = new ResourceList(new Coin(4));
		cardinale.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(2));
		cardinale.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		cardinale.addInstantBonus(new EnableHarvestBonus(4));
		
		BlueCard araldo = new BlueCard();
		araldo.setName("Araldo");
		araldo.setPeriod(3);
		resourceList = new ResourceList(new Coin(6));
		araldo.addCost(resourceList.clone());
		//aggiungere il bonus instantaneo che per ogni carta viola hai +2 VP
		
		BlueCard vescovo = new BlueCard();
		vescovo.setName("Vescovo");
		vescovo.setPeriod(3);
		resourceList = new ResourceList(new Coin(5));
		vescovo.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(1));
		vescovo.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		vescovo.addInstantBonus(new EnableProductionBonus(4));
		
		BlueCard ambasciatore = new BlueCard();
		ambasciatore.setName("Ambasciatore");
		ambasciatore.setPeriod(3);
		resourceList = new ResourceList(new Coin(6));
		ambasciatore.addCost(resourceList.clone());
		resourceList = new ResourceList(new CouncilPrivilege(1));
		ambasciatore.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		//aggiungere che puoi pescare una qualsiasi carta con valore 7
		
		BlueCard cortigiana = new BlueCard();
		cortigiana.setName("Cortigiana");
		cortigiana.setPeriod(3);
		resourceList = new ResourceList(new Coin(7));
		cortigiana.addCost(resourceList.clone());
		//aggiungere bonus che per ogni carta blu hai +2 VP
		
		BlueCard generale = new BlueCard();
		generale.setName("Generale");
		generale.setPeriod(3);
		resourceList = new ResourceList(new Coin(5));
		generale.addCost(resourceList.clone());
		//aggiungere bonus che ogni 2 MP hai +1 VP
		
		BlueCard nobile = new BlueCard();
		nobile.setName("Nobile");
		nobile.setPeriod(3);
		resourceList = new ResourceList(new Coin(6));
		nobile.addCost(resourceList.clone());
		//bonus instantaneo che per ogni carta verde hai +2 VP
		
		BlueCard governatore = new BlueCard();
		governatore.setName("Governatore");
		governatore.setPeriod(3);
		resourceList = new ResourceList(new Coin(6));
		governatore.addCost(resourceList.clone());
		//bonus instantaneo che per ogni carta gialla hai +2 VP
		
		ArrayList<BlueCard> bluDeck = new ArrayList<BlueCard>();
		type = new TypeToken<ArrayList<BlueCard>>(){}.getType();
		
		bluDeck.add(badessa);
		bluDeck.add(predicatore);
		bluDeck.add(dama);
		bluDeck.add(cavaliere);
		bluDeck.add(contadino);
		bluDeck.add(artigiano);
		bluDeck.add(costruttore);
		bluDeck.add(condottiero); //fine primo periodo
		bluDeck.add(messoPapale);
		bluDeck.add(fattore);
		bluDeck.add(messoReale);
		bluDeck.add(mecenate);
		bluDeck.add(capitano);
		bluDeck.add(studioso);
		bluDeck.add(architetto);
		bluDeck.add(eroe); //fine secondo periodo
		bluDeck.add(cardinale);
		bluDeck.add(araldo);
		bluDeck.add(vescovo);
		bluDeck.add(ambasciatore);
		bluDeck.add(cortigiana);
		bluDeck.add(generale);
		bluDeck.add(nobile);
		bluDeck.add(governatore);
		
		writeFile("settings//BlueCards", gAdapter.toJson(bluDeck, type));
		
		
		//FINE CARTE BLU
		
		//INIZIO CARTE LEADER
		
		LeaderCard francescoSforza = new LeaderCard("Francesco Sforza");
		francescoSforza.setCounter(5);
		francescoSforza.setCardClass(PurpleCard.class.toString());
		//effetto: effettua una azione raccolto con valore 1 una volta per turno;
		
		LeaderCard ludovicoAriosto = new LeaderCard("Ludovico Ariosto"); //io questa carta non la includerei proprio nel gioco
		ludovicoAriosto.setCounter(5);
		ludovicoAriosto.setCardClass(BlueCard.class.toString());
		//effetti: puoi posizionare in uno spazio azione già occupato; permanente
		
		LeaderCard filippoBrunelleschi = new LeaderCard("Filippo Brunelleschi");
		filippoBrunelleschi.setCounter(5);
		filippoBrunelleschi.setCardClass(YellowCard.class.toString());
		//effetti: non paghi più le 3 monete se posizioni il familiare in una torre già occupata; permanente
		
		LeaderCard federicoDaMontefeltro = new LeaderCard("Federico Da Montefeltro");
		federicoDaMontefeltro.setCounter(5);
		federicoDaMontefeltro.setCardClass(GreenCard.class.toString());
		//effetto : un familiare ha valore 6 una volta per turno
		
		LeaderCard girolamoSavonarola = new LeaderCard("Girolamo Savonarola");
		resourceList = new ResourceList(new Coin(18));
		girolamoSavonarola.setRequirement(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(1));
		girolamoSavonarola.setBonus(new IncrementResourceBonus(resourceList.clone())); //effetto : guadagni 1 punto fede
		
		LeaderCard giovanniDalleBandeNere = new LeaderCard("Giovanni Dalle Bande Nere");
		resourceList = new ResourceList(new MilitaryPoint(12));
		giovanniDalleBandeNere.setRequirement(resourceList.clone());
		resourceList = new ResourceList(new Stone(1));
		resourceList.setResource(new Wood(1));
		resourceList.setResource(new Coin(1));
		giovanniDalleBandeNere.setBonus(new IncrementResourceBonus(resourceList.clone()));
		
		LeaderCard sandroBotticelli = new LeaderCard("Sandro Botticelli");
		resourceList = new ResourceList(new Wood(10));
		sandroBotticelli.setRequirement(resourceList.clone());
		resourceList = new ResourceList(new MilitaryPoint(2));
		resourceList.setResource(new VictoryPoint(1));
		sandroBotticelli.setBonus(new IncrementResourceBonus(resourceList.clone()));
		
		LeaderCard michelangeloBuonarroti = new LeaderCard("Michelangelo Buonarroti");
		resourceList = new ResourceList(new Stone(10));
		michelangeloBuonarroti.setRequirement(resourceList.clone());
		resourceList = new ResourceList(new Coin(3));
		michelangeloBuonarroti.setBonus(new IncrementResourceBonus(resourceList.clone()));
		
		LeaderCard ludovicoIIIGonzaga = new LeaderCard("Ludovico III Gonzaga");
		resourceList = new ResourceList(new Servant(15));
		ludovicoIIIGonzaga.setRequirement(resourceList.clone());
		resourceList = new ResourceList(new CouncilPrivilege(1));
		ludovicoAriosto.setBonus(new IncrementResourceBonus(resourceList.clone()));
		
		LeaderCard leonardoDaVinci = new LeaderCard("Leonardo Da Vinci");
		//PARTICOLARE. vuole 2 carte verdi e 4 gialle.
		//effetto: attiva produzione di livello 0
		
		LeaderCard picoDellaMirandola = new LeaderCard("Pico Della Mirandola");
		//Anche lui particolare. vuole 4 viola e 2 gialle.
		//effetto : quando prendi carte hai uno sconto di 3 monete se devi pagarne
		
		LeaderCard sistoIV = new LeaderCard("Sisto IV");
		resourceList = new ResourceList(new Wood(6));
		resourceList.setResource(new Stone(6));
		resourceList.setResource(new Servant(6));
		resourceList.setResource(new Coin(6));
		sistoIV.setRequirement(resourceList.clone());
		//guadagni 5 punti vittoria ogni volta che mostri sostegno alla chiesa
		
		LeaderCard lucreziaBorgia = new LeaderCard("Lucrezia Borgia");
		//richiede 6 carte dello stesso tipo
		//ensures +2 sui dadi
		
		LeaderCard sigismondoMalatesta = new LeaderCard("Sigismondo Malatesta");
		resourceList = new ResourceList(new MilitaryPoint(7));
		resourceList.setResource(new FaithPoint(3));
		sigismondoMalatesta.setRequirement(resourceList.clone());
		//il neutrale ha permanentemente +3
		
		LeaderCard lorenzoDeMedici = new LeaderCard("Lorenzo de' Medici");
		resourceList = new ResourceList(new VictoryPoint(35));
		//copia l'abilita' di un altro leader
		
		LeaderCard ludovicoIlMoro = new LeaderCard("Ludovico Il Moro");
		//vuole 2 carte per tipo
		//setta i familiari colorati permanentemente a 5
		
		LeaderCard cesareBorgia = new LeaderCard("Cesare Borgia");
		resourceList.setResource(new Coin(12));
		resourceList.setResource(new FaithPoint(2));
		cesareBorgia.setRequirement(resourceList.clone());
		cesareBorgia.setCounter(3);
		cesareBorgia.setCardClass(YellowCard.class.toString()); //vuole 3 carte gialle
		//ensures quando prendi le carte verdi non devi soddisfare il requisito sui MilitaryPoints
		
		LeaderCard santaRita = new LeaderCard("Santa Rita");
		resourceList = new ResourceList(new FaithPoint(8));
		santaRita.setRequirement(resourceList.clone());
		//ensures ogni volta che prendi instantBonus ricevi il bonus 2 volte
		
		LeaderCard cosimoDeMedici = new LeaderCard("Cosimo de' Medici");
		//requires 2 carte blue e 4 gialle
		resourceList = new ResourceList(new Servant(3));
		resourceList.setResource(new VictoryPoint(1));
		cosimoDeMedici.setBonus(new IncrementResourceBonus(resourceList.clone()));
		
		LeaderCard bartolomeoColleoni = new LeaderCard("Bartolomeo Colleoni");
		//richiede 2 carte viola e 4 verdi;
		resourceList = new ResourceList(new VictoryPoint(4));
		bartolomeoColleoni.setBonus(new IncrementResourceBonus(resourceList.clone()));
		
		ArrayList<LeaderCard> leaderCards = new ArrayList<LeaderCard>();
		type = new TypeToken<ArrayList<LeaderCard>>(){}.getType();
		
		leaderCards.add(francescoSforza);
		leaderCards.add(ludovicoAriosto);
		leaderCards.add(filippoBrunelleschi);
		leaderCards.add(federicoDaMontefeltro);
		leaderCards.add(girolamoSavonarola);
		leaderCards.add(giovanniDalleBandeNere);
		leaderCards.add(sandroBotticelli);
		leaderCards.add(michelangeloBuonarroti);
		leaderCards.add(ludovicoIIIGonzaga);
		leaderCards.add(leonardoDaVinci);
		leaderCards.add(picoDellaMirandola);
		leaderCards.add(sistoIV);
		leaderCards.add(lucreziaBorgia);
		leaderCards.add(sigismondoMalatesta);
		leaderCards.add(lorenzoDeMedici);
		leaderCards.add(ludovicoIlMoro);
		leaderCards.add(cesareBorgia);
		leaderCards.add(santaRita);
		leaderCards.add(cosimoDeMedici);
		leaderCards.add(bartolomeoColleoni);
		
		writeFile("settings/LeaderCards", gAdapter.toJson(leaderCards,type));
		//FINE LEADER CARDS
	}
	
}






