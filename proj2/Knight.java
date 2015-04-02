package eecs285.proj2.leeyutsu;
public class Knight extends ChessPiece{
	
	public Knight(final int inRol,final int inCol,final char inColor)
	{
		super(inRol,inCol,inColor);
	}
	
	public int get()//check if its empty
	{
		return 1;
	}
	
	public String pout()//return stuff to print
	{
		return color+"N";
	}
	
	private int Counting(final ChessBoard board,final int inRow,final int inCol,final boolean printMoves)//counting used to check knight's movement of all direction
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
		if(rol+2<8)
		{
			if(col+1<8)
			{
				count=count+Counting(board,rol+2,col+1,printMoves);
			}
			if(col-1>=0)
			{
				count=count+Counting(board,rol+2,col-1,printMoves);
			}
			
		}
		if (rol-2>=0)
		{
			if(col+1<8)
			{
			count=count+Counting(board,rol-2,col+1,printMoves);
			}
			if(col-1>=0)
			{
			count=count+Counting(board,rol-2,col-1,printMoves);
			}
		}
		
		if(col+2<8)
		{
			if(rol+1<8)
			{
			count=count+Counting(board,rol+1,col+2,printMoves);
			}
			if(rol-1>=0)
			{
			count=count+Counting(board,rol-1,col+2,printMoves);
			}
		}
		if(col-2>=0)
		{
			if(rol+1<8)
			{
			count=count+Counting(board,rol+1,col-2,printMoves);
			}
			if(rol-1>=0)
			{
			count=count+Counting(board,rol-1,col-2,printMoves);
			}
		}
		if (printMoves)
		{
			System.out.println("  Total Possible Moves: "+count);
		}

		return count;
	}

}
