public class MancalaModel
{
	public static final int NUM_PITS = 6;
	public static final int NUM_PLAYERS = 2;
	public static final int NUM_MANCALAS = 2;
	public static final int TOTAL_INDECIES = (NUM_PITS * NUM_PLAYERS) + NUM_MANCALAS;
	public static final int MAX_UNDOS = 3;
	
	private Pit[] board;
	private Pit[] potentialMove;
	private int turnUndosLeft;
	
	//Node class for circular list structure
	public class Pit
	{
		private Pit next;
		private int pieces;
		private int player;
		private int index;
		private boolean mancala;
		
		public Pit(int pieces, boolean mancala, int index, int player)
		{
			this.mancala = mancala;
			this.pieces = pieces;
			this.player = player;
			this.index = index;
		}
		
		public int getPieces()
		{
			return pieces;
		}
		
		public int getPlayer()
		{
			return player;
		}
		
		public int getIndex()
		{
			return index;
		}
		
		public void setNext(Pit next)
		{
			this.next = next;
		}
		
		public void addPieces(int pieces)
		{
			this.pieces += pieces;
		}
		
		public void setPieces(int pieces)
		{
			this.pieces = pieces;
		}
		
		public Pit getNext()
		{
			return next;
		}
		
		public boolean isMancala()
		{
			return mancala;
		}
	}
	
	public MancalaModel(int startingNumPieces)
	{
		System.out.println(TOTAL_INDECIES);
		board = new Pit[TOTAL_INDECIES];
		potentialMove = new Pit[NUM_PITS];
		turnUndosLeft = MAX_UNDOS;
		
		//Initialize board
		
		//Player1
		for(int i = 0; i < TOTAL_INDECIES/2; i++)
			board[i] = new Pit(startingNumPieces,false,i,0);
		//Player2
		for(int i = TOTAL_INDECIES/2; i < TOTAL_INDECIES; i++)
			board[i] = new Pit(startingNumPieces,false,i,1);
		
		//The mancalas
		board[6] = new Pit(0,true,6,0);
		board[13] = new Pit(0,true,13,1);		
		
		//link the pits together.
		for(int i = 0; i < TOTAL_INDECIES; i++)
		{
			//When the last pit is reached, link it to the first pit.
			if(i + 1 == TOTAL_INDECIES)
				board[i].setNext(board[0]);
			else
				board[i].setNext(board[i + 1]);
		}
	
			
	}
	
	//handle zero pieces in pit error on interface side.
	//returns true if free turn.
	public boolean move(int startIndex, int player)
	{
		potentialMove = board;
		int playerMancala;
		
		if(player == 0) playerMancala = 6;
		else playerMancala = 13;
		
		//Reference to current pit. Used for cycling through the circular list.
		Pit currentPit = potentialMove[startIndex]; 
		for(int i = 1; i < potentialMove[startIndex].getPieces() + 1; i++)
		{
			currentPit = currentPit.getNext(); 
			currentPit.addPieces(1);
		}
		
		//If your last stone lands in your mancala, free turn
		if(currentPit.isMancala() && currentPit.getPlayer() == player)
			return true;
		
		//If your last stone lands in an empty pit on your side, take all stones from the pit opposite of it
		//and put it in your mancala
		else if(currentPit.getPieces() == 0 && currentPit.getPlayer() == player)
		{
			int oppositeIndex = (13 - currentPit.getIndex() - 1);
			potentialMove[playerMancala].addPieces(potentialMove[oppositeIndex].getPieces());
			potentialMove[oppositeIndex].setPieces(0);
			return false;
		}
		//If your last stone lands in an opponent's pit, your turn ends.
		potentialMove[startIndex].setPieces(0);
		return false;
		
	}
	
	//Returns true if undos are available and false if they aren't
	public boolean undo()
	{
		if(turnUndosLeft > 0)
		{
			potentialMove = board;
			turnUndosLeft--;
			return true;
		}
		else
			return false;
	}
	
	public int getPiecesInPit(int index)
	{
		return board[index].getPieces();
	}
	
	//Set the board to the potential move to end the turn.
	public void endTurn()
	{
		board = potentialMove;
	}
}