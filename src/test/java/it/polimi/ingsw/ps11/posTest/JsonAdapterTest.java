package it.polimi.ingsw.ps11.posTest;

import static org.junit.Assert.*;

import org.junit.Test;
import it.polimi.ingsw.ps11.cranio.JsonAdapter;
import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMemberManager;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;


public class JsonAdapterTest {

	@Test
	public void ResourceListTest(){
		JsonAdapter json = new JsonAdapter();
		
		ResourceList rList1 = new ResourceList();
		rList1.setResource(new Wood(5));
		rList1.setResource(new Stone(8));
		
		
		String serList1 = json.toJson(rList1);
		
		ResourceList rList2 = json.fromJson(serList1, ResourceList.class);
		
		
		assertTrue("Should be true but is : ", rList1.equals(rList2));
	}
	
	@Test
	public void FamilyManagerTest(){
		JsonAdapter json = new JsonAdapter();
		
		FamilyMemberManager  fManager = new FamilyMemberManager(new Player());

		String ser = json.toJson(fManager);
		System.out.println(ser);
		FamilyMemberManager fManager2 = json.fromJson(ser, FamilyMemberManager.class);
		
		//assertTrue("Should be true but is : ",);
	}
	
	@Test
	public void CardManagerTest(){
		JsonAdapter json = new JsonAdapter();
		
		CardManager  manager = new CardManager();

		String ser = json.toJson(manager);
		System.out.println(ser);
		CardManager manager2 = json.fromJson(ser, CardManager.class);
		
		//assertTrue("Should be true but is : ",);
	}
	
}