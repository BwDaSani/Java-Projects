package eecs285.proj3.leeyutsu;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
public class Consonants extends JPanel{
 public Consonants()
 {
	 //used to established all the botooms and format displays
		TitledBorder object;
		setLayout(new GridLayout(3,7));
		add(new JButton("B"));
		add(new JButton("C"));
		add(new JButton("D"));
		add(new JButton("F"));
		add(new JButton("G"));
		add(new JButton("H"));
		add(new JButton("J"));
		add(new JButton("K"));
		add(new JButton("L"));
		add(new JButton("M"));
		add(new JButton("N"));
		add(new JButton("P"));
		add(new JButton("Q"));
		add(new JButton("R"));
		add(new JButton("S"));
		add(new JButton("T"));
		add(new JButton("V"));
		add(new JButton("W"));
		add(new JButton("X"));
		add(new JButton("Y"));
		add(new JButton("Z"));
		object= BorderFactory.createTitledBorder("Vowels");
		object.setTitleJustification(TitledBorder.LEFT);
		setBorder(object);
 }
}
