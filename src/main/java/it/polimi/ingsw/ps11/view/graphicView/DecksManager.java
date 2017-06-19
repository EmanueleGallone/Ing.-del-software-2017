package it.polimi.ingsw.ps11.view.graphicView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EtchedBorder;

public class DecksManager extends JPanel {
	
	private static final long serialVersionUID = 5113618310963734742L;

	private String[] types;
	
	private JLayeredPane deckSelector;														//pannello selezione deck
	private JPanel[] decks;																	//lista dei deck
	private JToggleButton[] selectors;


	public DecksManager(String[] types, Color[] colors) {
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
		decks = new JPanel[types.length];													//lista dei deck
		selectors = new JToggleButton[types.length];
		this.types = types;
        
        JPanel controls = new JPanel();														//crea il selettore dei deck
        controls.setPreferredSize(new Dimension(300, 80));
        controls.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        ButtonGroup buttonGroup = new ButtonGroup();
        
        for (int i = 0; i < types.length; i++) {
        	
           JToggleButton button = new JToggleButton(types[i]);
           button.setPreferredSize(new Dimension(100, 163));
           
           try {
        	    Image img = ImageIO.read(getClass().getResource("carte/Dorso "+ types[i] +".png"));
        	    Image icon = img.getScaledInstance( 110, 163,  java.awt.Image.SCALE_SMOOTH ) ;  
        	    button.setIcon(new ImageIcon(icon));
        	  } catch (Exception ex) {
        	    System.out.println(ex);
        	  }
           button.addItemListener(changeDeck);
           buttonGroup.add(button);
           selectors[i] = button;
           controls.add(button);
           
        }
        
        deckSelector = new JLayeredPane();													//crea i deck sovrapposti
        deckSelector.setPreferredSize(new Dimension(300, 310));
        deckSelector.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        
        Point origin = new Point(30, 0);
        int offset = 40;
       
        for (int i = 0; i < types.length; i++) {
            Deck deck = new Deck(types[i], colors[i], origin);
            deckSelector.add(deck, i);
            decks[i] = deck;
            origin.y += offset;
        }
        
        add(controls);
        add(deckSelector);

    }

    ItemListener changeDeck = new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			
			int j = 0;
			boolean found = false;
			for(int i=0; i<types.length; i++){	
				if(selectors[i].isSelected()){
					deckSelector.setLayer(decks[i], 3);
					found = true;
					j=2;
				} else 
				if(!selectors[i].isSelected()){
					deckSelector.setLayer(decks[i], j);
					if(found) j--;
					else j++;
				};
				}
			}
		};

	}

