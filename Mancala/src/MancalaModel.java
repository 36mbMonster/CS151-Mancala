import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaModel
{
	public static final int NUM_PITS = 6;
	public static final int NUM_PLAYERS = 2;
	public static final int NUM_MANCALAS = 2;
	public static final int TOTAL_INDECIES = (NUM_PITS * NUM_PLAYERS) + NUM_MANCALAS;
	public static final int MAX_UNDOS = 3;
	
	private ArrayList<ChangeListener> listeners;
	private Pit[] board;
	private Pit[] potentialMove;
	private int turnUndosLeft;
	private int currentTurn;
	private int startingNumPieces;
	private boolean freeTurn;
	private boolean hasMoved;
	
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
	
	public MancalaModel(int startingNumPieces, int startingTurn)
	{
		this.startingNumPieces = startingNumPieces;
		listeners = new ArrayList<>();
		potentialMove = new Pit[NUM_PITS];
		turnUndosLeft = MAX_UNDOS;
		freeTurn = false;
		hasMoved = false;
		
		//Set who's turn it is on the first round.
		currentTurn = startingTurn;
		
		//Initialize board
		resetBoard(startingNumPieces);
		
		potentialMove = new Pit[TOTAL_INDECIES];
		copyBoard(board, potentialMove);
	
			
	}
	
	//handle zero pieces in pit error on interface side.
	//returns true if free move successful.
	public boolean move(int startIndex, int player)
	{

		potentialMove = new Pit[TOTAL_INDECIES];
		copyBoard(board, potentialMove);
		int playerMancala;
		
		if(player == 0) playerMancala = 6;
		else playerMancala = 13;
		
		hasMoved = true;
		
		//Reference to current pit. Used for cycling through the circular list.
		Pit currentPit = potentialMove[startIndex]; 
		for(int i = 1; i < potentialMove[startIndex].getPieces() + 1; i++)
		{
			currentPit = currentPit.getNext(); 
			if(currentPit.getPlayer() != currentTurn && currentPit.isMancala())
				i--;//Do nothing. Don't put pieces in the other player's mancala
			else
				currentPit.addPieces(1);
		}
		
		//If your last stone lands in your mancala, free turn
		if(currentPit.isMancala() && currentPit.getPlayer() == player)
		{
			potentialMove[startIndex].setPieces(0);
			freeTurn = true;
			return true;
		}
		
		//If your last stone lands in an empty pit on your side, take all stones from the pit opposite of it
		//and put it in your mancala
		else if(currentPit.getPieces() == 1 && currentPit.getPlayer() == player)
		{
			//Capture the opposite pit's pieces
			int oppositeIndex = (13 - currentPit.getIndex() - 1);
			potentialMove[playerMancala].addPieces(potentialMove[oppositeIndex].getPieces());
			potentialMove[oppositeIndex].setPieces(0);
			
			//put the piece you dropped in the mancala as well.
			potentialMove[playerMancala].addPieces(currentPit.getPieces());
			currentPit.setPieces(0);
			potentialMove[startIndex].setPieces(0);
			return true;
		}
		//If your last stone lands in an opponent's pit, your turn ends.
		potentialMove[startIndex].setPieces(0);
		return true;
		
	}
	
	//Returns true if undos are available and false if they aren't
	public boolean undo()
	{
		if(turnUndosLeft > 0 && potentialMove != board)
		{
			potentialMove = board;
			turnUndosLeft--;
			hasMoved = false;
			return true;
		}
		else
			return false;
	}
	
	public boolean hasMoved()
	{
		return hasMoved;
	}
	
	public boolean isMancala(int index)
	{
		return board[index].isMancala();
	}
	
	//Is the game finished? Did someone win?
	public boolean gameOver()
	{
		boolean zeroCount1 = true;
		boolean zeroCount2 = true;
		//Check if player1 has any pieces left in their pits
		for(int i = 0; i < TOTAL_INDECIES/2 - 1; i++)
			if(board[i].getPieces() != 0) zeroCount1 = false;
		//Check if player2 has any pieces left in their pits
		for(int i = TOTAL_INDECIES/2 - 1; i < TOTAL_INDECIES - 1; i++)
			if(board[i].getPieces() != 0) zeroCount2 = false;
		
		return zeroCount1 || zeroCount2;			
			
	}
	
	public int getStartingNumPieces()
	{
		return startingNumPieces;
	}
	
	public int getPiecesInPit(int index)
	{
		return potentialMove[index].getPieces();
	}
	
	public int getTotalPlayerPieces(int player)
	{
		int total = 0;
		for(int i = 0; i < TOTAL_INDECIES; i++)
		{
			if(board[i].getPlayer() == player && !board[i].isMancala()) 
				total += board[i].getPieces();
		}
		return total;
	}
	
	public int getAvailableUndos()
	{
		return turnUndosLeft;
	}
	
	public int getPlayerTurn()
	{
		return currentTurn;
	}
	
	public int[] getNumPiecesPerPit()
	{
		int[] pieces = new int[TOTAL_INDECIES];
		for(int i = 0; i < TOTAL_INDECIES; i++)
			pieces[i] = board[i].getPieces();
		
		return pieces;
	}
	
	public Pit getPit(int index)
	{
		return potentialMove[index];
	}
	
	public void attach( ChangeListener c )
	{
		listeners.add(c);
	}
	
	public void update()
	{
      for (ChangeListener l : listeners)
      {
         l.stateChanged(new ChangeEvent(this));
      }
	}
	
	//Set the board to the potential move to end the turn.
	public void endTurn()
	{
		copyBoard(potentialMove, board);
		if(!freeTurn)currentTurn ^= 1; //bit xor with one to change who's turn it is. 
		else freeTurn = false;
		hasMoved = false;
	}
	
	public void resetBoard(int startingNumPieces)
	{
		board = new Pit[TOTAL_INDECIES];
		
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
		potentialMove = board;
		turnUndosLeft = 3;
		currentTurn = 0;
		freeTurn = false;
		hasMoved = false;
	}
	
	//Helper method to copy one array to another, so it's not just a reference to the other board.
	private void copyBoard(Pit[] from, Pit[] to)
	{
	
		for(int i = 0; i < TOTAL_INDECIES; i++)
			to[i] = new Pit(from[i].getPieces(), from[i].isMancala(), from[i].getIndex(), from[i].getPlayer());
		
		to[6] = new Pit(from[6].getPieces(),true,6,0);
		to[13] = new Pit(from[13].getPieces(),true,13,1);	
		
		//link the pits together.
		for(int i = 0; i < TOTAL_INDECIES; i++)
		{
			//When the last pit is reached, link it to the first pit.
			if(i + 1 == TOTAL_INDECIES)
				to[i].setNext(to[0]);
			else
				to[i].setNext(to[i + 1]);
		}
	}
}