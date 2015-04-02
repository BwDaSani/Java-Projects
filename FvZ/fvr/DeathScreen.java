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

public class DeathScreen extends JDialog
{
 ImageIcon picture;
 JLabel pictureLabel;
 JPanel picturePanel;
 JPanel glassbuttonPanel;
 JButton menu;
 boolean quit = false;
 public DeathScreen(JFrame mainframe, String frameTitle)
 {
  super(mainframe, frameTitle, true);
  setLayout(new BorderLayout());
  
  picture = new ImageIcon(this.getClass().getClassLoader().getResource("fvr/images/DeathScreen.jpg"));
  pictureLabel = new JLabel(picture);
  picturePanel = new JPanel();
  picturePanel.add(pictureLabel);
  add(picturePanel);
  
  menu = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("fvr/images/Menu.gif")));
  menu.setOpaque(false);
  menu.setContentAreaFilled(false);
  menu.setBorderPainted(false);

  menu.addActionListener(new ActionListener()
                                  {
                                   public void actionPerformed(ActionEvent e)
                                   {
                                    quit = true;
                                    setVisible(false);
                                   }
                                  });
  
  glassbuttonPanel = new JPanel();
  glassbuttonPanel.setLayout(new GridLayout(1,6));
  
  glassbuttonPanel.add(new JLabel(""));
  glassbuttonPanel.add(new JLabel(""));
  
  glassbuttonPanel.add(new JLabel(""));
  glassbuttonPanel.add(new JLabel(""));
  glassbuttonPanel.add(new JLabel(""));
  glassbuttonPanel.add(menu);
  
  setGlassPane(glassbuttonPanel);
  glassbuttonPanel.setOpaque(false);
  glassbuttonPanel.setVisible(true);
  pack();
  setResizable(false);
 }
}

