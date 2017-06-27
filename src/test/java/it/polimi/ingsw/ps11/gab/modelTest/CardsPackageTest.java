package it.polimi.ingsw.ps11.gab.modelTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.polimi.ingsw.ps11.model.cards.list.BlueCard;
import it.polimi.ingsw.ps11.model.cards.list.GreenCard;
import it.polimi.ingsw.ps11.model.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.resources.list.Servant;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.resources.list.Wood;

public class CardsPackageTest {
	
	/* 1) I COSTRUTTORI NEL DEVELOPMENTCARD NON SONO ABSTRACT E NON VENGONO EREDITATI DALLE CARTE -> SONO INUTILI;
	 * 2) CHECK COST NEL DEVELOPMENTCARD METTONO A CONFRONTO LA RESOURCE LIST DEL GIOCATORE E UNA RESOURCE LIST QUALUNQUE, ANCHE NON 
	 * APPARTENENTE ALLA CARTA -> AGGIUNGERE CONTROLLO;
	 * 3) IL COSTO ALL'INTERNO DELLA CARTA NON HA UTILIZZO PER IL MOTIVO SOPRA
	 * 4) IN CARDMANAGER RIGA 35 "if(temp.size() <= MAX_CARD)" POSSO AVERE FINO A 7 CARTE -> RIMUOVEREL'UGUALE
	 * 6) LE CARTE BLUE SONO DIVERSE DA TUTTE LE ALTRE, ALLE ALTRA MANCA IL COSTRUTTORE CON STRINGA
	 */
	
	private ArrayList<ResourceList> arrayListResourceCostCoin;
	private ResourceList resourceListCostCoin;
	private ArrayList<ResourceList> arrayListResourceCostServant;
	private ResourceList resourceListCostServant;
	private ArrayList<ResourceList> arrayListResourceCostStone;
	private ResourceList resourceListCostStone;
	private ArrayList<ResourceList> arrayListResourceCostWood;
	private ResourceList resourceListCostWood;

	private Coin coin;
	private Servant servant;
	private Stone stone;
	private Wood wood;

	private BlueCard bCard;
	private GreenCard gCard;
	private PurpleCard pCard;
	private YellowCard yCard;
	
	private BlueCard bCardClone;
	private GreenCard gCardClone;
	private PurpleCard pCardClone;
	private YellowCard yCardClone;


	private String bName = "Carta blu";
	private String gName = "Carta verde";
	private String pName = "Carta viola";
	private String yName = "Carta gialla";

	private int periodo0 = 0;
	private int periodo1 = 1;
	private int periodo2 = 2;
	private int periodo3 = 3;
	
	private Player player;
	private ArrayList<Resource> arrayListResourcePlayer;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setting(){
		
		coin = new Coin(1);
		servant = new Servant(1);
		stone = new Stone(1);
		wood = new Wood(1);
		
		arrayListResourceCostCoin = new ArrayList<>();
		resourceListCostCoin = new ResourceList(coin);
		arrayListResourceCostServant = new ArrayList<>();
		resourceListCostServant = new ResourceList(servant);
		arrayListResourceCostStone = new ArrayList<>();
		resourceListCostStone = new ResourceList(stone);
		arrayListResourceCostWood = new ArrayList<>();
		resourceListCostWood = new ResourceList(wood);
		
		arrayListResourceCostCoin.add(resourceListCostCoin);
		arrayListResourceCostServant.add(resourceListCostServant);
		arrayListResourceCostStone.add(resourceListCostStone);
		arrayListResourceCostWood.add(resourceListCostWood);
				
		arrayListResourcePlayer = new ArrayList<>();
		arrayListResourcePlayer.add(coin);
		arrayListResourcePlayer.add(servant);
		arrayListResourcePlayer.add(stone);
		arrayListResourcePlayer.add(wood);

		player = new Player(arrayListResourcePlayer);

		bCard = new BlueCard();
		gCard = new GreenCard();
		pCard = new PurpleCard();
		yCard = new YellowCard();
		
	}
	
	@Test
	public void SetterandGetterCardTest(){	//----------SETTER AND GETTER TEST----------//

		bCard.setName(bName);
		bCard.setPeriod(periodo0);
		assertEquals(bName, bCard.getName());
		assertEquals(periodo0, bCard.getPeriod());
		
		gCard.setName(gName);
		gCard.setPeriod(periodo1);
		assertEquals(gName, gCard.getName());
		assertEquals(periodo1, gCard.getPeriod());
		
		pCard.setName(pName);
		pCard.setPeriod(periodo2);
		assertEquals(pName, pCard.getName());
		assertEquals(periodo2, pCard.getPeriod());
		
		yCard.setName(yName);
		yCard.setPeriod(periodo3);
		assertEquals(yName, yCard.getName());
		assertEquals(periodo3, yCard.getPeriod());
	}
	
	@Test
	public void EqualsCardTest(){	//----------EQUALS TEST----------//
				
		bCard.setName(bName);
		gCard.setName(bName);
		pCard.setName(bName);
		yCard.setName(bName);
		
		bCardClone = bCard.clone();
		
		//assertTrue(bCardClone.equals(bCard));		
		assertFalse(bCard.equals(null));
		assertFalse(bCard.equals(gCard));
		assertFalse(bCard.equals(pCard));
		assertFalse(bCard.equals(yCard));
		
		gCardClone = gCard.clone();
		
		//assertTrue(bCardClone.equals(bCard));		
		assertFalse(gCard.equals(null));
		assertFalse(gCard.equals(bCard));
		assertFalse(gCard.equals(pCard));
		assertFalse(gCard.equals(yCard));
		
		pCardClone = pCard.clone();
		
		//assertTrue(bCardClone.equals(bCard));		
		assertFalse(pCard.equals(null));
		assertFalse(pCard.equals(gCard));
		assertFalse(pCard.equals(bCard));
		assertFalse(pCard.equals(yCard));
		
		yCardClone = yCard.clone();
		
		//assertTrue(bCardClone.equals(bCard));		
		assertFalse(yCard.equals(null));
		assertFalse(yCard.equals(gCard));
		assertFalse(yCard.equals(pCard));
		assertFalse(yCard.equals(bCard));
		
		bCardClone.setName(gName);
		//assertFalse(bCardClone.equals(bCard));
		bCardClone = new BlueCard(bName);
		//assertTrue(bCardClone.equals(bCard));
		
		gCardClone.setName(gName);
		//assertFalse(gCardClone.equals(bCard));
		//gCardClone = new GreenCard(gName);
		//assertTrue(gCardClone.equals(bCard));
		
		pCardClone.setName(gName);
		//assertFalse(pCardClone.equals(bCard));
		//pCardClone = new PurpleCard(bName);
		//assertTrue(pCardClone.equals(bCard));
		
		yCardClone.setName(gName);
		//assertFalse(yCardClone.equals(bCard));
		//yCardClone = new YellowCard(bName);
		//assertTrue(yCardClone.equals(bCard));
	}
	
	@Test
	public void CostsCardTest(){	//----------COSTS TEST----------//
		
		bCard.setCosts(arrayListResourceCostCoin);
		assertTrue(bCard.checkCost(player.getResourceList(), resourceListCostCoin));
		assertTrue(bCard.checkCost(player.getResourceList(), resourceListCostServant));
		assertTrue(bCard.checkCost(player.getResourceList(), resourceListCostStone));
		assertTrue(bCard.checkCost(player.getResourceList(), resourceListCostWood));

		
		assertTrue(bCard.take(player, resourceListCostCoin));
		
		assertFalse(bCard.checkCost(player.getResourceList(), resourceListCostCoin));
		assertTrue(bCard.checkCost(player.getResourceList(), resourceListCostServant));
		assertTrue(bCard.checkCost(player.getResourceList(), resourceListCostStone));
		assertTrue(bCard.checkCost(player.getResourceList(), resourceListCostWood));
		
		ResourceList mixed = new ResourceList();	//LA MIXED HA UNA COIN E UNA STONE, IL GIOCATORE UN SERVANT, UNA STONE, UN WOOD
		mixed.setResource(coin);					//AL GIOCATORE MANCA UNA COIN -> NON PUò PRENDERE LA CARTA
		mixed.setResource(stone);
		assertFalse(bCard.checkCost(player.getResourceList(), mixed));
		
		assertFalse(bCard.take(player, resourceListCostCoin));
		assertTrue(bCard.take(player, resourceListCostServant));
		assertTrue(bCard.take(player, resourceListCostStone));
		assertTrue(bCard.take(player, resourceListCostWood));
		
	}
	
	@Test
	public void addCardTest(){

		player.getResourceList().setResource(new Coin(9));
		
		assertTrue(bCard.checkCost(player.getResourceList(), resourceListCostCoin));
		for(int i=0; i<=6; i++){
		assertTrue(bCard.take(player, resourceListCostCoin)); 		//IL GIOCATORE PUò PRENDERE 7 CARTE BLU, POI FINISCONO GLI SPAZI
		}
		assertFalse(bCard.take(player, resourceListCostCoin));
		assertTrue(bCard.checkCost(player.getResourceList(), resourceListCostCoin)); //NONOSTANTE ABBIA LE RISORSE NON HA GLI SPAZI
		//assertEquals( 44, player.getResourceList().getResource(coin));		NON LO PRENDE?
		
		/*assertTrue(gCard.checkCost(player.getResourceList(), resourceListCostCoin));
		for(int i=0; i<=6; i++){
		assertTrue(gCard.take(player, resourceListCostCoin)); 		//IL GIOCATORE PUò PRENDERE 7 CARTE VERDI, POI FINISCONO GLI SPAZI
		}
		assertFalse(gCard.take(player, resourceListCostCoin));
		assertTrue(gCard.checkCost(player.getResourceList(), resourceListCostCoin)); //NONOSTANTE ABBIA LE RISORSE NON HA GLI SPAZI
	
		assertTrue(pCard.checkCost(player.getResourceList(), resourceListCostCoin));
		for(int i=0; i<=6; i++){
		assertTrue(pCard.take(player, resourceListCostCoin)); 		//IL GIOCATORE PUò PRENDERE 7 CARTE VIOLA, POI FINISCONO GLI SPAZI
		}
		assertFalse(pCard.take(player, resourceListCostCoin));
		assertTrue(pCard.checkCost(player.getResourceList(), resourceListCostCoin)); //NONOSTANTE ABBIA LE RISORSE NON HA GLI SPAZI
	
		assertTrue(yCard.checkCost(player.getResourceList(), resourceListCostCoin));
		for(int i=0; i<=6; i++){
		assertTrue(yCard.take(player, resourceListCostCoin)); 		//IL GIOCATORE PUò PRENDERE 7 CARTE GIALLE, POI FINISCONO GLI SPAZI
		}
		assertFalse(yCard.take(player, resourceListCostCoin));
		assertTrue(yCard.checkCost(player.getResourceList(), resourceListCostCoin)); //NONOSTANTE ABBIA LE RISORSE NON HA GLI SPAZI
		*/
	}
}
