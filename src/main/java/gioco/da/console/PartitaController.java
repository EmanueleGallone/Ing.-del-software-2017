package gioco.da.console;

public class PartitaController {
	private Partita model;
	private PartitaView view;
	
	public PartitaController(Partita partita, PartitaView view){
		this.model = partita;
		this.view = view;
	}
	
	public void updateView(){
		view.printStatus(model);
	}
	
	public void gioca(){
		model.Turno();
		model.menuChoice();
		updateView();
	}

}
