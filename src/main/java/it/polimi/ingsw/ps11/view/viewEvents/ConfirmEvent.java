package it.polimi.ingsw.ps11.view.viewEvents;

public class ConfirmEvent extends ViewEvent{

	
	private boolean confirm = false;
	private int servant = 0;
	
	
	public ConfirmEvent() {
		
	}
	
	public int getServant() {
		return servant;
	}
	public void setServant(int servant) {
		this.servant = servant;
	}
	
	public boolean getConfirm(){
		return confirm;
	}
	
	
	@Override
	public void accept(ViewListener listener) {
		listener.handle(this);
	}

}
