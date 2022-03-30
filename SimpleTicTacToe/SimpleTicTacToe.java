import java.util.Scanner;

public class SimpleTicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String game = scanner.next();
        
        System.out.println("---------");
        System.out.println("| " + game.charAt(0) + " " + game.charAt(1) + " " + game.charAt(2) + " |");
        System.out.println("| " + game.charAt(3) + " " + game.charAt(4) + " " + game.charAt(5) + " |");
        System.out.println("| " + game.charAt(6) + " " + game.charAt(7) + " " + game.charAt(8) + " |");
        System.out.println("---------");

        int howMany_ = 0, howManyX = 0, howManyO = 0;

        boolean winnerX = false, winnerO = false;
        
        for (int i = 0; i < game.length();) {

            if (game.charAt(i) == '_') {
                howMany_++;
            } else if (game.charAt(i) == 'X') {
                howManyX++;
            } else if (game.charAt(i) == 'O') {
                howManyO++;
            }

            i++;
        }

        int dxo = (howManyX - howManyO)^2/2;

        if ((game.charAt(0) == game.charAt(1) && game.charAt(1) == game.charAt(2) && game.charAt(0) == 'X') ||
            (game.charAt(3) == game.charAt(4) && game.charAt(4) == game.charAt(5) && game.charAt(3) == 'X') ||
            (game.charAt(6) == game.charAt(7) && game.charAt(7) == game.charAt(8) && game.charAt(6) == 'X') ||
            (game.charAt(0) == game.charAt(3) && game.charAt(3) == game.charAt(6) && game.charAt(0) == 'X') ||
            (game.charAt(1) == game.charAt(4) && game.charAt(4) == game.charAt(7) && game.charAt(1) == 'X') ||
            (game.charAt(2) == game.charAt(5) && game.charAt(5) == game.charAt(8) && game.charAt(2) == 'X') ||
            (game.charAt(0) == game.charAt(4) && game.charAt(4) == game.charAt(8) && game.charAt(0) == 'X') ||
            (game.charAt(6) == game.charAt(4) && game.charAt(4) == game.charAt(2) && game.charAt(6) == 'X') && dxo <= 1) {
              
            winnerX = true;
        }

        if ((game.charAt(0) == game.charAt(1) && game.charAt(1) == game.charAt(2) && game.charAt(0) == 'O') ||
            (game.charAt(3) == game.charAt(4) && game.charAt(4) == game.charAt(5) && game.charAt(3) == 'O') ||
            (game.charAt(6) == game.charAt(7) && game.charAt(7) == game.charAt(8) && game.charAt(6) == 'O') ||
            (game.charAt(0) == game.charAt(3) && game.charAt(3) == game.charAt(6) && game.charAt(0) == 'O') ||
            (game.charAt(1) == game.charAt(4) && game.charAt(4) == game.charAt(7) && game.charAt(1) == 'O') ||
            (game.charAt(2) == game.charAt(5) && game.charAt(5) == game.charAt(8) && game.charAt(2) == 'O') ||
            (game.charAt(0) == game.charAt(4) && game.charAt(4) == game.charAt(8) && game.charAt(0) == 'O') ||
            (game.charAt(6) == game.charAt(4) && game.charAt(4) == game.charAt(2) && game.charAt(6) == 'O') && dxo <= 1) {
              
            winnerO = true;
        }

        if (dxo <= 1 && winnerX == true && winnerO == false) {
            System.out.println("X wins");
        } else if (dxo <= 1 && winnerX == false && winnerO == true) {
            System.out.println("O wins");
        } else if (dxo <= 1 && howMany_ == 0) {
            System.out.println("Draw");
        } else if (dxo == 1 || dxo == 0 && howMany_ != 0 && winnerX == false && winnerO == true) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Impossible");
        }
    }
}
