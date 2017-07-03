package it.polimi.ingsw.ps11.model.loaders;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.reflect.TypeToken;

import it.polimi.ingsw.ps11.model.FileRegistry;
import it.polimi.ingsw.ps11.model.JsonAdapter;
import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.ActiveYieldLeaderCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.AddResourceLeaderCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.DiscountLeaderCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.LeaderCard;
import it.polimi.ingsw.ps11.model.cards.leaderCards.UniqueEffectLeaderCard;
import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.game.Board;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.ActiveYieldEffect;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.AnotherCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.CardDiscount;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.CouncilPrivilege;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.ExchangeEffect;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.FamilyInFloorBonus;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.FamilyInYieldBonus;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.IncrementForCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.ResourceAtTheEnd;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class InitializeCards {
	
	public static void main(String[] args) {
		//inizializzaCarte();
		//LeaderCardsInitializer();
	}
	
	public static void inizializzaCarte(){
		
		JsonAdapter gAdapter = new JsonAdapter(); //per la scrittura su file
		
		ResourceList resourceList = new ResourceList();
		
		/*
		 * esempio
		DevelopmentCard card = new YellowCard();
		
		card.addInstantEffect(new AddResourceEffect(new ResourceList(new Coin(3))));
		card.addPermanentEffect(new CouncilPrivilege(council)); //il privilegio del consiglio è un effetto e va passata la resource list con i valori
		
		card.addPermanentEffect(new FamilyInFloorBonus(BlueCard.class, 2)); //+2 per le carte blue
		card.addPermanentEffect(new CardDiscount(BlueCard.class,new ResourceList(new Coin(1)))); //sconto di una moneta per le carte blu
		card.addPermanentEffect(new ActiveYieldEffect(YellowCard.class.toString(), 2)); //attiva produzione
		
		*/
		
		ArrayList<ResourceList> councilPrivilegeResourceLists = new ArrayList<>();
		//per settare il privilegio del consiglio. io lo sposterei all'interno del costruttore del privilegio
		resourceList.setResource(new Wood(1));
		resourceList.setResource(new Stone(1));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList(new Servant(2));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList(new Coin(2));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList(new MilitaryPoint(2));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(1));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList();
		
		//INIZIO CARTE VERDI
		
		GreenCard avampostoCommerciale = new GreenCard(); //creazione carta
		avampostoCommerciale.setPeriod(1);
		avampostoCommerciale.setName("Commercial Hub");
		avampostoCommerciale.setActiveValue(1); //setto il valore per il quale è possibile attivare il bonus permanente
		resourceList.setResource(new Coin(1)); //setto la resourceList per il bonus
		avampostoCommerciale.addPermanentEffect(new AddResourceEffect(resourceList.clone())); //attribuzione del bonus permanente alla carta
		
		GreenCard bosco = new GreenCard();
		bosco.setActiveValue(2);
		bosco.setPeriod(1);
		bosco.setName("Woods");
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(1));
		bosco.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		bosco.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard borgo = new GreenCard();
		borgo.setName("Village");
		borgo.setPeriod(1);
		borgo.setActiveValue(3);
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(1));
		resourceList.setResource(new Coin(1));
		borgo.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard monastero = new GreenCard();
		monastero.setPeriod(1);
		monastero.setName("Monastery");
		monastero.setActiveValue(6);
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2));
		resourceList.setResource(new Servant(1));
		monastero.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(1));
		resourceList.setResource(new Stone(1));
		monastero.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard foresta = new GreenCard();
		foresta.setPeriod(1);
		foresta.setName("Forest");
		foresta.setActiveValue(5);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(1));
		foresta.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(3));
		foresta.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard rocca = new GreenCard();
		rocca.setPeriod(1);
		rocca.setName("Citadel");
		rocca.setActiveValue(5);
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2));
		resourceList.setResource(new Stone(1));
		rocca.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard citta = new GreenCard();
		citta.setActiveValue(6);
		citta.setPeriod(1);
		citta.setName("City'");
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(3));
		citta.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		citta.addPermanentEffect(new CouncilPrivilege(councilPrivilegeResourceLists));
		
		GreenCard cavaGhiaia = new GreenCard();
		cavaGhiaia.setActiveValue(4);
		cavaGhiaia.setName("Gravel Pit");
		cavaGhiaia.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		cavaGhiaia.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		cavaGhiaia.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		//INIZIO SECONDO PERIODO
		
		GreenCard eremo = new GreenCard();
		eremo.setActiveValue(2);
		eremo.setName("Hermitage");
		eremo.setPeriod(2);
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(1));
		eremo.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		eremo.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard villaggioMinerario = new GreenCard();
		villaggioMinerario.setActiveValue(4);
		villaggioMinerario.setName("Mining Town");
		villaggioMinerario.setPeriod(2);
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(2));
		resourceList.setResource(new Stone(1));
		villaggioMinerario.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(1));
		resourceList.setResource(new Stone(2));
		villaggioMinerario.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard ducato = new GreenCard();
		ducato.setActiveValue(6);
		ducato.setPeriod(2);
		ducato.setName("Dukedom");
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(4));
		ducato.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList.setResource(new Coin(1));
		resourceList.setResource(new Wood(2));
		resourceList.setResource(new Stone(1));
		ducato.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard maniero = new GreenCard();
		maniero.setActiveValue(5);
		maniero.setPeriod(2);
		maniero.setName("Manor House");
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2));
		resourceList.setResource(new Servant(2));
		maniero.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard possedimento = new GreenCard();
		possedimento.setActiveValue(4);
		possedimento.setPeriod(2);
		possedimento.setName("Estate");
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(2));
		resourceList.setResource(new Wood(1));
		possedimento.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList= new ResourceList();
		resourceList.setResource(new Coin(1));
		resourceList.setResource(new Wood(2));
		possedimento.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard villaggioMontano = new GreenCard();
		villaggioMontano.setActiveValue(3);
		villaggioMontano.setName("Mountain Town");
		villaggioMontano.setPeriod(2);
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(1));
		villaggioMontano.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(1));
		resourceList.setResource(new Wood(2));
		villaggioMontano.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard cavaDiPietra = new GreenCard();
		cavaDiPietra.setActiveValue(3);
		cavaDiPietra.setPeriod(2);
		cavaDiPietra.setName("Rock Pit");
		resourceList = new ResourceList(new Wood(1));
		cavaDiPietra.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList(new Stone(3));
		cavaDiPietra.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard minieraOro = new GreenCard();
		minieraOro.setActiveValue(1);
		minieraOro.setPeriod(2);
		minieraOro.setName("Gold Mine");
		resourceList = new ResourceList();
		resourceList.setResource( new Coin(1));
		minieraOro.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList.setResource(new Coin(2));
		minieraOro.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		//INIZIO TERZO PERIODO
		
		GreenCard castello = new GreenCard();
		castello.setActiveValue(4);
		castello.setName("Castle");
		castello.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(2));
		resourceList.setResource(new Coin(2));
		castello.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(3));
		resourceList.setResource(new Servant(1));
		castello.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard cittaFortificata = new GreenCard();
		cittaFortificata.setActiveValue(2);
		cittaFortificata.setName("Fortified Town");
		cittaFortificata.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2));
		resourceList.setResource(new Servant(1));
		cittaFortificata.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(1));
		resourceList.setResource(new Servant(2));
		cittaFortificata.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard colonia = new GreenCard();
		colonia.setActiveValue(5);
		colonia.setPeriod(3);
		colonia.setName("Colony");
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2));
		colonia.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		resourceList.setResource(new Wood(1));
		colonia.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard santuario = new GreenCard();
		santuario.setActiveValue(1);
		santuario.setName("Sanctuary");
		santuario.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(1));
		santuario.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList.setResource(new Coin(1));
		santuario.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard cavaDiMarmo = new GreenCard();
		cavaDiMarmo.setActiveValue(2);
		cavaDiMarmo.setName("Marble Pit");
		cavaDiMarmo.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(3));
		cavaDiMarmo.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList.setResource(new VictoryPoint(1));
		resourceList.setResource(new Servant(2));
		cavaDiMarmo.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard provincia = new GreenCard();
		provincia.setActiveValue(6);
		provincia.setName("Province");
		provincia.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(1));
		provincia.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		provincia.addInstantEffect(new CouncilPrivilege(councilPrivilegeResourceLists));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		resourceList.setResource(new Stone(1));
		provincia.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard cittaMercantile = new GreenCard();
		cittaMercantile.setActiveValue(1);
		cittaMercantile.setName("Trading Town");
		cittaMercantile.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(3));
		cittaMercantile.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(1));
		resourceList.setResource(new Servant(1));
		cittaMercantile.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		
		GreenCard tenuta = new GreenCard();
		tenuta.setActiveValue(3);
		tenuta.setName("Farm");
		tenuta.setPeriod(3);
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(1));
		resourceList.setResource(new Wood(1));
		tenuta.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList.setResource(new VictoryPoint(2));
		resourceList.setResource(new Wood(2));
		tenuta.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		ArrayList<GreenCard> greenDeck = new ArrayList<GreenCard>(); 
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
		
		//FINE CARTE VERDI
		
		//INIZIO CARTE VIOLA
		
		PurpleCard campagnaMilitare = new PurpleCard();
		campagnaMilitare.setName("Military Campaign");
		campagnaMilitare.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2)); //richiede che il giocatore abbia 3 punti militari e ne spende 2
		campagnaMilitare.addCost(resourceList.clone()); 
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		campagnaMilitare.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(3));
		campagnaMilitare.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		
		PurpleCard ospitareMendicanti = new PurpleCard();
		ospitareMendicanti.setName("Hosting Panhandlers");
		ospitareMendicanti.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(3));
		ospitareMendicanti.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(4));
		ospitareMendicanti.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		ospitareMendicanti.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard riparareChiesa = new PurpleCard();
		riparareChiesa.setName("Repairing the Church");
		riparareChiesa.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(1));
		resourceList.setResource(new Stone(1));
		resourceList.setResource(new Coin(1));
		riparareChiesa.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(1));
		riparareChiesa.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		riparareChiesa.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard ingaggiareReclute = new PurpleCard();
		ingaggiareReclute.setName("Hiring Recruits");
		ingaggiareReclute.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(4));
		ingaggiareReclute.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(5));
		ingaggiareReclute.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		ingaggiareReclute.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard combattereEresie = new PurpleCard();
		combattereEresie.setName("Fighting Heresies");
		combattereEresie.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(3)); //anche qui, devo avere 5 military points ma ne devo spendere 3
		combattereEresie.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(2));
		combattereEresie.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList= new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		combattereEresie.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard sostegnoVaticano = new PurpleCard();
		sostegnoVaticano.setName("Support to the Bishop");
		sostegnoVaticano.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2)); //devo avere 4 military points e spenderne 2 per prendere la carta
		sostegnoVaticano.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(2));
		resourceList.setResource(new Stone(1));
		resourceList.setResource(new Wood(1));
		sostegnoVaticano.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(3));
		sostegnoVaticano.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList(new VictoryPoint(1));
		sostegnoVaticano.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		PurpleCard costruireMura = new PurpleCard();
		costruireMura.setName("Building the Walls");
		costruireMura.setPeriod(1);
		resourceList = new ResourceList(new Stone(3));
		costruireMura.addCost(resourceList.clone());
		resourceList = new ResourceList(new MilitaryPoint(2));
		costruireMura.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		costruireMura.addInstantEffect(new CouncilPrivilege(councilPrivilegeResourceLists));
		resourceList = new ResourceList(new VictoryPoint(3));
		costruireMura.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		PurpleCard innalzareStatua = new PurpleCard();
		innalzareStatua.setName("Raising a Statue");
		innalzareStatua.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		resourceList.setResource(new Wood(2));
		innalzareStatua.addCost(resourceList.clone());
		resourceList = new ResourceList();
		//ATTENZIONE; questa carta prevede che i 2 favori del consiglio siano DIVERSI
		innalzareStatua.addInstantEffect( new CouncilPrivilege(councilPrivilegeResourceLists));
		innalzareStatua.addInstantEffect( new CouncilPrivilege(councilPrivilegeResourceLists));
		resourceList = new ResourceList(new VictoryPoint(4));
		innalzareStatua.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		//INIZIO SECONDO PERIODO
		
		PurpleCard ingaggiareSoldati = new PurpleCard();
		ingaggiareSoldati.setName("Hiring Soldiers");
		ingaggiareSoldati.setPeriod(2);
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(6));
		ingaggiareSoldati.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(6));
		ingaggiareSoldati.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		ingaggiareSoldati.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard scavareCanalizzazioni = new PurpleCard();
		scavareCanalizzazioni.setName("Improving the Canals");
		scavareCanalizzazioni.setPeriod(2);
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(2));
		resourceList.setResource(new Coin(3));
		scavareCanalizzazioni.addCost(resourceList.clone());
		resourceList = new ResourceList();
		scavareCanalizzazioni.addInstantEffect(new ActiveYieldEffect(GreenCard.class.toString(), 4));
		resourceList.setResource(new VictoryPoint(5));
		scavareCanalizzazioni.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard riparareAbbazia = new PurpleCard();
		riparareAbbazia.setPeriod(2);
		riparareAbbazia.setName("Repairing the Abbey");
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		resourceList.setResource(new Wood(2));
		resourceList.setResource(new Coin(2));
		riparareAbbazia.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(2));
		riparareAbbazia.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(6));
		riparareAbbazia.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard supportoRe = new PurpleCard();
		supportoRe.setPeriod(2);
		supportoRe.setName("Support to the King");
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(3)); //anche qui, il player deve avere 6 MP e spenderne 3
		supportoRe.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(5));
		supportoRe.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		supportoRe.addInstantEffect(new CouncilPrivilege(councilPrivilegeResourceLists));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(3));
		supportoRe.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard sostegnoCardinale = new PurpleCard();
		sostegnoCardinale.setPeriod(2);
		sostegnoCardinale.setName("Support to the Cardinal");
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(4)); //player deve avere 7 MP e spenderne 4
		sostegnoCardinale.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(3));
		resourceList.setResource(new Wood(2));
		resourceList.setResource(new Stone(2));
		sostegnoCardinale.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(3));
		sostegnoCardinale.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		sostegnoCardinale.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard crociata = new PurpleCard();
		crociata.setPeriod(2);
		crociata.setName("Crusade");
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(4)); //player deve avere 8 MP e spenderne 4
		crociata.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(5));
		resourceList.setResource(new FaithPoint(1));
		crociata.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		crociata.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard costruireBastioni = new PurpleCard();
		costruireBastioni.setPeriod(2);
		costruireBastioni.setName("Building the Bastions");
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(4));
		costruireBastioni.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(3));
		costruireBastioni.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		costruireBastioni.addInstantEffect(new CouncilPrivilege(councilPrivilegeResourceLists));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(2));
		costruireBastioni.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard accogliereStranieri = new PurpleCard();
		accogliereStranieri.setPeriod(2);
		accogliereStranieri.setName("Hosting Foreigners");
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(4));
		accogliereStranieri.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(5));
		accogliereStranieri.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		accogliereStranieri.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		//INIZIO TERZO PERIODO
		
		PurpleCard riparareCattedrale = new PurpleCard(); //CARTA DA RIVEDERE!
		riparareCattedrale.setPeriod(3);
		riparareCattedrale.setName("Repairing the Cathedral");
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(3));
		resourceList.setResource(new Stone(3));
		resourceList.setResource(new Wood(3));
		riparareCattedrale.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		riparareCattedrale.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(1));
		riparareCattedrale.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		riparareCattedrale.addInstantEffect(new AnotherCard(null, 7));
		
		PurpleCard commissionareArteSacra = new PurpleCard();
		commissionareArteSacra.setPeriod(3);
		commissionareArteSacra.setName("Promoting Sacred Art");
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(6));
		commissionareArteSacra.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(3));
		commissionareArteSacra.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(3));
		commissionareArteSacra.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard costruireTorri = new PurpleCard();
		costruireTorri.setPeriod(3);
		costruireTorri.setName("Building the Towers");
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(6));
		costruireTorri.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(4));
		costruireTorri.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		costruireTorri.addInstantEffect(new CouncilPrivilege(councilPrivilegeResourceLists));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		costruireTorri.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard ingaggiareMercenari = new PurpleCard();
		ingaggiareMercenari.setPeriod(3);
		ingaggiareMercenari.setName("Hiring Mercenaries");
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(8));
		ingaggiareMercenari.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(7));
		ingaggiareMercenari.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(6));
		ingaggiareMercenari.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard migliorareStrade = new PurpleCard();
		migliorareStrade.setPeriod(3);
		migliorareStrade.setName("Improving the Roads");
		resourceList = new ResourceList();
		resourceList.setResource(new Servant(3));
		resourceList.setResource(new Coin(4));
		migliorareStrade.addCost(resourceList.clone());
		migliorareStrade.addInstantEffect(new ActiveYieldEffect(YellowCard.class.toString(),3)); //attiva la produzione con valore 3
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		migliorareStrade.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		PurpleCard conquistaMilitare = new PurpleCard();
		conquistaMilitare.setPeriod(3);
		conquistaMilitare.setName("Military Conquest");
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(6)); //il player deve avere 12 MP e spenderne 6
		conquistaMilitare.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(3));
		resourceList.setResource(new Wood(3));
		resourceList.setResource(new Coin(3));
		conquistaMilitare.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(7));
		conquistaMilitare.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard sostegnoPapa = new PurpleCard();
		sostegnoPapa.setPeriod(3);
		sostegnoPapa.setName("Support to the Pope");
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(5)); //player deve avere 10 MP e spenderne 5
		sostegnoPapa.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(4));
		resourceList.setResource(new Wood(3));
		resourceList.setResource(new Stone(3));
		sostegnoPapa.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(2));
		sostegnoPapa.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(10));
		sostegnoPapa.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		PurpleCard guerraSanta = new PurpleCard();
		guerraSanta.setPeriod(3);
		guerraSanta.setName("Sacred War");
		resourceList = new ResourceList(new MilitaryPoint(8));// player deve avere 15 MP e spenderne 8
		guerraSanta.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(4));
		guerraSanta.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList(new VictoryPoint(8));
		guerraSanta.addPermanentEffect(new ResourceAtTheEnd(resourceList.clone()));
		
		ArrayList<PurpleCard> purpleDeck = new ArrayList<PurpleCard>();		
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
		
		//FINE CARTE VIOLA
		
		//INIZIO CARTE GIALLE
		ResourceList exchangeable = new ResourceList();
		ResourceList exchange = new ResourceList();
		
		YellowCard residenza = new YellowCard();
		residenza.setActiveValue(1);
		residenza.setPeriod(1);
		residenza.setName("Residence");
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		residenza.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(1));
		residenza.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		exchange.setResource(new Coin(1));
		exchangeable.setResource(new Servant(2));
		ExchangeEffect exc = new ExchangeEffect();
		exc.addExchange(exchange.clone(), exchangeable.clone());
		exchangeable = new ResourceList(new Wood(1));
		exchangeable.setResource(new Stone(1));
		exc.addExchange(exchange.clone(), exchangeable.clone());
		exchangeable.setResource(new Coin(2));
		exc.addExchange(exchange.clone(), exchangeable.clone());
		exchangeable.setResource(new FaithPoint(1));
		exc.addExchange(exchange.clone(), exchangeable.clone());
		exchangeable.setResource(new MilitaryPoint(2));
		exc.addExchange(exchange.clone(), exchangeable.clone());
		residenza.addPermanentEffect(exc); //il casino è dovuto al CouncilPrivilege. si emula in questa carta
		
		YellowCard teatro = new YellowCard();
		teatro.setActiveValue(6);
		teatro.setName("Theater");
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
		teatro.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(1));
		teatro.addPermanentEffect(new IncrementForCard(BlueCard.class.toString(), resourceList.clone()));
		
		YellowCard esattoria = new YellowCard();
		esattoria.setActiveValue(5);
		esattoria.setPeriod(1);
		esattoria.setName("Tax Office");
		resourceList = new ResourceList(new Wood(3));
		esattoria.addCost(resourceList.clone());
		resourceList = new ResourceList(new Stone(1));
		esattoria.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(5));
		esattoria.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList(new Coin(1));
		esattoria.addPermanentEffect(new IncrementForCard(GreenCard.class.toString(), resourceList.clone()));
		
		YellowCard arcoTrionfo = new YellowCard();
		arcoTrionfo.setActiveValue(6);
		arcoTrionfo.setPeriod(1);
		arcoTrionfo.setName("Triumphal Arch");
		resourceList = new ResourceList(new Coin(2));
		arcoTrionfo.addCost(resourceList.clone());
		resourceList = new ResourceList(new Stone(2));
		arcoTrionfo.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(6));
		arcoTrionfo.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList(new VictoryPoint(1));
		arcoTrionfo.addPermanentEffect(new IncrementForCard(PurpleCard.class.toString(), resourceList.clone()));
		
		YellowCard zecca = new YellowCard();
		zecca.setActiveValue(5);
		zecca.setName("Mint");
		zecca.setPeriod(1);
		resourceList = new ResourceList(new Wood(1));
		zecca.addCost(resourceList.clone());
		resourceList = new ResourceList(new Stone(3));
		zecca.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(5));
		zecca.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList(new Coin(1));
		zecca.addPermanentEffect(new IncrementForCard(YellowCard.class.toString(), resourceList.clone()));
		
		YellowCard falegnameria = new YellowCard();
		falegnameria.setActiveValue(4);
		falegnameria.setPeriod(1);
		falegnameria.setName("Carpenter's Shop");
		resourceList = new ResourceList(new Coin(1));
		falegnameria.addCost(resourceList.clone());
		resourceList = new ResourceList(new Wood(2));
		falegnameria.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(3));
		falegnameria.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		exchange = new ResourceList(new Wood(1));
		exchangeable = new ResourceList(new Coin(3));
		ExchangeEffect exchangeEffect = new ExchangeEffect();
		exchangeEffect.addExchange(exchange.clone(), exchangeable.clone());
		exchange = new ResourceList(new Wood(2));
		exchangeable = new ResourceList(new Coin(5));
		exchangeEffect.addExchange(exchange.clone(), exchangeable.clone());
		falegnameria.addPermanentEffect(exchangeEffect);
		
		YellowCard cappella = new YellowCard(); //bonus permanente da rivedere
		cappella.setPeriod(1);
		cappella.setName("Chapel");
		cappella.setActiveValue(2);
		resourceList = new ResourceList(new Wood(2));
		cappella.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(1));
		cappella.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		exchange = new ResourceList();
		exchangeable = new ResourceList();
		exchange.setResource(new Coin(1));
		exchangeable.setResource(new FaithPoint(1));
		ExchangeEffect exchangeEffect3 = new ExchangeEffect();
		exchangeEffect3.addExchange(exchange.clone(), exchangeable.clone());
		cappella.addPermanentEffect(exchangeEffect3);
		
		YellowCard tagliapietre = new YellowCard();
		tagliapietre.setPeriod(1);
		tagliapietre.setName("Stonemason's Shop");
		tagliapietre.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(1));
		tagliapietre.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		tagliapietre.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(2));
		tagliapietre.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		ExchangeEffect exchangeEffect2 = new ExchangeEffect();
		exchange = new ResourceList(new Stone(1));
		exchangeable = new ResourceList(new Coin(3));
		exchangeEffect2.addExchange(exchange.clone(), exchangeable.clone());
		exchange = new ResourceList(new Stone(2));
		exchangeable = new ResourceList(new Coin(5));
		exchangeEffect2.addExchange(exchange.clone(), exchangeable.clone());
		tagliapietre.addPermanentEffect(exchangeEffect2);
		
		//INIZIO SECONDO PERIODO
		
		YellowCard gildaScultori = new YellowCard();
		gildaScultori.setPeriod(2);
		gildaScultori.setName("Sculptors' Guild");
		gildaScultori.setActiveValue(5);
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(4));
		gildaScultori.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(6));
		gildaScultori.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		ExchangeEffect exc3 = new ExchangeEffect();
		exchange = new ResourceList(new Stone(1));
		exchangeable = new ResourceList(new VictoryPoint(3));
		exc3.addExchange(exchange.clone(), exchangeable.clone());
		exchange = new ResourceList(new Stone(3));
		exchangeable = new ResourceList(new VictoryPoint(7));
		exc3.addExchange(exchange.clone(), exchangeable.clone());
		gildaScultori.addPermanentEffect(exc3);
		
		YellowCard gildaCostruttori = new YellowCard();
		gildaCostruttori.setPeriod(2);
		gildaCostruttori.setName("Stonemasons' Guild");
		gildaCostruttori.setActiveValue(4);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(1));
		gildaCostruttori.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(2));
		gildaCostruttori.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		gildaCostruttori.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		ExchangeEffect exc4 = new ExchangeEffect();
		exchange = new ResourceList(new Stone(1));
		exchange.setResource(new Servant(1));
		exchange.setResource(new Wood(1));
		exchangeable = new ResourceList(new VictoryPoint(3));
		exc4.addExchange(exchange.clone(), exchangeable.clone());
		gildaCostruttori.addPermanentEffect(exc4);
		
		YellowCard gildaPittori = new YellowCard();
		gildaPittori.setPeriod(2);
		gildaPittori.setActiveValue(4);
		gildaPittori.setName("Painters' Guild");
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(4));
		gildaPittori.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(5));
		gildaPittori.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		ExchangeEffect exc2 = new ExchangeEffect();
		exchange = new ResourceList(new Wood(1));
		exchangeable = new ResourceList(new VictoryPoint(3));
		exc2.addExchange(exchange.clone(), exchangeable.clone());
		exchange = new ResourceList(new Wood(3));
		exchangeable = new ResourceList(new VictoryPoint(7));
		exc2.addExchange(exchange.clone(), exchangeable.clone());
		gildaPittori.addPermanentEffect(exc2);
		
		YellowCard mercato = new YellowCard();
		mercato.setPeriod(2);
		mercato.setName("Marketplace");
		mercato.setActiveValue(3);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(2));
		mercato.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(1));
		mercato.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(3));
		mercato.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		ExchangeEffect exchangeEffect4 = new ExchangeEffect();
		exchange = new ResourceList(new Coin(3));
		exchangeable = new ResourceList(new Stone(2));
		exchangeable.setResource(new Wood(2));
		exchangeEffect4.addExchange(exchange.clone(), exchangeable.clone());
		mercato.addPermanentEffect(exchangeEffect4);
		
		YellowCard battistero = new YellowCard();
		battistero.setName("Baptistery");
		battistero.setPeriod(2);
		battistero.setActiveValue(2);
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(3));
		battistero.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(2));
		resourceList.setResource(new FaithPoint(1));
		battistero.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		ExchangeEffect exch = new ExchangeEffect();
		exchange = new ResourceList(new FaithPoint(1));
		exchangeable = new ResourceList(new Coin(2));
		exchangeable.setResource(new VictoryPoint(2));
		exchangeEffect4.addExchange(exchange.clone(), exchangeable.clone());
		battistero.addPermanentEffect(exch);
		
		YellowCard fortezza = new YellowCard();
		fortezza.setPeriod(2);
		fortezza.setName("Stronghold");
		fortezza.setActiveValue(6);
		resourceList = new ResourceList(new Coin(2));
		fortezza.addCost(resourceList.clone());
		resourceList = new ResourceList(new Wood(2));
		fortezza.addCost(resourceList.clone());
		resourceList = new ResourceList(new Stone(2));
		fortezza.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(8));
		fortezza.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2));
		resourceList.setResource(new VictoryPoint(2));
		fortezza.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		YellowCard tesoreria = new YellowCard();
		tesoreria.setActiveValue(3);
		tesoreria.setName("Treasury");
		tesoreria.setPeriod(2);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(3));
		tesoreria.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
		tesoreria.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		ExchangeEffect exchangeEffect5 = new ExchangeEffect();
		exchange = new ResourceList(new Coin(1));
		exchangeable = new ResourceList(new VictoryPoint(3));
		exchangeEffect5.addExchange(exchange.clone(), exchangeable.clone());
		exchange = new ResourceList(new Coin(2));
		exchangeable = new ResourceList(new VictoryPoint(5));
		exchangeEffect5.addExchange(exchange.clone(), exchangeable.clone());
		tesoreria.addPermanentEffect(exchangeEffect5);
		
		YellowCard caserma = new YellowCard();
		caserma.setActiveValue(1);
		caserma.setName("Barracks");
		caserma.setPeriod(2);
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(1));
		caserma.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(1));
		caserma.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(3));
		caserma.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		ExchangeEffect exchangeEffect6 = new ExchangeEffect();
		exchange = new ResourceList(new Coin(1));
		exchangeable = new ResourceList(new MilitaryPoint(3));
		exchangeEffect6.addExchange(exchange.clone(), exchangeable.clone());
		caserma.addPermanentEffect(exchangeEffect6);
		
		//INIZIO TERZO PERIODO
		
		YellowCard giardino = new YellowCard();
		giardino.setActiveValue(1);
		giardino.setName("Garden");
		giardino.setPeriod(3);
		resourceList = new ResourceList(new Servant(2));
		giardino.addCost(resourceList.clone());
		resourceList = new ResourceList(new Wood(4));
		giardino.addCost(resourceList.clone());
		resourceList = new ResourceList(new Stone(2));
		giardino.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(10));
		giardino.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList(new VictoryPoint(3));
		giardino.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		YellowCard banca = new YellowCard();
		banca.setPeriod(3);
		banca.setActiveValue(2);
		banca.setName("Bank");
		resourceList = new ResourceList();
		resourceList.setResource(new Coin(3));
		banca.addCost(resourceList.clone());
		resourceList = new ResourceList(new Wood(1));
		banca.addCost(resourceList.clone());
		resourceList = new ResourceList(new Stone(3));
		banca.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(7));
		banca.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList(new Coin(5));
		banca.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		YellowCard basilica = new YellowCard();
		basilica.setPeriod(3);
		basilica.setName("Church");
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
		basilica.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		ExchangeEffect exchangeEffect9 = new ExchangeEffect();
		exchange = new ResourceList(new Wood(1));
		exchange.setResource(new Stone(1)); //sono in AND ma dovrebbero essere in OR
		exchangeable = new ResourceList(new FaithPoint(2));
		exchangeEffect9.addExchange(exchange.clone(), exchangeable.clone());
		basilica.addPermanentEffect(exchangeEffect9);
		
		YellowCard cattedrale = new YellowCard();
		cattedrale.setPeriod(3);
		cattedrale.setActiveValue(2);
		cattedrale.setName("Cathedral");
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(4));
		cattedrale.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(4));
		cattedrale.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(7));
		resourceList.setResource(new FaithPoint(3));
		cattedrale.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(1));
		cattedrale.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		
		YellowCard fiera = new YellowCard();
		fiera.setActiveValue(4);
		fiera.setPeriod(3);
		fiera.setName("Fair");
		resourceList = new ResourceList(new Coin(4));
		fiera.addCost(resourceList.clone());
		resourceList = new ResourceList(new Wood(3));
		fiera.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(8));
		fiera.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList= new ResourceList();
		ExchangeEffect exchangeEffect7 = new ExchangeEffect();
		exchange = new ResourceList(new Coin(4));
		exchangeable = new ResourceList(new Wood(3));
		exchangeable.setResource(new Stone(3));
		exchangeEffect7.addExchange(exchange.clone(), exchangeable.clone());
		fiera.addPermanentEffect(exchangeEffect7);
		
		YellowCard accademiaMilitare = new YellowCard();
		accademiaMilitare.setActiveValue(3);
		accademiaMilitare.setName("Military Academy");
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
		accademiaMilitare.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		ExchangeEffect exc8 = new ExchangeEffect();
		exchange = new ResourceList(new Servant(1));
		exchangeable = new ResourceList(new MilitaryPoint(3));
		exchangeable.setResource(new VictoryPoint(1));
		exc8.addExchange(exchange.clone(), exchangeable.clone());
		accademiaMilitare.addPermanentEffect(exc8);
		
		YellowCard palazzo = new YellowCard();
		palazzo.setActiveValue(6);
		palazzo.setName("Palace");
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
		palazzo.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		ExchangeEffect exchangeEffect8 = new ExchangeEffect();
		exchange = new ResourceList(new Coin(1));
		exchangeable = new ResourceList(new Servant(2));
		exchangeable.setResource(new VictoryPoint(4));
		exchangeEffect8.addExchange(exchange.clone(), exchangeable.clone());
		fiera.addPermanentEffect(exchangeEffect8);
		
		YellowCard castelletto = new YellowCard();
		castelletto.setActiveValue(5);
		castelletto.setName("Fortress");
		castelletto.setPeriod(3);
		resourceList = new ResourceList(new Coin(2));
		castelletto.addCost(resourceList.clone());
		resourceList = new ResourceList(new Wood(2));
		castelletto.addCost(resourceList.clone());
		resourceList = new ResourceList(new Stone(4));
		castelletto.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(9));
		castelletto.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		resourceList = new ResourceList(new VictoryPoint(2));
		castelletto.addPermanentEffect(new AddResourceEffect(resourceList.clone()));
		castelletto.addPermanentEffect(new CouncilPrivilege(councilPrivilegeResourceLists));
		
		ArrayList<YellowCard> yellowDeck = new ArrayList<YellowCard>();		
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
		
		//FINE CARTE GIALLE
		
		//INIZIO CARTE BLU
		BlueCard badessa = new BlueCard();
		badessa.setName("Abbess");
		badessa.setPeriod(1);
		resourceList = new ResourceList(new Coin(3));
		badessa.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(1));
		badessa.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		badessa.addInstantEffect(new AnotherCard(null, 4));
		
		BlueCard predicatore = new BlueCard();
		predicatore.setName("Preacher");
		predicatore.setPeriod(1);
		resourceList = new ResourceList(new Coin(2));
		predicatore.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(4));
		predicatore.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		//va aggiunto il malus che non prendi più le risorse dall'actionspace
		
		BlueCard dama = new BlueCard();
		dama.setName("Dame");
		dama.setPeriod(1);
		resourceList = new ResourceList(new Coin(4));
		dama.addCost(resourceList.clone());
		dama.addPermanentEffect(new FamilyInFloorBonus(BlueCard.class.toString(), 2));
		dama.addPermanentEffect(new CardDiscount(BlueCard.class.toString(), new ResourceList(new Coin(1))));
		
		BlueCard cavaliere = new BlueCard();
		cavaliere.setName("Knight");
		cavaliere.setPeriod(1);
		resourceList = new ResourceList(new Coin(2));
		cavaliere.addCost(resourceList.clone());
		cavaliere.addInstantEffect(new CouncilPrivilege(councilPrivilegeResourceLists));
		cavaliere.addPermanentEffect(new FamilyInFloorBonus(PurpleCard.class.toString(), 2));
		
		BlueCard contadino = new BlueCard();
		contadino.setName("Farmer");
		contadino.setPeriod(1);
		resourceList = new ResourceList(new Coin(3));
		contadino.addCost(resourceList.clone());
		contadino.addPermanentEffect(new FamilyInYieldBonus(GreenCard.class.toString(), 2));
		
		BlueCard artigiano = new BlueCard();
		artigiano.setName("Artisan");
		artigiano.setPeriod(1);
		resourceList = new ResourceList(new Coin(3));
		artigiano.addCost(resourceList.clone());
		artigiano.addPermanentEffect(new FamilyInYieldBonus(YellowCard.class.toString(), 2));
		
		BlueCard costruttore = new BlueCard();
		costruttore.setName("Stonemason");
		costruttore.setPeriod(1);
		resourceList = new ResourceList(new Coin(4));
		costruttore.addCost(resourceList.clone());
		costruttore.addPermanentEffect(new FamilyInFloorBonus(YellowCard.class.toString(), 2));
		resourceList = new ResourceList(new Wood(1));
		resourceList.setResource(new Stone(1));//paghi 1 wood OR stone, qui e' messo in AND
		costruttore.addPermanentEffect(new CardDiscount(YellowCard.class.toString(), resourceList.clone()));
		
		BlueCard condottiero = new BlueCard();
		condottiero.setName("Warlord");
		condottiero.setPeriod(1);
		resourceList = new ResourceList(new Coin(2));
		condottiero.addCost(resourceList.clone());
		resourceList = new ResourceList(new MilitaryPoint(3));
		condottiero.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		condottiero.addPermanentEffect(new FamilyInFloorBonus(GreenCard.class.toString(), 2));
		
		//FINE PRIMO PERIODO
		
		BlueCard messoPapale = new BlueCard();
		messoPapale.setName("Papal Messenger");
		messoPapale.setPeriod(2);
		resourceList = new ResourceList(new Coin(5));
		messoPapale.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(3));
		messoPapale.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		
		BlueCard fattore = new BlueCard();
		fattore.setName("Peasant");
		fattore.setPeriod(2);
		resourceList = new ResourceList(new Coin(4));
		fattore.addCost(resourceList.clone());
		fattore.addPermanentEffect(new FamilyInYieldBonus(GreenCard.class.toString(),3));
		
		BlueCard messoReale = new BlueCard();
		messoReale.setName("Royal Messenger");
		messoReale.setPeriod(2);
		resourceList = new ResourceList(new Coin(5));
		messoReale.addCost(resourceList.clone());
		messoReale.addInstantEffect(new CouncilPrivilege(councilPrivilegeResourceLists));
		messoReale.addInstantEffect(new CouncilPrivilege(councilPrivilegeResourceLists));
		messoReale.addInstantEffect(new CouncilPrivilege(councilPrivilegeResourceLists));
		
		BlueCard mecenate = new BlueCard();
		mecenate.setName("Patron");
		mecenate.setPeriod(2);
		resourceList = new ResourceList(new Coin(3));
		mecenate.addCost(resourceList.clone());
		mecenate.addInstantEffect(new AnotherCard(BlueCard.class.toString(), 6));
		resourceList.setResource(new Coin(2));
		mecenate.addInstantEffect(new CardDiscount(BlueCard.class.toString(), resourceList.clone()));
		
		BlueCard capitano = new BlueCard();
		capitano.setName("Captain");
		capitano.setPeriod(2);
		resourceList = new ResourceList(new Coin(4));
		capitano.addCost(resourceList.clone());
		resourceList = new ResourceList(new MilitaryPoint(2));
		capitano.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		capitano.addInstantEffect(new AnotherCard(GreenCard.class.toString(), 6));
		
		BlueCard studioso = new BlueCard();
		studioso.setName("Scholar");
		studioso.setPeriod(2);
		resourceList = new ResourceList(new Coin(4));
		studioso.addCost(resourceList.clone());
		studioso.addPermanentEffect(new FamilyInYieldBonus(YellowCard.class.toString(), 3));
		
		BlueCard architetto = new BlueCard();
		architetto.setName("Architect");
		architetto.setPeriod(2);
		resourceList = new ResourceList(new Coin(4));
		architetto.addCost(resourceList.clone());
		architetto.addInstantEffect(new AnotherCard(YellowCard.class.toString(), 6));
		resourceList = new ResourceList(new Stone(1));
		resourceList.setResource(new Wood(1));
		architetto.addInstantEffect(new CardDiscount(YellowCard.class.toString(), resourceList.clone()));
		
		BlueCard eroe = new BlueCard();
		eroe.setName("Hero");
		eroe.setPeriod(2);
		resourceList = new ResourceList(new Coin(4));
		eroe.addCost(resourceList.clone());
		eroe.addInstantEffect(new CouncilPrivilege(councilPrivilegeResourceLists));
		eroe.addInstantEffect(new AnotherCard(PurpleCard.class.toString(),6));
		
		//FINE SECONDO PERIODO
		
		BlueCard cardinale = new BlueCard();
		cardinale.setName("Cardinal");
		cardinale.setPeriod(3);
		resourceList = new ResourceList(new Coin(4));
		cardinale.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(2));
		cardinale.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		cardinale.addInstantEffect(new ActiveYieldEffect(GreenCard.class.toString(), 4));
		
		BlueCard araldo = new BlueCard();
		araldo.setName("Herald");
		araldo.setPeriod(3);
		resourceList = new ResourceList(new Coin(6));
		araldo.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(2));
		araldo.addInstantEffect(new IncrementForCard(PurpleCard.class.toString(), resourceList.clone()));
		
		BlueCard vescovo = new BlueCard();
		vescovo.setName("Bishop");
		vescovo.setPeriod(3);
		resourceList = new ResourceList(new Coin(5));
		vescovo.addCost(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(1));
		vescovo.addInstantEffect(new AddResourceEffect(resourceList.clone()));
		vescovo.addInstantEffect(new ActiveYieldEffect(YellowCard.class.toString(), 4));
		
		BlueCard ambasciatore = new BlueCard();
		ambasciatore.setName("Ambassador");
		ambasciatore.setPeriod(3);
		resourceList = new ResourceList(new Coin(6));
		ambasciatore.addCost(resourceList.clone());
		ambasciatore.addInstantEffect(new CouncilPrivilege(councilPrivilegeResourceLists));
		ambasciatore.addInstantEffect(new AnotherCard(null,7));
		
		BlueCard cortigiana = new BlueCard();
		cortigiana.setName("Paramour");
		cortigiana.setPeriod(3);
		resourceList = new ResourceList(new Coin(7));
		cortigiana.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(2));
		cortigiana.addInstantEffect(new IncrementForCard(BlueCard.class.toString(), resourceList.clone()));
		
		BlueCard generale = new BlueCard();
		generale.setName("Generale");
		generale.setPeriod(3);
		resourceList = new ResourceList(new Coin(5));
		generale.addCost(resourceList.clone());
		//aggiungere bonus che ogni 2 MP hai +1 VP
		
		BlueCard nobile = new BlueCard();
		nobile.setName("Noble");
		nobile.setPeriod(3);
		resourceList = new ResourceList(new Coin(6));
		nobile.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(2));
		nobile.addInstantEffect(new IncrementForCard(GreenCard.class.toString(), resourceList.clone()));
		
		BlueCard governatore = new BlueCard();
		governatore.setName("Governor");
		governatore.setPeriod(3);
		resourceList = new ResourceList(new Coin(6));
		governatore.addCost(resourceList.clone());
		resourceList = new ResourceList(new VictoryPoint(2));
		governatore.addInstantEffect(new IncrementForCard(YellowCard.class.toString(), resourceList.clone()));
		
		ArrayList<BlueCard> bluDeck = new ArrayList<BlueCard>();		
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
		
		//costruzione files
		
		List<DevelopmentCard> list = greenDeck.stream().filter(c -> c.getPeriod()==1).collect(Collectors.toList());
		list.addAll(bluDeck.stream().filter(c -> c.getPeriod()==1).collect(Collectors.toList()));
		list.addAll(yellowDeck.stream().filter(c -> c.getPeriod()==1).collect(Collectors.toList()));
		list.addAll(purpleDeck.stream().filter(c -> c.getPeriod()==1).collect(Collectors.toList()));
		
		CardManager cardManager = new CardManager(false);
		for(DevelopmentCard c : list)
			cardManager.addCard(c);
		

		new Loader(FileRegistry.cards+"firstPeriod").write(cardManager);
		//CustomFileReaderWriter.writeFile("settings\\cards\\FirstPeriod", gAdapter.toJson(cardManager,CardManager.class));
		
		list.clear();
		list = greenDeck.stream().filter(c -> c.getPeriod()==2).collect(Collectors.toList());
		list.addAll(bluDeck.stream().filter(c -> c.getPeriod()==2).collect(Collectors.toList()));
		list.addAll(yellowDeck.stream().filter(c -> c.getPeriod()==2).collect(Collectors.toList()));
		list.addAll(purpleDeck.stream().filter(c -> c.getPeriod()==2).collect(Collectors.toList()));
		
		cardManager = new CardManager(false);
		for(DevelopmentCard c : list)
			cardManager.addCard(c);
		
		new Loader(FileRegistry.cards+"secondPeriod").write(cardManager);
		//CustomFileReaderWriter.writeFile("settings\\cards\\SecondPeriod", gAdapter.toJson(cardManager,CardManager.class));

		
		list.clear();
		list = greenDeck.stream().filter(c -> c.getPeriod()==2).collect(Collectors.toList());
		list.addAll(bluDeck.stream().filter(c -> c.getPeriod()==2).collect(Collectors.toList()));
		list.addAll(yellowDeck.stream().filter(c -> c.getPeriod()==2).collect(Collectors.toList()));
		list.addAll(purpleDeck.stream().filter(c -> c.getPeriod()==2).collect(Collectors.toList()));
		
		cardManager = new CardManager(false);
		for(DevelopmentCard c : list)
			cardManager.addCard(c);
		
		new Loader(FileRegistry.cards+"thirdPeriod").write(cardManager);
		//CustomFileReaderWriter.writeFile("settings\\cards\\ThirdPeriod", gAdapter.toJson(cardManager,CardManager.class));

		//Fine costruzione files
	
	}

	public static void LeaderCardsInitializer(){
		//INIZIO CARTE LEADER
		ResourceList resourceList = new ResourceList(new Coin(1));
		
		ActiveYieldEffect activeYieldEffect = new ActiveYieldEffect(GreenCard.class.toString(), 1);
		LeaderCard francescoSforza = new ActiveYieldLeaderCard("Francesco Sforza",activeYieldEffect);
		francescoSforza.getCardsNumber().put(PurpleCard.class.toString(), 5);
		francescoSforza.setRequiredResources(resourceList.clone());
		
		/*
		LeaderCard ludovicoAriosto = new LeaderCard("Ludovico Ariosto"); //io questa carta non la includerei proprio nel gioco
		ludovicoAriosto.setCounter(5);
		ludovicoAriosto.setCardClass(BlueCard.class.toString());
		//effetti: puoi posizionare in uno spazio azione già occupato; permanente
		*/
		/*
		LeaderCard filippoBrunelleschi = new LeaderCard("Filippo Brunelleschi");
		costs.clear();
		costs.put(YellowCard.class.toString(), 5);
		//effetti: non paghi più le 3 monete se posizioni il familiare in una torre già occupata; permanente
		
		LeaderCard federicoDaMontefeltro = new LeaderCard("Federico Da Montefeltro");
		federicoDaMontefeltro.setCounter(5);
		federicoDaMontefeltro.setCardClass(GreenCard.class.toString());
		//effetto : un familiare ha valore 6 una volta per turno
		*/
		resourceList = new ResourceList(new FaithPoint(1));
		AddResourceEffect addResourceEffect = new AddResourceEffect(resourceList.clone());
		LeaderCard girolamoSavonarola = new AddResourceLeaderCard("Girolamo Savonarola",addResourceEffect);
		resourceList = new ResourceList(new Coin(18));
		girolamoSavonarola.setRequiredResources(resourceList.clone());
	
		resourceList = new ResourceList(new Coin(1));
		resourceList.setResource(new Wood(1));
		resourceList.setResource(new Stone(1));
		AddResourceEffect addResourceEffect3 = new AddResourceEffect(resourceList.clone());
		LeaderCard giovanniDalleBandeNere = new AddResourceLeaderCard("Giovanni Dalle Bande Nere",addResourceEffect3);
		resourceList = new ResourceList(new MilitaryPoint(12));
		giovanniDalleBandeNere.setRequiredResources(resourceList.clone());

		resourceList = new ResourceList(new MilitaryPoint(2));
		resourceList.setResource(new VictoryPoint(1));
		AddResourceEffect addResourceE = new AddResourceEffect(resourceList.clone());
		LeaderCard sandroBotticelli = new AddResourceLeaderCard("Sandro Botticelli",addResourceE);
		resourceList = new ResourceList(new Wood(10));
		sandroBotticelli.setRequiredResources(resourceList.clone());
		
		
		resourceList = new ResourceList(new Stone(3));
		AddResourceEffect addResourceEffect2 = new AddResourceEffect(resourceList.clone());
		LeaderCard michelangeloBuonarroti = new AddResourceLeaderCard("Michelangelo Buonarroti",addResourceEffect2);
		resourceList = new ResourceList(new Stone(10));
		michelangeloBuonarroti.setRequiredResources(resourceList.clone());
		
		ArrayList<ResourceList> councilPrivilegeResourceLists = new ArrayList<>();
		//per settare il privilegio del consiglio. io lo sposterei all'interno del costruttore del privilegio
		resourceList.setResource(new Wood(1));
		resourceList.setResource(new Stone(1));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList(new Servant(2));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList(new Coin(2));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList(new MilitaryPoint(2));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList(new FaithPoint(1));
		councilPrivilegeResourceLists.add(resourceList.clone());
		resourceList = new ResourceList();
		
		CouncilPrivilege councilPrivilegeEffect = new CouncilPrivilege(councilPrivilegeResourceLists);
		LeaderCard ludovicoIIIGonzaga = new UniqueEffectLeaderCard("Ludovico III Gonzaga", councilPrivilegeEffect);
		resourceList = new ResourceList(new Servant(15));
		ludovicoIIIGonzaga.setRequiredResources(resourceList.clone());
		
		ActiveYieldEffect activeYieldEffect2 = new ActiveYieldEffect(YellowCard.class.toString(), 0);
		LeaderCard leonardoDaVinci = new ActiveYieldLeaderCard("Leonardo Da Vinci",activeYieldEffect2);
		leonardoDaVinci.getCardsNumber().put(BlueCard.class.toString(), 4);
		leonardoDaVinci.getCardsNumber().put(GreenCard.class.toString(), 2);
		
		resourceList = new ResourceList(new Coin(3));
		CardDiscount cardDiscount = new CardDiscount(DevelopmentCard.class.toString(), resourceList.clone());
		LeaderCard picoDellaMirandola = new DiscountLeaderCard("Pico Della Mirandola",cardDiscount);
		picoDellaMirandola.getCardsNumber().put(PurpleCard.class.toString(), 4);
		picoDellaMirandola.getCardsNumber().put(YellowCard.class.toString(), 2);
		
		/*
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
		*/
		resourceList = new ResourceList(new Servant(3));
		resourceList.setResource(new VictoryPoint(1));
		AddResourceEffect addResourceEffect5 = new AddResourceEffect(resourceList.clone());
		LeaderCard cosimoDeMedici = new AddResourceLeaderCard("Cosimo de' Medici",addResourceEffect5);
		cosimoDeMedici.getCardsNumber().put(BlueCard.class.toString(), 2);
		cosimoDeMedici.getCardsNumber().put(YellowCard.class.toString(), 4);
		
		
		resourceList = new ResourceList(new VictoryPoint(4));
		AddResourceEffect addResourceEffect4 = new AddResourceEffect(resourceList.clone());
		LeaderCard bartolomeoColleoni = new AddResourceLeaderCard("Bartolomeo Colleoni",addResourceEffect4);
		bartolomeoColleoni.getCardsNumber().put(GreenCard.class.toString(), 4);
		bartolomeoColleoni.getCardsNumber().put(PurpleCard.class.toString(), 2);
		
		ArrayList<LeaderCard> leaderCards = new ArrayList<LeaderCard>();
		Type type = new TypeToken<ArrayList<LeaderCard>>(){}.getType();
		JsonAdapter gAdapter = new JsonAdapter();
		
		leaderCards.add(francescoSforza);
//		leaderCards.add(ludovicoAriosto);
//		leaderCards.add(filippoBrunelleschi);
//		leaderCards.add(federicoDaMontefeltro);
		leaderCards.add(girolamoSavonarola);
		leaderCards.add(giovanniDalleBandeNere);
		leaderCards.add(sandroBotticelli);
		leaderCards.add(michelangeloBuonarroti);
		leaderCards.add(ludovicoIIIGonzaga);
		leaderCards.add(leonardoDaVinci);
		leaderCards.add(picoDellaMirandola);
//		leaderCards.add(sistoIV);
//		leaderCards.add(lucreziaBorgia);
//		leaderCards.add(sigismondoMalatesta);
//		leaderCards.add(lorenzoDeMedici);
//		leaderCards.add(ludovicoIlMoro);
//		leaderCards.add(cesareBorgia);
//		leaderCards.add(santaRita);
		leaderCards.add(cosimoDeMedici);
		leaderCards.add(bartolomeoColleoni);
		
		new Loader(FileRegistry.cards+"leaderCards").write(leaderCards);
		//CustomFileReaderWriter.writeFile("settings/LeaderCards", gAdapter.toJson(leaderCards,type));
		//FINE LEADER CARDS
	 
	}
}
