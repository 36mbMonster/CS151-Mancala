import static org.junit.Assert.*;

import org.junit.Test;


public class modelTest 
{
	MancalaModel boardModel = new MancalaModel(4);
	
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
	}

}
