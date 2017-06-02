package it.polimi.ingsw.ps11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.bonus.Bonus;
import it.polimi.ingsw.ps11.cranio.bonus.EnableHarvestBonus;
import it.polimi.ingsw.ps11.cranio.bonus.EnableProductionBonus;
import it.polimi.ingsw.ps11.cranio.bonus.GetAnotherCardBonus;
import it.polimi.ingsw.ps11.cranio.bonus.IncrementResourceBonus;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.cards.list.GreenCard;
import it.polimi.ingsw.ps11.cranio.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.cranio.resources.Resource;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.resources.list.CouncilPrivilege;
import it.polimi.ingsw.ps11.cranio.resources.list.FaithPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Servant;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;
import it.polimi.ingsw.ps11.cranio.zones.Board;
import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.cranio.zones.Market;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.MultipleActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.towers.BlueTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.GreenTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.PurpleTower;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;
import it.polimi.ingsw.ps11.cranio.zones.towers.YellowTower;

public class MainTest {
	
	
	
	public static void main(String[] args){
		
		inizializzaCarte();
		
		
		//inizializzatore();		
		/*String string = readFile("settings\\board");

		ArrayList<Class<?>> list = new ArrayList<>();
		list.add(DevelopmentCard.class);
		list.add(Resource.class);
		list.add(Tower.class);
		
		JsonAdapter jsonAdapter = new JsonAdapter(list);
		Board board = jsonAdapter.fromJson(string, Board.class);
		
		System.out.println(board.getTower(BlueTower.class).getFloors().get(3).getActionSpace().getResources());
		*/
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
	
 
 
	public static void inizializzatore(){
		
		ArrayList<Class<?>> list = new ArrayList<>();
		list.add(DevelopmentCard.class);
		list.add(Resource.class);
		list.add(Tower.class);
		//list.add(ResourceList.class);
		
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
		
		
		ArrayList<ActionSpace> list2 = new ArrayList<>();
		
		resource = new ResourceList();
		resource.setResource(new Coin(5));
		list2.add(new ActionSpace(resource.clone()));
		
		resource = new ResourceList();
		resource.setResource(new Servant(5));
		list2.add(new ActionSpace(resource.clone()));
		
		resource = new ResourceList();
		resource.setResource(new Coin(2));
		resource.setResource(new MilitaryPoint(3));
		list2.add(new ActionSpace(resource.clone()));
		
		/*
		CouncilPrivilege councilPrivilege = new CouncilPrivilege();
		
		councilPrivilege.setResource(new Wood(1));
		councilPrivilege.setResource(new Stone(1));
		councilPrivilege.setResource(new Servant(2));
		councilPrivilege.setResource(new Coin(2));
		councilPrivilege.setResource(new MilitaryPoint(2));
		councilPrivilege.setResource(new FaithPoint(1));
		
		list2.add(new ActionSpace(councilPrivilege));
		*/
		
		Market market = new Market(list2);
		
  // ___________________________________________________
		
		
		
		Board board = new Board(towers,market,new MultipleActionSpace());
		
		writeFile("settings\\board", gAdapter.toJson(board));
		
	}
	
	public static void inizializzaCarte(){
		ArrayList<Class<?>> list = new ArrayList<>();
		list.add(DevelopmentCard.class);
		list.add(Resource.class);
		list.add(Bonus.class);
		
		JsonAdapter gAdapter = new JsonAdapter(list); //per la scrittura su file
		
		//ArrayList<GreenCard> arrayList = new ArrayList<GreenCard>(); //volevo inserire tutte le carte in un array e poi salvare con Json ma dà problemi
		
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
		
		//writeFile("settings\\GreenCards", gAdapter.toJson(arrayList)); //lasciato alla fine
		
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
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(3));
		sostegnoVaticano.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(1));
		sostegnoVaticano.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		PurpleCard costruireMura = new PurpleCard();
		costruireMura.setName("Costruire le Mura");
		costruireMura.setPeriod(1);
		resourceList = new ResourceList();
		resourceList.setResource(new Stone(3));
		costruireMura.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(2));
		resourceList.setResource(new CouncilPrivilege(1));
		costruireMura.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(3));
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
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(4));
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
		riparareCattedrale.addInstantBonus(new GetAnotherCardBonus(DevelopmentCard.class)); //ATTENZIONE. VA RIVISTA QUESTA CARTA!
		
		PurpleCard commissionareARteSacra = new PurpleCard();
		commissionareARteSacra.setPeriod(3);
		commissionareARteSacra.setName("Commissionare Arte Sacra");
		resourceList = new ResourceList();
		resourceList.setResource(new Wood(6));
		commissionareARteSacra.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(3));
		commissionareARteSacra.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(3));
		commissionareARteSacra.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
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
		resourceList = new ResourceList();
		resourceList.setResource(new MilitaryPoint(15));// player deve avere 15 MP e spenderne 8
		guerraSanta.addCost(resourceList.clone());
		resourceList = new ResourceList();
		resourceList.setResource(new FaithPoint(4));
		guerraSanta.addInstantBonus(new IncrementResourceBonus(resourceList.clone()));
		resourceList = new ResourceList();
		resourceList.setResource(new VictoryPoint(8));
		guerraSanta.addPermanentBonus(new IncrementResourceBonus(resourceList.clone()));
		
		//writeFile("settings\\PurpleCards", gAdapter.toJson(arrayList)); //lasciato alla fine
		
		//FINE CARTE VIOLA
		
		
		
	}
	
}






