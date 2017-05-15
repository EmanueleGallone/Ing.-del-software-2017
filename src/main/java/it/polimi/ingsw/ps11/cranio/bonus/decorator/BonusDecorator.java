package it.polimi.ingsw.ps11.cranio.bonus.decorator;

public abstract class BonusDecorator implements Bonus {

	protected Bonus bonus;
	
	public BonusDecorator(Bonus bonus) {
		this.bonus = bonus;
	}

}
