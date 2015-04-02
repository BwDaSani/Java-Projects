package eecs285.proj2.leeyutsu;
public class Queen extends ChessPiece {

	public Queen(final int inRol,final int inCol,final char inColor)
	{
		super(inRol,inCol,inColor);
	}
	
	public int get()
	{
		return 1;
	}
	
	public String pout()
	{
		return color+"Q";
	}
	private int Counting (final ChessBoard board,final int RowUD,final int ColUD,final boolean printMoves) //Private function that will check all direction of moving
	{
		int i=1;
		int count=0;
		while (col+(ColUD*i)>=0 && col+(ColUD*i)<8 && rol+(RowUD*i)>=0 && rol+(RowUD*i)<8)
		{
			if (board.getPieceAt(rol+(RowUD*i), col+(ColUD*i))==null)
			{
				if (printMoves)
				{
					System.out.println("   Vacant: "+Global.K.charAt(col+(ColUD*i))+(rol+(RowUD*i)+1));
				}
				count++;
			}
			else
			{

				if (board.getPieceAt(rol+(RowUD*i), col+(ColUD*i)).pout().charAt(0)!=board.getPieceAt(rol, col).pout().charAt(0))
				{
					if(printMoves)
					{
						System.out.println("  Take "+board.getPieceAt(rol+(RowUD*i),col+(ColUD*i)).pout()+": "+Global.K.charAt(col+(ColUD*i))+(rol+(RowUD*i)+1));
						count++;
						break;
					}
				}
				else
				{
					break;
				}
			}
			i++;
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
		count=count+Counting(board,0,-1,printMoves);//checking all direction
		count=count+Counting(board,0,1,printMoves);
		count=count+Counting(board,1,0,printMoves);
		count=count+Counting(board,-1,0,printMoves);
		count=count+Counting(board,1,-1,printMoves);
		count=count+Counting(board,-1,-1,printMoves);
		count=count+Counting(board,1,1,printMoves);
		count=count+Counting(board,-1,1,printMoves);
		
		if (printMoves)
		{
			System.out.println("  Total Possible Moves: "+count);
		}
		return count;
	}
}
