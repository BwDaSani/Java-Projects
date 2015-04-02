package eecs285.proj3.leeyutsu;
import java.awt.*;

import javax.swing.JDialog; 

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;

import javax.swing.*;
public class CustomeDialog extends JDialog{
JButton okButton;
 JTextField TextField;
 //dialog for all of the dialogs
	public String getName()
	{
		return(TextField.getText());
	}
 public CustomeDialog(JFrame frame,String title, String Message)
 {
	 super(frame,title,true);
	 setLayout(new FlowLayout());
	 add(new JLabel(Message));
	 TextField=new JTextField(30);
	 JScrollPane scroll=new JScrollPane(TextField);
	 add(scroll);
	 okButton=new JButton(" Submit ");
	    okButton.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		setVisible(false);
	    	}
	    }
	    
	    );
	 add(okButton);
	 pack();
	 setVisible(true);	 
 }
 
}
