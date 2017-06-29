package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.ChurchView;

public class GraphicChurchView extends ChurchView {
	
	protected GraphicPaintedPanel church = new GraphicPaintedPanel();
	
	//Church ancora da implementare
	
	@Override
	public void print(){
		church.loadImage("boardImages/Church.png");

		//church.loadImage("..\\..\\..\\..\\..\\..\\..\\..\\..\\..\\settings\\boardImages\\Church.png");
		//church.loadImage("C:\\Users\\Gabs3\\Desktop\\ProgettoIngSoft\\Ing.-del-software-2017\\src\\main\\java\\it\\polimi\\ingsw\\ps11\\view\\graphicView\\components\\boardImages\\Church.png");
		//church.loadImage("./../../../../../../../it/polimi/ingsw/ps11/view/graphicView/components/boardImages/Church.png");
	}

	public JPanel getComponent() {
		return church;
	}

}

