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
    }
}
