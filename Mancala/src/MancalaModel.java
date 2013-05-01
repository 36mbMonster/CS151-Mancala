public class MancalaModel
{
	public static final int NUM_PITS = 6;
	public static final int NUM_PLAYERS = 2;
	public static final int NUM_MANCALAS = 2;
	public static final int TOTAL_INDECIES = (NUM_PITS * NUM_PLAYERS) + NUM_MANCALAS;
	public static final int MAX_STONES_PER_PIT = 4;
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
		private boolean mancala;
		
		public Pit(int pieces, boolean mancala, int player)
		{
			this.mancala = mancala;
			this.pieces = pieces;
			this.player = player;
		}
		
		public int getPieces()
		{
			return pieces;
		}
		
		public int getPlayer()
		{
			return player;
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
		board = new Pit[TOTAL_INDECIES];
		potentialMove = new Pit[NUM_PITS];
		turnUndosLeft = MAX_UNDOS;
		
		//Initialize board
		
		//Player1
		for(int i = 0; i < TOTAL_INDECIES/2; i++)
			board[i] = new Pit(startingNumPieces,false,0);
		for(int i = 0; i < TOTAL_INDECIES/2; i++)
			board[i] = new Pit(startingNumPieces,false,0);
		//Player2
		for(int i = TOTAL_INDECIES/2; i < TOTAL_INDECIES; i++)
			board[i] = new Pit(startingNumPieces,false,1);
		
		//The mancalas
		board[6] = new Pit(startingNumPieces,true,0);
		board[13] = new Pit(startingNumPieces,true,1);
			
	}
	
	//handle zero pieces in pit error on interface side.
	//returns true if free turn.
	public boolean move(int startIndex, int player)
	{
		potentialMove = board;
		int playerMancala;
		
		if(player == 0) playerMancala = 6;
		else playerMancala = 13;
		
		int currentIndex = startIndex;
		for(int i = 1; i < potentialMove[startIndex].getPieces() + 1; i++)
		{
			currentIndex = startIndex + i; 
			potentialMove[currentIndex].addPieces(1);
		}
		
		//If your last stone lands in your mancala, free turn
		if(potentialMove[currentIndex].isMancala() && potentialMove[currentIndex].getPlayer() == player)
			return true;
		
		//If your last stone lands in an empty pit on your side, take all stones from the pit opposite of it
		//and put it in your mancala
		else if(potentialMove[currentIndex].getPieces() == 0 && potentialMove[currentIndex].getPlayer() == player)
		{
			int oppositeIndex = (13 - currentIndex - 1);
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
	
	//Set the board to the potential move to end the turn.
	public void endTurn()
	{
		board = potentialMove;
	}
}