import models.*;

import java.util.Scanner;

public class Main {
    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        Validator validator = new Validator();
        Player player1 = new Player(input.nextLine(), validator);
        Player player2 = new Player(input.nextLine(), validator);
        Board board = new Board(player1, player2, validator);
        validator.setBoard(board);
        board.setValidator(validator);
        player1.setBoard(board);
        player2.setBoard(board);
        while(true){

            print(board);

            boolean flag = true;
            while(flag) {
                System.out.println("Pleas move " + player1.getName());
                int x1 = input.nextInt(), y1 = input.nextInt(), x2 = input.nextInt(), y2 = input.nextInt();
                flag = !player1.move(x1, y1, x2, y2);
                if (flag) System.out.println("invalid move!!");
            }

            print(board);

            flag = true;
            while(flag) {
                System.out.println("Pleas move " + player2.getName());
                int x1 = input.nextInt(), y1 = input.nextInt(), x2 = input.nextInt(), y2 = input.nextInt();
                flag = !player2.move(x1, y1, x2, y2);
                if (flag) System.out.println("invalid move!!");
            }
        }
    }
    public static void print(Board board) {
        for (int i = 0; i < 8; i++) {
            System.out.print("|");
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getPiece(i, j);
                if (piece != null) System.out.printf("%.2s|", piece.getType());
                else System.out.print("  |");
            }
            System.out.println();
        }
    }
}
