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
public class Vowels extends JPanel{
	public Vowels()
	{
		TitledBorder object;
		setLayout(new GridLayout(3,2));
		add(new JButton("A"));
		add(new JButton("E"));
		add(new JButton("I"));
		add(new JButton("O"));
		add(new JButton("U"));
		object= BorderFactory.createTitledBorder("Vowels");
		object.setTitleJustification(TitledBorder.LEFT);
		setBorder(object);
		
	}

}
