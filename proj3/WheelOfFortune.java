package eecs285.proj3.leeyutsu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WheelOfFortune extends JFrame{
	JButton SpinBotton;
	JButton Answer;
	JButton BuyVow;
	JLabel theImage;
	JPanel PlayerStatus;
	int index;
	int Playerindex;
	int MoneyAmount;
	boolean consonantsActivate=false;
	boolean vowelsActivate=false;
	String[] PlayerList;
	Integer []Balance;
	WheelSpace imageMap;
	Random randomNumber=new Random();
		public WheelOfFortune()
		{
			super("Wheel Of Fortune");
			JPanel ImagePanel=new JPanel();
			index=0;
			imageMap=new WheelSpace();
			theImage=new JLabel(imageMap.getImage(index));
			BuyVow=new JButton("Buy A Vowel");
			SpinBotton=new JButton("Spin The Wheel");
			Answer=new JButton("SolveThe Puzzel");
			BuyVow.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Balance[Playerindex]-=250;
					vowelsActivate=true;
				}
			}
					
					
					);
			SpinBotton.addActionListener(new ActionListener()
			
			{
				public void actionPerformed(ActionEvent e)
				{
				index=randomNumber.nextInt(23);
				theImage.setIcon(imageMap.getImage(index));
				MoneyAmount=imageMap.getValue(index);
				consonantsActivate=true;
				}
			}
					);

			
			
			JPanel CenterLeft=new JPanel();
			CenterLeft.setLayout(new BoxLayout(CenterLeft,BoxLayout.Y_AXIS));
			CenterLeft.add(BuyVow);
			CenterLeft.add(SpinBotton);
			CenterLeft.add(Answer);

			JPanel south=new JPanel();
			JPanel southTop=new JPanel();
			JPanel southBot=new JPanel();
			JPanel center=new JPanel();
			JPanel vowels=new Vowels();
			JPanel consonants=new Consonants();
			south.setLayout(new BoxLayout(south,BoxLayout.Y_AXIS));
			southTop.setLayout(new FlowLayout());
			southBot.setLayout(new FlowLayout());
			southTop.add(vowels);
			southTop.add(consonants);
			south.add(southTop);
			center.setLayout(new FlowLayout());
			center.add(CenterLeft);
			setLayout(new BorderLayout());
			CustomeDialog nameDialog;
			CustomeDialog NumberDialog;
			CustomeDialog AnswerDialog;
			NumberDialog=new CustomeDialog(this,"Seed Input","Enter the random generator seed (int)");
			while(!isInteger(NumberDialog.getName()))
			{
			NumberDialog=new CustomeDialog(this,"Seed Input","Enter the random generator seed (int)");
			}
			int Seedgen=Integer.parseInt(NumberDialog.getName());
			System.out.println(Seedgen);
			randomNumber.setSeed(Seedgen);
			center.add(theImage);
			nameDialog=new CustomeDialog(this,"Player Name Input","Enter space separated list of players");
			String Names=nameDialog.getName();
			String delims="[ ]+";
			String[] tokens=Names.split(delims);
			int size=tokens.length;
			Balance=new Integer[size];
			 for(int i=0;i<size;i++)
			 {
				 Balance[i]=0;
			 }
			PlayerStatus=new NamesLabel(tokens,size,Balance);
			DisableVow(this);
			AnswerDialog=new CustomeDialog(this,"Puzzel Input","Ask a non-player to enter a puzzle");
			String Puzzle=AnswerDialog.getName();
			System.out.println(Puzzle);
			char[] HiddenPuzzle=Puzzle.toCharArray();
			String PrintPuzzle;
			for (int i=0;i<HiddenPuzzle.length;i++)
			{
				if (Character.isLetter(HiddenPuzzle[i]))
				{
					HiddenPuzzle[i]='_';
				}
			}
			PrintPuzzle=String.valueOf(HiddenPuzzle);
			southBot.add(new JLabel(PrintPuzzle));
			south.add(southBot);
			add(PlayerStatus,BorderLayout.NORTH);
			add(center,BorderLayout.CENTER);
			add(south,BorderLayout.SOUTH);
			pack();
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	
		
		public static boolean isInteger(String s) {
		    try { 
		        Integer.parseInt(s); 
		    } catch(NumberFormatException e) { 
		        return false; 
		    }
		    // only got here if we didn't return false
		    return true;
		}
		public static void DisableVow(WheelOfFortune Game)
		{
		 if (Game.Balance[Game.Playerindex]>=250)
		 {
		 Game.BuyVow.setEnabled(true); 
		 }
		 else
		 {
		 Game.BuyVow.setEnabled(false);
		 }
		}
		
		
}
