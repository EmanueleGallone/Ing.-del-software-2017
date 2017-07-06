package it.polimi.ingsw.ps11.view.viewEvents;

public class ConfirmViewEvent extends ViewEvent{

	
	private boolean confirm = false;
	private int servant = 0;
	
	
	public ConfirmViewEvent(boolean confirmed) {
		this.confirm = confirmed;
	}
	
	public ConfirmViewEvent(boolean confirmed, int servant) {
		this.confirm = confirmed;
		this.servant = servant;
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
