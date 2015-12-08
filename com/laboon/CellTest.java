import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CellTest {

	
	/**
	 * getStateRep(Cell cell) Test
	 */
	//test if getStateRep() returns '.' if the cell is dead
	@Test
	public void getStateRepDeadTest() {
		Cell cell = new Cell(State.DEAD , 1 , 1);
		assertTrue(cell.getStateRep() == '.');
		
	}
	
	//test if getStateRep() returns 'X' if the cell is alive
	@Test
	public void getStateRepAliveTest() {
		Cell cell = new Cell(State.ALIVE , 1 , 1);
		assertTrue(cell.getStateRep() == 'X');
			
	}
	//test if getStateRep() returns '?' if State is unkown
	@Test
	public void getStateRepUnknownTest(){
		Cell cell = new Cell(null, 1 ,1);
		assertTrue(cell.getStateRep() == '?');
	}
	
	/**
	 * isAliveTest
	 */
		//Test if isAlive() returns true for living cells
	@Test
	public void isAliveAliveTest(){
		Cell cell = new Cell(State.ALIVE, 1 , 1);
		assertTrue(cell.isAlive());
	}
		
	//Test if isAlive() returns false for Dead cells
	@Test
	public void isAliveDeadTest(){
		Cell cell = new Cell(State.DEAD, 1 , 1);
		assertTrue(!cell.isAlive());
	}
	
	/**
	 * iterateTest
	 * /**
   
     
     * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     * 
	 */
	
	//Test Any live cell with fewer than two live neighbors dies, as if caused by under-population.

	@Test
	public void iterateAliveLessThan2(){
		Cell cell = new Cell(State.ALIVE, 1, 1);
		assertTrue(State.DEAD == cell.iterate(1));
	}
     
   //Test Any live cell with two or three live neighbors lives on to the next generation.
	@Test
	public void iterateAlive2Test(){
		Cell cell = new Cell(State.ALIVE, 1, 1);
		assertTrue(State.ALIVE == cell.iterate(2));
	}
	
	//Test Any live cell with more than three live neighbors dies, as if by overcrowding.
	@Test
	public void iterateAliveGreaterThan2Test(){
		Cell cell = new Cell(State.ALIVE, 1, 1);
		assertTrue(State.DEAD == cell.iterate(4));
	}
	
	//Test Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
	@Test
	public void iterateDeadEqualTo3Test(){
		Cell cell = new Cell(State.DEAD, 1, 1);
		assertTrue(State.ALIVE == cell.iterate(3));
	}
	
	//Test that dead cells remain dead if they don't reproduce
	@Test
	public void iterateDeadNotEqualTo3Test(){
		Cell cell = new Cell(State.DEAD, 1, 1);
		assertTrue(State.DEAD == cell.iterate(1));
	}
		
	@Test
	public void stateTest(){
		Cell cell = new Cell(State.DEAD, 1 ,1);
		assertNotNull(cell.state());
	}
	

}
