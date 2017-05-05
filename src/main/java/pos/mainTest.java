package pos;

import pos.players.ResourceList;
import pos.players.ResourceList.Resource;

public class mainTest {
	
	public static void main(String[] args){
		//ResourceList t1 = new ResourceList(3);
		ResourceList giocatore = new ResourceList(2);

		//t1.get(Resource.FAITH);
		
		ResourceList costo = new ResourceList();
		costo.setResource(Resource.STONE, 5);
		
		if(giocatore.greater(costo))
			stampa("true");
		else {
			stampa("false");
		}
	}
	public static void stampa(String testo){
		System.out.println(testo);
	}
}
