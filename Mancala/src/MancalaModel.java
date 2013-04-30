public class MancalaModel
{
	public static final int NUM_PITS = 6;
	public static final int NUM_MANCALAS = 2;
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
		
		public Pit getNext()
		{
			return next;
		}
		
		public boolean isMancala()
		{
			return mancala;
		}
	}
	
	public MancalaModel()
	{
		board = new Pit[NUM_PITS + NUM_MANCALAS];
		potentialMove = new Pit[NUM_PITS];
		turnUndosLeft = MAX_UNDOS;
		
		//Initialize board
		for(int i = 0; i < board.length; i++)
			board[i] = new Pit(0,false,0); //how many pieces should we start with?
			
	}
	
	//handle zero pieces in pit error on interface side.
	//handle whether the player owns the pit at the index on the interface side.
	public void move(int index)
	{
		potentialMove = board;
		
		for(int i = 1; i < potentialMove[index] + 1; i++)
		{
		}
	}
}