import java.util.Scanner;

public class DynamicTicTacToe{
    
    static char[][] board;
    static int n;

//initialize
    public static void initialize(int size){
        board=new char[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j]='-';
            }
        }
    }

//print board
    public static void printBoard() {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    
//check win condition
    public static boolean checkWin(char player){
    //row check
    for(int i=0;i<n;i++){
        boolean rowWin=true;
        for(int j=0;j<n;j++){
            if(board[i][j]!=player){
            rowWin=false;
            break;
            }
        }
        if(rowWin) return true;
    }
    
    //col check
    for(int j=0;j<n;j++){
        boolean colWin=true;
        for(int i=0;i<n;i++){
            if(board[i][j]!=player){
            colWin=false;
            break;
            }
       }
       if(colWin) return true;
   } 
   
   //diagonal check
   boolean diagWin=true;
   for(int i=0;i<n;i++){
       if(board[i][i]!=player){
       diagWin=false;
       break;
       }
   }
       if(diagWin) return true;  
       
   //anti-diag check
   boolean antiDiag=true;
   for(int i=0;i<n;i++){
       if(board[i][n-1-i]!=player){
       antiDiag=false;
       break;
       }
   }
       if(antiDiag) return true;
   
   return false;
}

//check if board full
    public static boolean isFull(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='-'){
                return false;
                }
           }
        }
        return true;
    }
     
   public static void main(String[] args){
   
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter board size");
       n=sc.nextInt();
       
       initialize(n);
       
       char currentPlayer='X';
       boolean gameOver=false;
       
       while(!gameOver){
           printBoard();
        
           System.out.println("Player "+ currentPlayer + " turn.");
           System.out.print("Enter rows and columns");
           int row=sc.nextInt();
           int col=sc.nextInt();
           
           //check valid move
           if(row>=0 && row<n && col>=0 && col<n && board[row][col]=='-') {
               board[row][col]=currentPlayer;
           
           //check win
               if(checkWin(currentPlayer)){
               printBoard();
               System.out.println("Player "+currentPlayer+"Wins!");
               gameOver=true;
               }
               
               //check tie
               else if(isFull()){
               printBoard();
               System.out.println("Game end in a Tie!");
               gameOver=true;
               }
               //switch player
               else{
               currentPlayer=(currentPlayer=='X') ? 'O' : 'X';
               }
               }
               
               else{
               System.out.println("Invalid move,try again!");
               continue;
               }   
     }
     }
}
       


