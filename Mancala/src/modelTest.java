import static org.junit.Assert.*;

import org.junit.Test;


public class modelTest 
{
	MancalaModel boardModel = new MancalaModel(4,0);
	
	@Test
	public void moveTest() 
	{
		boardModel.move(0, 0);
		boardModel.endTurn();
		assertEquals(5, boardModel.getPiecesInPit(1));
		assertEquals(5, boardModel.getPiecesInPit(2));
		assertEquals(5, boardModel.getPiecesInPit(3));
		assertEquals(5, boardModel.getPiecesInPit(4));
		assertEquals(0, boardModel.getPiecesInPit(0));
		
		boardModel.move(10, 1);
		boardModel.endTurn();
		assertEquals(0, boardModel.getPiecesInPit(10));
		assertEquals(5, boardModel.getPiecesInPit(11));
		assertEquals(5, boardModel.getPiecesInPit(12));
		assertEquals(1, boardModel.getPiecesInPit(13));
		assertEquals(1, boardModel.getPiecesInPit(0));
		
		boardModel.move(5,0);
		boardModel.endTurn();
		assertEquals(0, boardModel.getPiecesInPit(5));
		assertEquals(1, boardModel.getPiecesInPit(6));
		assertEquals(5, boardModel.getPiecesInPit(7));
		assertEquals(5, boardModel.getPiecesInPit(8));
		assertEquals(5, boardModel.getPiecesInPit(9));
		
		boardModel.move(11,1);
		boardModel.endTurn();
		assertEquals(0, boardModel.getPiecesInPit(11));
		assertEquals(6, boardModel.getPiecesInPit(12));
		assertEquals(2, boardModel.getPiecesInPit(13));
		assertEquals(2, boardModel.getPiecesInPit(0));
		assertEquals(6, boardModel.getPiecesInPit(1));
		assertEquals(6, boardModel.getPiecesInPit(2));
		
	}
	
	@Test
	public void captureTest()
	{
		boardModel = new MancalaModel(4,0);
		boardModel.move(4, 0);
		boardModel.endTurn();
		boardModel.move(0, 0);
		boardModel.endTurn();
		assertEquals(7, boardModel.getPiecesInPit(6));
		
		//Check to make sure it doesn't try to capture unless last move.
		boardModel.move(7, 1);
		boardModel.endTurn();
		assertEquals(1, boardModel.getPiecesInPit(8));
		assertEquals(0, boardModel.getPiecesInPit(13));
		
	}
	
	@Test
	public void undoTest()
	{
		boardModel = new MancalaModel(4,0);
		
		assertEquals(3, boardModel.getAvailableUndos());
		boardModel.move(4, 0);
		boardModel.undo();
		assertEquals(2, boardModel.getAvailableUndos());
		boardModel.move(4, 0);
		boardModel.undo();
		assertEquals(1, boardModel.getAvailableUndos());
		boardModel.move(4, 0);
		boardModel.undo();
		assertEquals(0, boardModel.getAvailableUndos());
		
		//Check all pits and mancalas to make sure nothing changed.
		for(int i = 0; i < MancalaModel.TOTAL_INDECIES; i++)
		{
			//System.out.println("INDEX "+i+": "+boardModel.getPiecesInPit(i));
			if(!boardModel.isMancala(i))
				assertEquals(4, boardModel.getPiecesInPit(i));
			else
				assertEquals(0, boardModel.getPiecesInPit(i));
		}
	}
	
	@Test
	public void freeTurnTest()
	{
		boardModel = new MancalaModel(4,0);
		
		assertEquals(0, boardModel.getPlayerTurn());
		boardModel.move(2, 0);
		boardModel.endTurn();
		assertEquals(0, boardModel.getPlayerTurn());
		boardModel.move(3, 0);
		boardModel.endTurn();
		assertEquals(1, boardModel.getPlayerTurn());
		
	}
	
	@Test
	public void winTest()
	{
		boardModel = new MancalaModel(4,0);
		
		boardModel.move(0, 0);
		boardModel.endTurn();		
		boardModel.move(1, 0);
		boardModel.endTurn();
		boardModel.move(2, 0);
		boardModel.endTurn();
		boardModel.move(3, 0);
		boardModel.endTurn();
		boardModel.move(4, 0);
		boardModel.endTurn();
		boardModel.move(5, 0);
		boardModel.endTurn();
		assertEquals(0, boardModel.getPiecesInPit(0));
		assertEquals(0, boardModel.getPiecesInPit(1));
		assertEquals(0, boardModel.getPiecesInPit(2));
		assertEquals(0, boardModel.getPiecesInPit(3));
		assertEquals(0, boardModel.getPiecesInPit(4));
		assertEquals(0, boardModel.getPiecesInPit(5));
		
		assertEquals(true, boardModel.gameOver());
	}

}
