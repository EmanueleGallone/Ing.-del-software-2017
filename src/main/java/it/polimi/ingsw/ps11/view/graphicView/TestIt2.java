package it.polimi.ingsw.ps11.view.graphicView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class TestIt2 extends JPanel {
   private static final Dimension BUTTON_SIZE = new Dimension(200, 200);
   private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
   JPanel holderPanel;

   public TestIt2() {

	  holderPanel = new JPanel();
      holderPanel.setLayout(new FlowLayout());
      holderPanel.add(Box.createGlue(), BorderLayout.CENTER);

      setLayout(new BorderLayout());
      add(new JScrollPane(holderPanel,
              JScrollPane.VERTICAL_SCROLLBAR_NEVER,
              JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS), BorderLayout.CENTER);
      createButton();
   }

   public class addButton implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        createButton();     
    }
   }

   protected void createButton() {
      JButton button = new JButton("click me");
      button.addActionListener(new addButton());
      button.setPreferredSize(BUTTON_SIZE);
      holderPanel.add(button);
      revalidate();
      repaint();
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(200, 300);
   }

   private static void createAndShowGui() {
      TestIt2 mainPanel = new TestIt2();

      JFrame frame = new JFrame("TestIt2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
	  System.out.println(frame.getContentPane().getWidth() + ", " + frame.getContentPane().getHeight());
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
            
         }
      });
   }
}