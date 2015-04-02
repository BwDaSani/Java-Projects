package eecs285.proj2.leeyutsu;
public class ChessBoard 
{

	ChessPiece board[][];
	int occupy[][];
	
	ChessBoard()
	{
		board=new ChessPiece[8][8];
		occupy=new int[8][8];
		for (int i=0;i<8;i++)
		{
			for (int k=0;k<8;k++)
			{
				board[i][k]=new Empty();
			}
		}
	}
	
	void initialize()
	{
		board[0][0] = new Rook(0,0,'w');
		board[0][7] = new Rook(0,7,'w');
		board[0][1] = new Knight(0,1,'w');
		board[0][6] = new Knight (0,6,'w');
		board[0][2] = new Bishop(0,2,'w');
		board[0][5] = new Bishop(0,5,'w');
		board[0][3] = new Queen(0,3,'w');
		board[0][4] = new King(0,4,'w');
	    for (int i=0;i<8;i++)
	    {
	    	board[1][i]= new Pawn (1,i,'w');
	    }
		board[7][0] = new Rook(7,0,'b');
		board[7][7] = new Rook(7,7,'b');
		board[7][1] = new Knight(7,1,'b');
		board[7][6] = new Knight (7,6,'b');
		board[7][2] = new Bishop(7,2,'b');
		board[7][5] = new Bishop(7,5,'b');
		board[7][3] = new Queen(7,3,'b');
		board[7][4] = new King(7,4,'b');
	    for (int i=0;i<8;i++)
	    {
	    	board[6][i]= new Pawn (6,i,'b');
	    }
	}
	
	ChessPiece getPieceAt(final int row,final int col)
	{
	if (row<0 || row>7||col<0||col>7)	
	{
		System.out.println("Error: getPieceAt - Invalid space RC: "+row+" "+col);
		return null;
	}
	else if (board[row][col].get()!=0)
	{
		return board[row][col];
	}
	else
	{
		return null;
	}
	
	
	}
	
	
	void print()
	{
		String space="  |--|--|--|--|--|--|--|--|";
		for (int i=7,j=0;i>=0;i--,j++)
		{
			System.out.println(space);
			System.out.print((i+1)+" |");
			for (int m=0;m<8;m++)
			{
				System.out.print(board[i][m].pout()+"|");
			}
			System.out.print("\n");
		}
		System.out.println(space);
		System.out.println("   a  b  c  d  e  f  g  h");	
	}
	
	public void removePiece(final int rowNum,final int colNum)
	{
		if (rowNum<0 || rowNum>7||colNum<0||colNum>7)	
		{
			System.out.println("Error: removePiece - Invalid space RC: "+rowNum+" "+colNum);
		}
		else 
		{
			board[rowNum][colNum]=new Empty();
		}
	}
	
	public void placePiece(final ChessPiece pieceToPlace,final int rowNum,final int colNum)
	{
		if (rowNum<0 || rowNum>7||colNum<0||colNum>7)	
		{
			System.out.println("Error: placePiece - Invalid space RC: "+rowNum+" "+colNum);
		}
		else 
		{
			board[rowNum][colNum]=pieceToPlace;
			board[rowNum][colNum].move(rowNum, colNum);
		}
	}
		
}
