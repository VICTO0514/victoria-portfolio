import java.util.Scanner;
public class TicTacToe {
   static char[][] board = new char[3][3];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
            board[i][j]=' '; 
            }
        }

        char currentPlayer='X';
        boolean gameWon=false;
        int movesCount=0;

        while(true) {
        initialize();

            System.out.println("Player "+currentPlayer+" -enter row (1-3) and column (1-3):");
            int row=sc.nextInt()-1; 
            int col=sc.nextInt()-1;

            if(row<0 || row>= 3 || col<0 || col>=3 || board[row][col]!=' ') {
            System.out.println("Invalid move, try again!");
            continue;
            }

            board[row][col]=currentPlayer;
            movesCount++;
            
            if(checkWin(currentPlayer)) {
                initialize();
                System.out.println("Player "+currentPlayer+" wins!");
                gameWon = true;
                break;
            }

            if(movesCount==9) {
                initialize();
                System.out.println("It's a Draw!");
                break;
            }

            currentPlayer=(currentPlayer=='X')?'O':'X';
        }
        sc.close();
    }

    public static void initialize() {
        for (int i=0;i<3;i++) {
            System.out.print("| ");
            for (int j=0;j<3;j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }
    public static boolean checkWin(char player) {
        for(int i=0;i<3;i++) {
            if (board[i][0]==player && board[i][1]==player && board[i][2]==player)
                return true;
        }

        for(int j=0;j<3;j++) {
            if (board[0][j]==player && board[1][j]==player && board[2][j]==player)
                return true;
        }

        if(board[0][0]==player && board[1][1]==player && board[2][2]==player)
            return true;
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player)
            return true;

        return false;
    }
}

