package Java;
import java.util.*;
public class TicTacToe2D {
    static String[][] board = new String[3][3];
    private Scanner sc = new Scanner(System.in);
    static boolean gameOver = false;
    static int column = 0;
    static int playerToggle = 1;
    static int row = 0;
    static int numOfMoves = 0;
    public static void main(String[] args) {
        //TODO: MAKE GAME LOOP, MAKING MOVES
        
        TicTacToe2D bd = new TicTacToe2D();
        bd.makeBoard();
        bd.printBoard();
        while (gameOver == false){
            row = bd.askForInput("Row position: ");
            column = bd.askForInput("Column position: ");
            if (column>=0 && column <=2 && row >= 0 && row<= 2 && bd.positionTaken(row,column)==true){
                if (playerToggle == 1){
                    bd.setPosition(row, column, playerToggle);
                    bd.printBoard();
                    numOfMoves += 1;
                    playerToggle = 2;
                    if (bd.columnWin() == true || bd.rowWin() == true|| bd.diagonalWin() == true){
                        System.out.println("Player 1 wins!");
                        gameOver = true;
                    }
                    else if (numOfMoves == 9) {
                        System.out.println("Draw");
                        gameOver = true;
                    }
                }
                else {
                    bd.setPosition(row, column, playerToggle);
                    bd.printBoard();
                    numOfMoves += 1;
                    playerToggle = 1;
                    if (bd.columnWin() == true || bd.rowWin() == true|| bd.diagonalWin() == true){
                        System.out.println("Player 2 wins!");
                        gameOver = true;
                    }
                    else if (numOfMoves == 9) {
                        System.out.println("Draw");
                        gameOver = true;
                    }
                }
            }
            else if (bd.positionTaken(row,column)==false){
                System.out.println("Position is taken");
            }
            else {
                System.out.println("Invalid input");
            }
        }
             
        /* 
        /* 
        int row = 0;
        row = bd.askForInput("Row position");
        int column = 0;
        int playerToggle = 1;
        column = bd.askForInput("Column position");*/
        
    
    }

    private void makeBoard() {
        board[0][0] = "-";
        board[0][1] = "-";
        board[0][2] = "-";
        board[1][0] = "-";
        board[1][1] = "-";
        board[1][2] = "-";
        board[2][0] = "-";
        board[2][1] = "-";
        board[2][2] = "-";
    }
    
    
    public void printBoard() {
        System.out.println(" " + board[0][0] + "  | " + board[0][1] + "  | " + board[0][2]);
        System.out.println("-------------");
        System.out.println(" " + board[1][0] + "  | " + board[1][1] + "  | " + board[1][2]);
        System.out.println("-------------");
        System.out.println(" " + board[2][0] + "  | " + board[2][1] + "  | " + board[2][2]);
    }
    public int askForInput(String message) {
        System.out.println(message);
        return sc.nextInt();
    }
    public void setPosition(int row, int column, int player){
        if (player == 1) {
            board[row][column]="X";
        }
        else { 
            board[row][column]="O";
        }

        
    }
    public boolean columnWin(){
        for(int i = 0; i<3;i++) {
            if (board[0][i]!="-" && board[0][i]==board[1][i] && board[0][i]==board[2][i]){
                return true;
            }
        }
        return false;
        
    }
    public Boolean rowWin(){
        for(int i=0; i<3;i++){
            if (board[i][0]!= "-" && board[i][0] == board[i][1] && board[i][0] == board[i][2]){
                return true;
            }

        }
        return false;

    }

    public Boolean diagonalWin(){
        if(board[0][0]!="-"&&board[0][0]==board[1][1] && board[0][0]==board[2][2]){
            return true;
        } 
        else if (board[2][0]!="-"&&board[2][0]==board[1][1] && board[2][0]==board[0][2]){
            return true;
        }
        return false;
    
    
    }
    public Boolean positionTaken(int row, int column){
        if (board[row][column]!="-"){
            return false;
        }
        return true;
    }

}
