package pos.players;

public class Player {

	private static final String NOME_PREDEFINITO = "Unknown";
	
	String name;
	
	ResourceManager resourceManager;
	CartsManager cartsManager = new CartsManager();
	FamilyMembersManager familyMembersManager;
	
	public Player() {
		this(NOME_PREDEFINITO);
	}
	
	public Player(String name) {
		this.name = name;
		resourceManager = new ResourceManager(5, 2, 2, 3);
	}
	
	public ResourceManager getResourceManager() {
		return resourceManager;
	}
	
	public CartsManager getCartsManager() {
		return cartsManager;
	}
	
}
