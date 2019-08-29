import java.util.Scanner;

public class TicTacToe {

    private int field[][];
    private boolean player;
    private Boolean gameEnded;

    public TicTacToe(){
        field = new int[3][3];
        player = true;
        gameEnded = false;
    }

    public void turn(int i, int j) {
        if(i>3 || j>3)
            return;
        if (player&&field[i-1][j-1] == 0){
            field[i-1][j-1] = 1;
            player = false;
        }
        else if (field[i-1][j-1] == 0){
            field[i-1][j-1] = -1;
            player = true;
        }
    }


    public int[][] getField() {
        return field;
    }

    public void startGame(){
        Scanner in = new Scanner(System.in);
        while (!isGameEnded()){
            System.out.println("Enter your coordinates: ");
            turn(in.nextInt(),in.nextInt());
            print();
        }
        if(player)
            System.out.println("Second player won\n");
        else System.out.println("First player won\n");
    }

    public boolean isGameEnded() {
        for(int i = 0;i<3;++i)
        {
            if(field[i][0]!=0 && field[i][0]== field[i][1] && field[i][1] == field[i][2]
            || field[0][i]!=0 && field[0][i]== field[1][i] && field[1][i] == field[2][i])
                gameEnded = true;
        }
        if(field[0][0]!=0 && field[0][0] == field[1][1] && field[2][2] == field[1][1])
            gameEnded = true;
        if(field[0][2]!=0 && field[0][2] == field[1][1] && field[2][0] == field[1][1])
            gameEnded = true;

        return gameEnded;
    }

    public void print(){
        String message = new String();
        for(int i = 0;i<3;++i){
            for(int j = 0;j<3;++j){
                switch (field[i][j]){
                    case 0:
                        message = message + "_";
                        break;
                    case 1:
                        message = message + "X";
                        break;
                    case -1:
                        message = message + "O";
                    break;
                }
                message = message + " ";
            }
            message = message + "\n";
        }
        System.out.println(message);
    }
}
