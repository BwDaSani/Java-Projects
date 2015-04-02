package eecs285.proj3.leeyutsu;
import javax.swing.JFrame;

//driver to drive the program;
public class Driver {
public static void main(String[] args)
{
	WheelOfFortune Game;
	
	Game=new WheelOfFortune();
	Game.setVisible(true);
	Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
