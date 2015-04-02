package eecs285.proj2.leeyutsu;
public class King extends ChessPiece{
	
	public King(final int inRol,final int inCol,final char inColor)
	{
		super(inRol,inCol,inColor);
	}
	public String pout()//rerutn stuff to print
	{
		return color+"K";
	}
	
	public int get()//used to check if its empty
	{
		return 1;
	}
	
	private int Counting(final ChessBoard board,final int inRow,final int inCol,final boolean printMoves) //Counting Function that will count the moves of certain direction
	{
		int count=0;
		if (board.getPieceAt(inRow, inCol)==null)
		{
			if (printMoves)
			{
				System.out.println("   Vacant: "+Global.K.charAt(inCol)+(inRow+1));
			}
			count++;
		}
		else
		{
			if (board.getPieceAt(inRow, inCol).pout().charAt(0)!=board.getPieceAt(rol, col).pout().charAt(0))
			{
				if(printMoves)
				{
					System.out.println("  Take "+board.getPieceAt(inRow, inCol).pout()+": "+Global.K.charAt(inCol)+(inRow+1));
				}
				count++;
			}
		}
		return count;
	}
	
	public int getNumberOfMoves (final ChessBoard board, final boolean printMoves)
	{
		int count=0;
		if (printMoves)
		{
			System.out.println(board.getPieceAt(rol, col).pout()+ " at "+Global.K.charAt(col)+(rol+1)+" valid moves:");
		}
		if (col+1<8)
		{
		count=count+Counting(board,rol,col+1,printMoves);
			if (rol+1<8)
			{
			count=count+Counting(board,rol+1,col+1,printMoves);
			}
			if (rol-1>=0)
			{
			count=count+Counting(board,rol-1,col+1,printMoves);
			}
		}
		if (rol+1<8)
		{
		count=count+Counting(board,rol+1,col,printMoves);	
		}
		if (rol-1>=0)
		{
		count=count+Counting(board,rol-1,col,printMoves);
		}
		if (col-1>=0)
		{
		count=count+Counting(board,rol,col-1,printMoves);
			if (rol+1<8)
			{
			count=count+Counting(board,rol+1,col-1,printMoves);
			}
			if (rol-1>=0)
			{
				count=count+Counting(board,rol-1,col-1,printMoves);
			}
		}
		
		
		if (printMoves)
		{
			System.out.println("  Total Possible Moves: "+count);
		}
		
		
		return count;
	}

}
