package it.polimi.ingsw.ps11.view.graphicView;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class TestIt2 extends JPanel {
   private static final Dimension BUTTON_SIZE = new Dimension(100, 700);
   private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
   JPanel holderPanel;

   public TestIt2() {
      holderPanel = new JPanel();
	  holderPanel.setLayout(new BoxLayout(holderPanel, BoxLayout.LINE_AXIS));
      holderPanel.add(Box.createGlue(), BorderLayout.CENTER);

      setLayout(new BorderLayout());
      add(new JScrollPane(holderPanel,
              JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
              JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
      JTextArea fields = new JTextArea();
      holderPanel.add(fields);
   }

   private static void createAndShowGui() {
      TestIt2 mainPanel = new TestIt2();

      JFrame frame = new JFrame("TestIt2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}