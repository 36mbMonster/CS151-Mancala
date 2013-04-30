public class MancalaModel
{
	public static final int NUM_PITS = 6;
	public static final int MAX_STONES_PER_PIT = 4;
	public static final int MAX_UNDOS = 3;
	
	private int[] playerA;
	private int[] playerB;
	private int[] potentialMove;
	private int mancalaA;
	private int mancalaB;
	private int turnUndosLeft;
	
	public MancalaModel()
	{
		playerA = new int[NUM_PITS];
		playerB = new int[NUM_PITS];
		potentialMove = new int[NUM_PITS];
		mancalaA = 0;
		mancalaB = 0;
		turnUndosLeft = MAX_UNDOS;
	}
	
	public void move(int index, int player)
	{
		int[] currentPlayer;
		int[] opponent;
		
		if(player == 0) 
		{
			currentPlayer = playerA;
			opponent = playerB;
		}
		else
		{
			currentPlayer = playerB;
			opponent = playerA;
		}
		
		potentialMove = currentPlayer;
		
		for(int i = 1; i < currentPlayer[index] + 1; i++)
		{
			//if the current pit is owned by the player
			if(index + i < NUM_PITS) 
		}
	}
}