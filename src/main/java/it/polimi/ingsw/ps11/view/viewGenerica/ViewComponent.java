package it.polimi.ingsw.ps11.view.viewGenerica;

public abstract class ViewComponent implements ViewComponentInterface {
	
	protected EventHandler<ViewEventInterface> eventHandler = new EventHandler<>();
	
	public void attach(EventListener<ViewEventInterface> listener){
		this.eventHandler.attach(listener);
	}

}
