package it.polimi.ingsw.ps11.model.gameLogics.newTry;

import java.util.Optional;

import it.polimi.ingsw.ps11.model.player.Player;

public class AzioneGenerica implements Action<AzioneGenerica> {

	protected AzioneGenerica action;
	private Player player;
	
	@Override
	public boolean isLegal(ActionManager actionManager) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void perform(ActionManager actionManager) {
		if(take(this)){
			
		}
		
	}


	@Override
	public Class<AzioneGenerica> target() {
		return AzioneGenerica.class;
	}
	
	public boolean take(AzioneGenerica kAction) {
		ActionManager actionManager = null;//player.actions();
		AzioneGenerica azione = actionManager.get(kAction.target());
		if (azione != null){
			azione = azione.decore(kAction);
			azione.perform(player.actions());
			return false;
		}
		return true;
	}
	
	@Override
	public AzioneGenerica take(Class<AzioneGenerica> kClass) {
		ActionManager actionManager = null;
		Optional<AzioneGenerica> azione = actionManager.get(kClass);
		if(azione.isPresent()){
			AzioneGenerica action = azione.get().decore(this);
			action.perform(actionManager);
			return null;
		}
		return action;
	}

	@Override
	public AzioneGenerica decore(AzioneGenerica action) {
		// TODO Auto-generated method stub
		return null;
	}


}
