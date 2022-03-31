import java.util.Scanner;

public class SimpleTicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String game = scanner.next();

        showingTheGame(game);

        System.out.println(analyzingTheGame(game));
        
        String n = "";
        String m = "";

        boolean playing = false;
        
        while (playing == false) {
            System.out.println("Enter coordinates:");
            n = scanner.next();
            m = scanner.next();
            playing = doWePlay(n, m, game);
        }
        
        game = implementationIntoTheGame(n, m, game);
        showingTheGame(game);
    }

    static void showingTheGame(String game) {
        
        System.out.println("---------");
        System.out.println("| " + game.charAt(0) + " " + game.charAt(1) + " " + game.charAt(2) + " |");
        System.out.println("| " + game.charAt(3) + " " + game.charAt(4) + " " + game.charAt(5) + " |");
        System.out.println("| " + game.charAt(6) + " " + game.charAt(7) + " " + game.charAt(8) + " |");
        System.out.println("---------");
    }

    static String analyzingTheGame(String game) {

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
            return "X wins";
        } else if (dxo <= 1 && winnerX == false && winnerO == true) {
            return "O wins";
        } else if (dxo <= 1 && howMany_ == 0) {
            return "Draw";
        } else if (dxo == 1 || dxo == 0 && howMany_ != 0 && winnerX == false && winnerO == true) {
            return "Game not finished";
        } else {
            return "Impossible";
        }
    }

    static String implementationIntoTheGame(String n, String m, String game) {

        String newSequence = "";

        if (n.equals("1") && m.equals("1") && game.charAt(0) == '_') {
            newSequence = "X" + game.substring(1,9);
        } else if (n.equals("1") && m.equals("2") && game.charAt(1) == '_') {
            newSequence = game.substring(0,1) + "X" + game.substring(2,9);
        } else if (n.equals("1") && m.equals("3") && game.charAt(2) == '_') {
            newSequence = game.substring(0,2) + "X" + game.substring(3,9);
        } else if (n.equals("2") && m.equals("1") && game.charAt(3) == '_') {
            newSequence = game.substring(0,3) + "X" + game.substring(4,9);
        } else if (n.equals("2") && m.equals("2") && game.charAt(4) == '_') {
            newSequence = game.substring(0,4) + "X" + game.substring(5,9);
        } else if (n.equals("2") && m.equals("3") && game.charAt(5) == '_') {
            newSequence = game.substring(0,5) + "X" + game.substring(6,9);
        } else if (n.equals("3") && m.equals("1") && game.charAt(6) == '_') {
            newSequence = game.substring(0,6) + "X" + game.substring(7,9);
        } else if (n.equals("3") && m.equals("2") && game.charAt(7) == '_') {
            newSequence = game.substring(0,7) + "X" + game.substring(8,9);
        } else if (n.equals("3") && m.equals("3") && game.charAt(8) == '_') {
            newSequence = game.substring(0,8) + "X";
        } else {
            newSequence = game;
        }
        
        return newSequence;    
    }

    static boolean doWePlay(String n, String m, String game) {
        
        if (n.equals("1") && m.equals("1") && (game.charAt(0) == 'X' || game.charAt(0) == 'O')) {
            System.out.println("This cell is ocupied! Choose another one!");
            return false;
        } else if (n.equals("1") && m.equals("2") && (game.charAt(1) == 'X' || game.charAt(1) == 'O')) {
            System.out.println("This cell is ocupied! Choose another one!");
            return false;
        } else if (n.equals("1") && m.equals("3") && (game.charAt(2) == 'X' || game.charAt(2) == 'O')) {
            System.out.println("This cell is ocupied! Choose another one!");
            return false;
        } else if (n.equals("2") && m.equals("1") && (game.charAt(3) == 'X' || game.charAt(3) == 'O')) {
            System.out.println("This cell is ocupied! Choose another one!");
            return false;
        } else if (n.equals("2") && m.equals("2") && (game.charAt(4) == 'X' || game.charAt(4) == 'O')) {
            System.out.println("This cell is ocupied! Choose another one!");
            return false;
        } else if (n.equals("2") && m.equals("3") && (game.charAt(5) == 'X' || game.charAt(5) == 'O')) {
            System.out.println("This cell is ocupied! Choose another one!");
            return false;
        } else if (n.equals("3") && m.equals("1") && (game.charAt(6) == 'X' || game.charAt(6) == 'O')) {
            System.out.println("This cell is ocupied! Choose another one!");
            return false;
        } else if (n.equals("3") && m.equals("2") && (game.charAt(7) == 'X' || game.charAt(7) == 'O')) {
            System.out.println("This cell is ocupied! Choose another one!");
            return false;
        } else if (n.equals("3") && m.equals("3") && (game.charAt(8) == 'X' || game.charAt(8) == 'O')) {
            System.out.println("This cell is ocupied! Choose another one!");
            return false;
        } 
                    
        if ((n.equals("1") || n.equals("2") || n.equals("3")) && (m.equals("1") || m.equals("2") || m.equals("3"))) {
            return true;
        } else {
            
            boolean validation;
            
            try {
                Integer.parseInt(n);
                Integer.parseInt(m); 
                validation = false;
            } catch (NumberFormatException e) {
                validation = true;
            } catch (NullPointerException e) {
                validation = true;
            }
       
            if (validation) {
                System.out.println("You should enter numbers");
                return false;  
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }
        }
    }
}
