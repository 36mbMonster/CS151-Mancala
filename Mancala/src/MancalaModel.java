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
		
		public void setNext(Pit next)
		{
			this.next = next;
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
	//handle whether the player owns the pit at the index on the interface side.
	public void move(int startIndex)
	{
		potentialMove = board;
		
		int currentIndex;
		for(int i = 1; i < potentialMove[startIndex].getPieces() + 1; i++)
		{
			currentIndex = startIndex + i; 
			potentialMove[currentIndex].setPieces(potentialMove[currentIndex].getPieces() + 1);
		}
		
		//Todo: If currentIndex is the player and is empty, If currentIndex is the opponent
		//If the currentIndex is the player and is not empty, If the currentIndex is a mancala.
		
		potentialMove[startIndex].setPieces(0);
	}
}