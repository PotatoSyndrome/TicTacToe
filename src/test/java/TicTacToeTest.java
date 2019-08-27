import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {



    @Test
    public void OneTurnTest(){
        TicTacToe tested = new TicTacToe();
        tested.turn(1,1);
        assertTrue(1 == tested.getField()[0][0]);
    }

    @Test
    public void TwoTurnsTest(){
        TicTacToe tested = new TicTacToe();
        tested.turn(1,1);
        tested.turn(1,2);
        assertEquals(1,tested.getField()[0][0]);
        assertEquals(-1,tested.getField()[0][1]);
    }

    @Test
    public void SameTurnMustSkip(){
        TicTacToe tested = new TicTacToe();
        tested.turn(1,1);
        tested.turn(1,1);
        assertEquals(1,tested.getField()[0][0]);
    }

    @Test
    public void EndOfTheGameHorizontalTest(){
        TicTacToe tested = new TicTacToe();
        tested.turn(1,1);
        tested.turn(2,1);
        tested.turn(1,2);
        tested.turn(2,2);
        tested.turn(1,3);
        assertTrue(tested.isGameEnded());
    }

    @Test
    public void EndOfTheGameVerticalTest()
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
    public void EndOfTheGameDiagonalTest1(){
        TicTacToe tested = new TicTacToe();
        tested.turn(1,1);
        tested.turn(1,2);
        tested.turn(2,2);
        tested.turn(2,3);
        tested.turn(3,3);
        assertTrue(tested.isGameEnded());
    }

    @Test
    public void EndOfTheGameDiagonalTest2(){
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
