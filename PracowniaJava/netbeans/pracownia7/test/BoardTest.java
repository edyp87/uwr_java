import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pracownia7.PegSolitaire.*;

public class BoardTest {
    
    public BoardTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp()
    {
        m_board = new BoardBritish();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void canCreate()
    {
        // nothing
    }
    
    @Test
    public void constructorCreatesDefaultBoard()
    {
        Integer[][] l_board = new Integer[][]
        {
            {0, 0, 1, 1, 1, 0, 0}, 
            {0, 0, 1, 1, 1, 0, 0} ,
            {1, 1, 1, 1, 1, 1, 1} ,
            {1, 1, 1, 0, 1, 1, 1} ,
            {1, 1, 1, 1, 1, 1, 1} ,
            {0, 0, 1, 1, 1, 0, 0} ,
            {0, 0, 1, 1, 1, 0, 0} 
        };
        Assert.assertArrayEquals(m_board.getBoard(), l_board);
    }
    
    @Test
    public void canMoveLeftIfNewPositionIsValid()
    {
        assertEquals(m_board.moveLeft(3, 5), true);
    }
    
    @Test
    public void cantMoveLeftIfGoOutsideBoard()
    {
        assertEquals(m_board.moveLeft(0, 3), false); 
        assertEquals(m_board.moveLeft(2, 1), false); 
    }
    
    @Test
    public void cantMoveIfPickedPegFormOutsideTheBoard()
    {
        assertEquals(m_board.moveLeft(0, 0), false);
        assertEquals(m_board.moveLeft(-4465, 4421), false);
    }
    
    @Test
    public void canMoveRightIfNewPositionIsValid()
    {
        assertEquals(m_board.moveRight(3, 1), true);
    }
    
    @Test
    public void cantMoveRightIfGoOutsideBoard()
    {
        assertEquals(m_board.moveRight(0, 3), false); 
        assertEquals(m_board.moveRight(2, 5), false); 
    }
 
    @Test
    public void canMoveUpIfNewPositionIsValid()
    {
        assertEquals(m_board.moveUp(5, 3), true);
    }
    
    @Test
    public void cantMoveUpIfGoOutsideBoard()
    {
        assertEquals(m_board.moveUp(3, 0), false); 
        assertEquals(m_board.moveUp(1, 3), false); 
    }
    
    @Test
    public void canMoveDownIfNewPositionIsValid()
    {
        assertEquals(m_board.moveDown(1, 3), true);
    }
    
    @Test
    public void cantMoveDownIfGoOutsideBoard()
    {
        assertEquals(m_board.moveDown(3, 5), false); 
        assertEquals(m_board.moveDown(5, 3), false); 
    }
    
   @Test
    public void cantMoveIfAllPositionsAreWithPegs()
    {
        assertEquals(m_board.moveDown(2, 4), false); 
        assertEquals(m_board.moveDown(4, 3), false); 
    }
    
    @Test
    public void canRedoLastOperations()
    {
        Integer[][] l_board = new Integer[][]
        {
            {0, 0, 1, 1, 1, 0, 0}, 
            {0, 0, 1, 1, 1, 0, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 0, 0},
            {0, 0, 1, 1, 1, 0, 0} 
        };
        Assert.assertArrayEquals(m_board.getBoard(), l_board);
        assertEquals(m_board.moveDown(1, 3), true);
        l_board = new Integer[][]
        {
            {0, 0, 1, 1, 1, 0, 0}, 
            {0, 0, 1, 0, 1, 0, 0},
            {1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 0, 0},
            {0, 0, 1, 1, 1, 0, 0} 
        };
        Assert.assertArrayEquals(m_board.getBoard(), l_board);
        m_board.revertLastMove();
        l_board = new Integer[][]
        {
            {0, 0, 1, 1, 1, 0, 0}, 
            {0, 0, 1, 1, 1, 0, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 0, 0},
            {0, 0, 1, 1, 1, 0, 0} 
        };
        Assert.assertArrayEquals(m_board.getBoard(), l_board);
        m_board.revertLastMove();
        m_board.revertLastMove();
        m_board.revertLastMove();
        Assert.assertArrayEquals(m_board.getBoard(), l_board);
    }
    
    @Test
    public void checkIfIsAnyMovePossible()
    {
        Integer[][] l_board = new Integer[][]
        {
            {0, 0, 1, 1, 1, 0, 0}, 
            {0, 0, 1, 1, 1, 0, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 0, 0},
            {0, 0, 1, 1, 1, 0, 0} 
        };
        Assert.assertArrayEquals(m_board.getBoard(), l_board);
        assertEquals(m_board.isAnyMovePossible(), true);
        assertEquals(m_board.numberfPegs(), 32);
        
        assertEquals(m_board.moveUp(5,3), true);    
            assertEquals(m_board.isAnyMovePossible(), true);
            assertEquals(m_board.numberfPegs(), 31);
        assertEquals(m_board.moveDown(2,3), true);  
            assertEquals(m_board.numberfPegs(), 30);
            assertEquals(m_board.isAnyMovePossible(), true);
        assertEquals(m_board.moveRight(3,1), true); 
            assertEquals(m_board.numberfPegs(), 29);
            assertEquals(m_board.isAnyMovePossible(), true);
        assertEquals(m_board.moveLeft(3,4), true);  
            assertEquals(m_board.numberfPegs(), 28);
            assertEquals(m_board.isAnyMovePossible(), true);
        assertEquals(m_board.moveDown(0,3), true);  
            assertEquals(m_board.numberfPegs(), 27);
            assertEquals(m_board.isAnyMovePossible(), true);
        assertEquals(m_board.moveLeft(3,6), true);
            assertEquals(m_board.numberfPegs(), 26);
        
        assertEquals(m_board.isAnyMovePossible(), false);
    }
    
    IBoard m_board;
}
