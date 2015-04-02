package eecs285.proj2.leeyutsu;
public abstract class ChessPiece {
	
	char color;
	int rol,col;
	
	public ChessPiece(final int inRol,final int inCol,final char inColor)//contr stored color, current position
	{
	rol=inRol;
	col=inCol;
	color=inColor;
	}
	public abstract int getNumberOfMoves(final ChessBoard board, final boolean printMoves);
	
	public String pout() //return stuff for print
	{
		return "  ";
	}
	
	public int get()//check if its empty
	{
		return 0;
	}
	
	public void move(final int inrol,final int incol)//called to renew location
	{
		rol=inrol;
		col=incol;
	}
	
	public char getColor()//return color
	{
		return color;
	}
	
	
}
