import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {



    @Test
    public void oneTurnTest(){
        TicTacToe tested = new TicTacToe();
        tested.turn(1,1);
        assertEquals(1, tested.getField()[0][0]);
    }

    @Test
    public void twoTurnsTest(){
        TicTacToe tested = new TicTacToe();
        tested.turn(1,1);
        tested.turn(1,2);
        assertEquals(1,tested.getField()[0][0]);
        assertEquals(-1,tested.getField()[0][1]);
    }

    @Test
    public void sameTurnMustSkip(){
        TicTacToe tested = new TicTacToe();
        tested.turn(1,1);
        tested.turn(1,1);
        assertEquals(1,tested.getField()[0][0]);
    }

    @Test
    public void endOfTheGameHorizontalTest(){
        TicTacToe tested = new TicTacToe();
        tested.turn(1,1);
        tested.turn(2,1);
        tested.turn(1,2);
        tested.turn(2,2);
        tested.turn(1,3);
        assertTrue(tested.isGameEnded());
    }

    @Test
    public void endOfTheGameVerticalTest()
    {
        TicTacToe tested = new TicTacToe();
        tested.turn(1,1);
        tested.turn(1,2);
        tested.turn(2,1);
        tested.turn(2,2);
        tested.turn(3,1);
        assertTrue(tested.isGameEnded());
    }

    @Test
    public void endOfTheGameDiagonalTest1(){
        TicTacToe tested = new TicTacToe();
        tested.turn(1,1);
        tested.turn(1,2);
        tested.turn(2,2);
        tested.turn(2,3);
        tested.turn(3,3);
        assertTrue(tested.isGameEnded());
    }

    @Test
    public void endOfTheGameDiagonalTest2(){
        TicTacToe tested = new TicTacToe();
        tested.turn(3,1);
        tested.turn(1,2);
        tested.turn(2,2);
        tested.turn(2,3);
        tested.turn(1,3);
        assertTrue(tested.isGameEnded());
    }

    @Test
    public void biggerValuesMustIgnore(){
        TicTacToe tested = new TicTacToe();
        tested.turn(5,0);
        tested.turn(0,5);
    }
}
