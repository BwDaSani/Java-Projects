package eecs285.proj2.leeyutsu;
public class Pawn extends ChessPiece{
	
	int moved;
	
	public Pawn(final int inRol,final int inCol,final char inColor)
	{
		super(inRol,inCol,inColor);
		moved=0;
	}
	
	
	public String pout()
	{
		return color+"P";
	}
	
	public int get()
	{
		return 1;
	}
	
	public void move(final int inrol,final int incol)
	{
		rol=inrol;
		col=incol;
		moved=1;
	}
	
	public int getNumberOfMoves (final ChessBoard board, final boolean printMoves)
	{
		
		
		int count=0;
		if (printMoves)
		{
			System.out.println(board.getPieceAt(rol, col).pout()+ " at "+Global.K.charAt(col)+(rol+1)+" valid moves:");
		}
		
		if ((rol+1)>=8||(rol-1)<0)
		{
			System.out.println("Total Possible Moves: 0");
			return 0;
		}

			
		if (board.getPieceAt(rol, col).pout().charAt(0)=='w') //if is white
		{
				if (board.getPieceAt(rol+1, col)==null) //check for empty 
				{
					if (printMoves)
					{
						System.out.println("   Vacant: "+Global.K.charAt(col)+(rol+2));
					}
					count++;
				}
				if(moved==0&&board.getPieceAt(rol+1, col)==null && board.getPieceAt(rol+2, col)==null)
				{
					if (printMoves)
					{
						System.out.println("   Vacant: "+Global.K.charAt(col)+(rol+3));
					}
					count++;
				}
				if(col>=1)
				{
					if (board.getPieceAt(rol+1, col-1)!=null)
					{
						if (board.getPieceAt(rol+1, col-1).pout().charAt(0)=='b')
						{
							if(printMoves)
							{
								System.out.println("  Take "+board.getPieceAt(rol+1, col-1).pout()+": "+Global.K.charAt(col-1)+(rol+1));
								count++;
							}
						}
					}
				}
				if(col<=6)
				{
					if (board.getPieceAt(rol+1, col+1)!=null)
					{
						if (board.getPieceAt(rol+1, col+1).pout().charAt(0)=='b')
						{
							if(printMoves)
							{
								System.out.println("  Take "+board.getPieceAt(rol+1, col+1).pout()+": "+Global.K.charAt(col+1)+(rol+1));
								count++;
							}
						}
					}
				}
	    }
		else
		{
			if (board.getPieceAt(rol-1, col)==null) //check for empty 
			{
				if (printMoves)
				{
					System.out.println("   Vacant: "+Global.K.charAt(col)+(rol));
				}
				count++;
			}
			if(moved==0&&board.getPieceAt(rol-1, col)==null && board.getPieceAt(rol-2, col)==null)
			{
				if (printMoves)
				{
					System.out.println("   Vacant: "+Global.K.charAt(col)+(rol-1));
				}
				count++;
			}
			if(col>=1)
			{
				if (board.getPieceAt(rol-1, col-1)!=null)
				{
					if (board.getPieceAt(rol-1, col-1).pout().charAt(0)=='w')
					{
						if(printMoves)
						{
							System.out.println("  Take "+board.getPieceAt(rol-1, col-1).pout()+": "+Global.K.charAt(col-1)+(rol));
							count++;
						}
					}
				}
			}
			if(col<=6)
			{
				if (board.getPieceAt(rol-1, col+1)!=null)
				{
					if (board.getPieceAt(rol-1, col+1).pout().charAt(0)=='w')
					{
						if(printMoves)
						{
							System.out.println("  Take "+board.getPieceAt(rol-1, col+1).pout()+": "+Global.K.charAt(col+1)+(rol-1));
							count++;
						}
					}
				}
			}
					
		}
		
		if (printMoves)
		{
			System.out.println("  Total Possible Moves: "+count);
		}
		
		
		
		
		return count;
	}

}
