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

public class Menu2 extends JDialog
{
 ImageIcon picture;
 JLabel pictureLabel;
 JPanel picturePanel;
 JPanel glassbuttonPanel;
 JButton L1;
 JButton L2;
 JButton L3;
 JButton L4;
 JButton L5;
 JButton LU;
 int returnLevel = 0;
 boolean returnStart = false;
 
 public Menu2(JFrame mainframe, String frameTitle)
 {
  super(mainframe, frameTitle, true);
  setLayout(new BorderLayout());
  
  picture = new ImageIcon(this.getClass().getClassLoader().getResource("fvr/images/Menu2.jpg"));
  pictureLabel = new JLabel(picture);
  picturePanel = new JPanel();
  picturePanel.add(pictureLabel);
  add(picturePanel);
  
  L1 = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("fvr/images/Level1.gif")));
  L1.setOpaque(false);
  L1.setContentAreaFilled(false);
  L1.setBorderPainted(false);
  
  L2 = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("fvr/images/Level2.gif")));
  L2.setOpaque(false);
  L2.setContentAreaFilled(false);
  L2.setBorderPainted(false);
  
  L3 = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("fvr/images/Level3.gif")));
  L3.setOpaque(false);
  L3.setContentAreaFilled(false);
  L3.setBorderPainted(false);
  
  L4 = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("fvr/images/Level4.gif")));
  L4.setOpaque(false);
  L4.setContentAreaFilled(false);
  L4.setBorderPainted(false);
  
  L5 = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("fvr/images/Level5.gif")));
  L5.setOpaque(false);
  L5.setContentAreaFilled(false);
  L5.setBorderPainted(false);
  
  LU = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("fvr/images/Unlimited.gif")));
  LU.setOpaque(false);
  LU.setContentAreaFilled(false);
  LU.setBorderPainted(false);

  L1.addActionListener(new ActionListener()
                                  {
                                   public void actionPerformed(ActionEvent e)
                                   {
                                    returnLevel = 1;
                                    returnStart = true;
                                    setVisible(false);
                                   }
                                  });
  
  L2.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    returnLevel = 2;
    returnStart = true;
    setVisible(false);
   }
  });
  
  L3.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    returnLevel = 3;
    returnStart = true;
    setVisible(false);
   }
  });
  
  L4.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    returnLevel = 4;
    returnStart = true;
    setVisible(false);
   }
  });
  
  L5.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    returnLevel = 5;
    returnStart = true;
    setVisible(false);
   }
  });
  
  LU.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent e)
   {
    returnLevel = 0;
    returnStart = true;
    setVisible(false);
   }
  });
   
  glassbuttonPanel = new JPanel();
  glassbuttonPanel.setLayout(new GridLayout(6,1));
  glassbuttonPanel.add(LU);
  glassbuttonPanel.add(L1);
  glassbuttonPanel.add(L2);
  glassbuttonPanel.add(L3);
  glassbuttonPanel.add(L4);
  glassbuttonPanel.add(L5);
 
  setGlassPane(glassbuttonPanel);
  glassbuttonPanel.setOpaque(false);
  glassbuttonPanel.setVisible(true);
  
  pack();
  setResizable(false);
 }
}
