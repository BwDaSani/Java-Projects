package eecs285.proj3.leeyutsu;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
//init three bottom
public class ThreeBottoms extends JPanel {
	public ThreeBottoms(WheelOfFortune Game)
	{
		Game.BuyVow=new JButton("Buy A Vowel");
		Game.SpinBotton=new JButton("Spin The Wheel");
		Game.Answer=new JButton("SolveThe Puzzel");
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(Game.BuyVow);
		add(Game.SpinBotton);
		add(Game.Answer);
	}

	public void DisableVow(WheelOfFortune Game)
	{
	 if (Game.Balance[Game.index]>=250)
	 {
	 Game.BuyVow.setEnabled(true); 
	 }
	 else
	 {
	 Game.BuyVow.setEnabled(false);
	 }
	}
	

}