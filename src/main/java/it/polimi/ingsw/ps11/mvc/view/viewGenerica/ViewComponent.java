package it.polimi.ingsw.ps11.mvc.view.viewGenerica;

public abstract class ViewComponent implements ViewComponentInterface {

	protected String id;
	
	public ViewComponent(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
}
