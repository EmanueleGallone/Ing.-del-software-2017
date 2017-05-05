package pos;

import pos.players.ResourceManagerAlternativo;

public class mainTest {
	
	public static void main(String[] args){
		ResourceManagerAlternativo t1 = new ResourceManagerAlternativo(3);
		ResourceManagerAlternativo t2 = new ResourceManagerAlternativo(2);

		
		if(t1.greater(t2))
			stampa("true");
		else {
			stampa("false");
		}
	}
	
	public static void stampa(String testo){
		System.out.println(testo);
	}
}
