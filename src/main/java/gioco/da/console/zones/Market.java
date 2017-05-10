package gioco.da.console.zones;

public class Market extends Zone {
	private CoinGenerator coinGen;
	private ServantGenerator serGen;
	
	public Market(){
		coinGen = new CoinGenerator();
		serGen = new ServantGenerator();
	}

	public CoinGenerator getCoinGen() {
		return coinGen;
	}

	public ServantGenerator getSerGen() {
		return serGen;
	}
	

}
