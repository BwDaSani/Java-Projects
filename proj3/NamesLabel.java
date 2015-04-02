package eecs285.proj3.leeyutsu;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class NamesLabel extends JPanel{
	JLabel[] BalanceArray;
	//init name lavle and format displays
 public NamesLabel(String[] Names,int size,Integer[] Balance)
 {	 
	 BalanceArray=new JLabel[size];
	 for(int i=0;i<size;i++)
	 {
		 BalanceArray[i]=new JLabel(Integer.toString(Balance[i]));
	 }
	 TitledBorder object;
		setLayout(new GridLayout(1,size));
		for (int i=0;i<size;i++)
		{
		JPanel temp=new JPanel();
		temp.add(BalanceArray[i]);
		object= BorderFactory.createTitledBorder(Names[i]);
		object.setTitleJustification(TitledBorder.LEFT);
		temp.setBorder(object);
		add(temp);
		}				
 }
 
 public void setNewBalance(int index,Integer[] Balance)
 {
	 BalanceArray[index].setText(Integer.toString(Balance[index]));
 }
 
 
}
