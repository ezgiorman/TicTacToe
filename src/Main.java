import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the sizes of the board:  (3-8): ");
        int size;
        while (true) {
            size = scanner.nextInt();
            if (size >= 3 && size <= 8) {
                break;
            } else {
                System.out.println("Invalid value. Please enter a value between 3 and 8. ");
            }
        }

        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }

        char player = 'X';
        boolean gameWon = false;

        while(!gameWon)
        {
            createBoard(board, size);
            playerMove(board, player, scanner, size);
            gameWon = checkWinner(board, player, size);

            if(gameWon)
            {
                System.out.println("Player " + player + " won the game!");
                createBoard(board, size);
                break;
            }
            if(isBoardFull(board, size))
            {
                System.out.println("No winner!");
                createBoard(board, size);
                break;
            }

            player = (player == 'X') ? 'O' : 'X';

        }

        scanner.close();
    }
    public static void createBoard(char[][] board, int size) {
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
                if (j < size - 1) System.out.print("|");
            }
            System.out.println();
            if (i < size - 1) {
                System.out.print("  ");
                for (int k = 0; k < size; k++) {
                    System.out.print("-");
                    if (k < size - 1) System.out.print("+");
                }
                System.out.println();
            }
        }
    }

    public static void playerMove(char[][] board, char player, Scanner scanner, int size) {
        int row, col;
        while (true) {
            System.out.println("Player" + player + ", choose the row and column: ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ') {
                board[row][col] = player;
                break;
            } else {
                System.out.println("Invalid move, try again. ");
            }

        }
    }

    public static boolean checkWinner(char[][] board, char player, int size) {
        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++) {
                if (board[j][i] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }

        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != player) {
                win = false;
                break;
            }
        }
        if (win) return true;

        win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - i - 1] != player) {
                win = false;
                break;
            }
        }
        return win;
    }



    public static boolean isBoardFull(char[][] board, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

}
