package fvr;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu1 extends JDialog
{
 ImageIcon picture;
 JLabel pictureLabel;
 JPanel picturePanel;
 JPanel glassbuttonPanel;
 JButton startGame;
 //boolean returnStart = false;
 
 public Menu1(JFrame mainframe, String frameTitle)
 {
  super(mainframe, frameTitle, true);
  setLayout(new BorderLayout());
  
  picture = new ImageIcon(this.getClass().getClassLoader().getResource("fvr/images/Menu1Background.jpg"));
  pictureLabel = new JLabel(picture);
  picturePanel = new JPanel();
  picturePanel.add(pictureLabel);
  add(picturePanel);
  
  startGame = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("fvr/images/PlayButton.gif")));
  startGame.setOpaque(false);
  startGame.setContentAreaFilled(false);
  startGame.setBorderPainted(false);

  startGame.addActionListener(new ActionListener()
                                  {
                                   public void actionPerformed(ActionEvent e)
                                   {
                                    //returnStart = true;
                                    setVisible(false);
                                   }
                                  });
   
  glassbuttonPanel = new JPanel();
  glassbuttonPanel.setLayout(new GridLayout(5,3));
  
  glassbuttonPanel.add(new JLabel(""));
  glassbuttonPanel.add(new JLabel(""));
  glassbuttonPanel.add(new JLabel(""));
  
  glassbuttonPanel.add(new JLabel(""));
  glassbuttonPanel.add(new JLabel(""));
  glassbuttonPanel.add(new JLabel(""));
  
  glassbuttonPanel.add(new JLabel(""));
  glassbuttonPanel.add(new JLabel(""));
  glassbuttonPanel.add(new JLabel(""));
  
  glassbuttonPanel.add(new JLabel(""));
  glassbuttonPanel.add(new JLabel(""));
  glassbuttonPanel.add(new JLabel(""));
  
  glassbuttonPanel.add(new JLabel(""));
  glassbuttonPanel.add(startGame);
  glassbuttonPanel.add(new JLabel(""));
  
  setGlassPane(glassbuttonPanel);
  glassbuttonPanel.setOpaque(false);
  glassbuttonPanel.setVisible(true);
  
  pack();
  setResizable(false);
 }
}
