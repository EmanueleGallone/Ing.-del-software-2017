package it.polimi.ingsw.ps11.view.graphicView.components;

import javax.swing.JPanel;

import it.polimi.ingsw.ps11.view.viewGenerica.components.ChurchView;
/**
 * <h3> GraphicChurchView</h3>
 * <p> Classe che mostra la Chiesa e le carte scomunica, i punti del tracciato fede sono stati inseriti nella ResourceList
 * di ogni giocatore</p>
 * @see ChurchView
 */
public class GraphicChurchView extends ChurchView {
	
	protected GraphicPaintedPanel church = new GraphicPaintedPanel();
	
	public GraphicChurchView() {
		church.loadImage("boardImages/Church.png");
	}
	
	@Override
	public void print(){
		//church.loadImage("resources\\Church.PNG");

		//church.loadImage("..\\..\\..\\..\\..\\..\\..\\..\\..\\..\\settings\\boardImages\\Church.png");
		//church.loadImage("C:\\Users\\Gabs3\\Desktop\\ProgettoIngSoft\\Ing.-del-software-2017\\src\\main\\java\\it\\polimi\\ingsw\\ps11\\view\\graphicView\\components\\boardImages\\Church.png");
		//church.loadImage("./../../../../../../../it/polimi/ingsw/ps11/view/graphicView/components/boardImages/Church.png");
	}

	public JPanel getComponent() {
		return church;
	}

}

