import java.util.Scanner;

public class Battleship {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[10][10];
        char[][] collisionBoard = new char[10][10];

        char[][] board2 = new char[10][10];
        char[][] collisionBoard2 = new char[10][10];

        int[] coordinatesTable = new int[4];
        String[] shipNames = {"Aircraft Carrier", "Battleship", "Submarine", "Cruiser", "Destroyer"};
        int[] shipLengths = {5, 4, 3, 3, 2};

        prepareBoard(board);
        prepareBoard(board2);
        prepareBoard(collisionBoard);
        prepareBoard(collisionBoard2);

        System.out.println("Player 1, place your ships on the game field");
        showBoard(board);
        
        for (int i = 0; i < shipNames.length;) {
            
            System.out.println("Enter the coordinates of the " + shipNames[i] + " (" + shipLengths[i] + " cells):");
            String coordinates = scanner.nextLine();

            int coordinatesCase = whichCase(coordinates);

            if (coordinatesCase == 1) {
                coordinatesTable = convertFirstCase(coordinates);
            } else if (coordinatesCase == 2) {
                coordinatesTable = convertSecondCase(coordinates);
            } else if (coordinatesCase == 3) {
                coordinatesTable = convertThirdCase(coordinates);
            } 

            coordinatesTable = sequenceChange(coordinatesTable);

            if (!checkingCoordinatesScope(coordinatesTable)) {
                System.out.println("Error! Wrong ship location! Try again:");
                continue;
            }

            if (!checkingShipLength(coordinatesTable, shipLengths[i])) {
                System.out.println("Error! Wrong length of the " + shipLengths[i] + "! Try again:");
                continue;
            }

            if (!checkingCollision(collisionBoard, coordinatesTable)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
                continue;
            }

            addShip(board, coordinatesTable);

            showBoard(board);

            char[][] temp = copyArrayContent(board, collisionBoard);

            collisionBoard = addCollision(temp);

            i++;
        }

        pressEnter();

        System.out.println("Player 2, place your ships to the game field");
        showBoard(board2);

        for (int i = 0; i < shipNames.length;) {
            
            System.out.println("Enter the coordinates of the " + shipNames[i] + " (" + shipLengths[i] + " cells):");
            String coordinates = scanner.nextLine();

            int coordinatesCase = whichCase(coordinates);

            if (coordinatesCase == 1) {
                coordinatesTable = convertFirstCase(coordinates);
            } else if (coordinatesCase == 2) {
                coordinatesTable = convertSecondCase(coordinates);
            } else if (coordinatesCase == 3) {
                coordinatesTable = convertThirdCase(coordinates);
            } 

            coordinatesTable = sequenceChange(coordinatesTable);

            if (!checkingCoordinatesScope(coordinatesTable)) {
                System.out.println("Error! Wrong ship location! Try again:");
                continue;
            }

            if (!checkingShipLength(coordinatesTable, shipLengths[i])) {
                System.out.println("Error! Wrong length of the " + shipLengths[i] + "! Try again:");
                continue;
            }

            if (!checkingCollision(collisionBoard2, coordinatesTable)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
                continue;
            }

            addShip(board2, coordinatesTable);

            showBoard(board2);

            char[][] temp = copyArrayContent(board2, collisionBoard2);

            collisionBoard = addCollision(temp);

            i++;
        }

        pressEnter();

        char[][] game = new char[10][10];
        char[][] game2 = new char[10][10];
        prepareBoard(game);
        prepareBoard(game2);

        int[] fieldCoordinates = new int[2];
        int availableShips = 5;
        int availableShips2 = 5;

        boolean player = true;
        boolean run = true;

        while(run){
            if(player){
                while(availableShips2 != 0){
                    showBoard(game2);
                    System.out.println("---------------------");
                    showBoard(board);
                    System.out.println("Player 1, it's your turn:");
        
                    String field = scanner.nextLine();
                    fieldCoordinates = convertField(field);
        
                    if (fieldCoordinates[0] >= 0 && fieldCoordinates[0] <= 9 && fieldCoordinates[1] >= 0 && fieldCoordinates[1] <= 9) {
                        
                        if (board2[fieldCoordinates[0]][fieldCoordinates[1]] == 'X') {
                            System.out.println("You hit a ship!");
                            player = !player;
                            pressEnter();
                            break;
                        }
        
                        if (board2[fieldCoordinates[0]][fieldCoordinates[1]] == 'M') {
                            System.out.println("You missed!");
                            player = !player;
                            pressEnter();
                            break;
                        }
                        
                        if (board2[fieldCoordinates[0]][fieldCoordinates[1]] == 'O') {
                            game2[fieldCoordinates[0]][fieldCoordinates[1]] = 'X';
                            board2[fieldCoordinates[0]][fieldCoordinates[1]] = 'X';
                            
                            if (shot(board2, fieldCoordinates)) {
                                System.out.println("You hit a ship!");
                                player = !player;
                                pressEnter();
                                break;
                            } else {
                                availableShips2--;
                                if (availableShips2 == 0) {
                                    System.out.println("You sank the last ship. You won. Congratulations!");
                                    run = false;
                                } else {
                                    System.out.println("You sank a ship!");
                                    player = !player;
                                    pressEnter();
                                    break;
                                }
                                
                            }
                        }
        
                        if (board2[fieldCoordinates[0]][fieldCoordinates[1]] == '~') {
                            game2[fieldCoordinates[0]][fieldCoordinates[1]] = 'M';
                            board2[fieldCoordinates[0]][fieldCoordinates[1]] = 'M';
                            System.out.println("You missed!");
                            player = !player;
                            pressEnter();
                            break;
                        }
                        
                    } else {
                        
                        System.out.println("Error! You entered the wrong coordinates! Try again:");
                        continue;
                    }
                }
            } else {
                while(availableShips != 0){
                    showBoard(game);
                    System.out.println("---------------------");
                    showBoard(board2);
                    System.out.println("Player 2, it's your turn:");
        
                    String field = scanner.nextLine();
                    fieldCoordinates = convertField(field);
        
                    if (fieldCoordinates[0] >= 0 && fieldCoordinates[0] <= 9 && fieldCoordinates[1] >= 0 && fieldCoordinates[1] <= 9) {
                        
                        if (board[fieldCoordinates[0]][fieldCoordinates[1]] == 'X') {
                            System.out.println("You hit a ship!");
                            player = !player;
                            pressEnter();
                            break;
                        }
        
                        if (board[fieldCoordinates[0]][fieldCoordinates[1]] == 'M') {
                            System.out.println("You missed!");
                            player = !player;
                            pressEnter();
                            break;
                        }
                        
                        if (board[fieldCoordinates[0]][fieldCoordinates[1]] == 'O') {
                            game[fieldCoordinates[0]][fieldCoordinates[1]] = 'X';
                            board[fieldCoordinates[0]][fieldCoordinates[1]] = 'X';
                            
                            if (shot(board, fieldCoordinates)) {
                                System.out.println("You hit a ship!");
                                player = !player;
                                pressEnter();
                                break;
                            } else {
                                availableShips--;
                                if (availableShips == 0) {
                                    System.out.println("You sank the last ship. You won. Congratulations!");
                                    run = false;
                                } else {
                                    System.out.println("You sank a ship!");
                                    player = !player;
                                    pressEnter();
                                    break;
                                }
                                
                            }
                        }
        
                        if (board[fieldCoordinates[0]][fieldCoordinates[1]] == '~') {
                            game[fieldCoordinates[0]][fieldCoordinates[1]] = 'M';
                            board[fieldCoordinates[0]][fieldCoordinates[1]] = 'M';
                            System.out.println("You missed!");
                            player = !player;
                            pressEnter();
                            break;
                        }
                        
                    } else {
                        
                        System.out.println("Error! You entered the wrong coordinates! Try again:");
                        continue;
                    }
                }
            }
        }
    }

    public static void pressEnter(){
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press Enter and pass the move to another player");

        String enter = scanner.nextLine();
        
        while(enter != ""){
            enter = scanner.nextLine();
        }

        System.out.println("\033[H\033[2J");
    }

    public static boolean shot(char[][] board, int[] coordinates) {

        int k; 
        int m;
        int i = coordinates[0];
        int j = coordinates[1];

        if (coordinates[1] == 0 && (coordinates[0] > 0 && coordinates[0] < 9)){
            if (board[i][j] == 'O' || board[i-1][j] == 'O' || board[i-1][j+1] == 'O' || board[i][j+1] == 'O' || board[i+1][j+1] == 'O' || board[i+1][j] == 'O'){
                return true;
            }

        } else if (coordinates[0] == 0 && (coordinates[1] > 0 && coordinates[1] < 9)){
            if (board[i][j] == 'O' || board[i][j-1] == 'O' || board[i+1][j-1] == 'O' || board[i+1][j] == 'O' || board[i+1][j+1] == 'O' || board[i][j+1] == 'O'){
                return true;
            }

        } else if (coordinates[1] == 9 && (coordinates[0] > 0 && coordinates[0] < 9)){
            if (board[i][j] == 'O' || board[i-1][j] == 'O' || board[i-1][j-1] == 'O' || board[i][j-1] == 'O' || board[i+1][j-1] == 'O' || board[i+1][j] == 'O'){
                return true;
            }

        } else if (coordinates[0] == 9 && (coordinates[1] > 0 && coordinates[1] < 9)){
            if (board[i][j] == 'O' || board[i][j-1] == 'O' || board[i-1][j-1] == 'O' || board[i-1][j] == 'O' || board[i-1][j+1] == 'O' || board[i][j+1] == 'O'){
                return true;
            }

        } else if (coordinates[0] == 0 && coordinates[1] == 0){
            if (board[i][j+1] == 'O' || board[i+1][j+1] == 'O' || board[i+1][j] == 'O'){
                return true;
            }

        } else if (coordinates[0] == 0 && coordinates[1] == 9){
            if (board[i][j-1] == 'O' || board[i+1][j-1] == 'O' || board[i+1][j] == 'O'){
                return true;
            }

        } else if (coordinates[0] == 9 && coordinates[1] == 9){
            if (board[i-1][j] == 'O' || board[i-1][j-1] == 'O' || board[i-1][j] == 'O'){
                return true;
            }

        } else if (coordinates[0] == 9 && coordinates[1] == 0){
            if (board[i-1][j] == 'O' || board[i-1][j+1] == 'O' || board[i][j+1] == 'O'){
                return true;
            }

        } else {
            for (k = 1; k < 9; k++){
                for (m = 1; m < 9; m++){
                    if (board[i][j] == 'O' || board[i-1][j] == 'O' || board[i+1][j] == 'O' || board[i][j-1] == 'O' || board[i][j+1] == 'O' || board[i-1][j-1] == 'O' 
                        || board[i+1][j-1] == 'O' || board[i-1][j+1] == 'O' || board[i+1][j+1] == 'O'){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int[] convertField(String field) {

        int[] coordinates = {10, 10};

        switch(field.charAt(0)) {
            case 'A': coordinates[0] = 0; break;
            case 'B': coordinates[0] = 1; break;
            case 'C': coordinates[0] = 2; break;
            case 'D': coordinates[0] = 3; break;
            case 'E': coordinates[0] = 4; break;
            case 'F': coordinates[0] = 5; break;
            case 'G': coordinates[0] = 6; break;
            case 'H': coordinates[0] = 7; break;
            case 'I': coordinates[0] = 8; break;
            case 'J': coordinates[0] = 9; break;
        }
        
        if (field.length() == 2){
            coordinates[1] =  Character.getNumericValue(field.charAt(1)-1);
        } else if (field.length() == 3 && field.charAt(1) == '1' && field.charAt(2) == '0'){
            coordinates[1] = 9;
        }

        return coordinates;
    }

    public static char[][] addCollision(char[][] board) {

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (board[i][j] == 'O') {
                    board[i-1][j] = 'R';
                    board[i+1][j] = 'R';
                    board[i][j-1] = 'R';
                    board[i][j+1] = 'R';
                    board[i-1][j-1] = 'R';
                    board[i+1][j-1] = 'R';
                    board[i-1][j+1] = 'R';
                    board[i+1][j+1] = 'R';
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                
                if (j == 0 && (i > 0 && i < 9)) {
                    if (board[i][j] == 'O') {
                        board[i-1][j] = 'R';
                        board[i-1][j+1] = 'R';
                        board[i][j+1] = 'R';
                        board[i+1][j+1] = 'R';
                        board[i+1][j] = 'R';
                    }
                }

                if (i == 0 && (j > 0 && j < 9)) {
                    if (board[i][j] == 'O') {
                        board[i][j-1] = 'R';
                        board[i+1][j-1] = 'R';
                        board[i+1][j] = 'R';
                        board[i+1][j+1] = 'R';
                        board[i][j+1] = 'R';
                    }
                }

                if (j == 9 && (i > 0 && i < 9)) {
                    if (board[i][j] == 'O') {
                        board[i-1][j] = 'R';
                        board[i-1][j-1] = 'R';
                        board[i][j-1] = 'R';
                        board[i+1][j-1] = 'R';
                        board[i+1][j] = 'R';
                    }
                }

                if (i == 9 && (j > 0 && j < 9)) {
                    if (board[i][j] == 'O') {
                        board[i][j-1] = 'R';
                        board[i-1][j-1] = 'R';
                        board[i-1][j] = 'R';
                        board[i-1][j+1] = 'R';
                        board[i][j+1] = 'R';
                    }
                }
            }
        }

        return board;
    }

    public static char[][] copyArrayContent(char[][] first, char[][] second) {

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                second[i][j] = first[i][j];
            }
        }
        
        return second;
    }

    public static char[][] addShip(char[][] board, int[] coordinates) {

        for (int i = coordinates[0]; i <= coordinates[2]; i++){
            for (int j = coordinates[1]; j <= coordinates[3]; j++){
                board[i][j] = 'O';
            }
        }

        return board;
    }

    public static boolean checkingCollision(char[][] board, int[] coordinates) {

        for (int i = coordinates[0]; i <= coordinates[2]; i++){
            for (int j = coordinates[1]; j <= coordinates[3]; j++){
                if (board[i][j] != '~') {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkingShipLength(int[] coordinates, int length) {

        if (coordinates[1] == coordinates[3]) {
            if (coordinates[2] - coordinates[0] + 1 != length) {
                return false;
            }
        } else if (coordinates[0] == coordinates[2]) {
            if (coordinates[3] - coordinates[1] + 1 != length) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkingCoordinatesScope(int[] coordinates) {

        if (coordinates[0] == coordinates[2] || coordinates[1] == coordinates[3]) {
            return true;
        }

        return false;
    }

    public static int[] sequenceChange(int[] coordinates) {

        int[] result = new int[4];

        if ((coordinates[0] == coordinates[2] && coordinates[1] > coordinates[3]) || (coordinates[1] == coordinates[3] && coordinates[0] > coordinates[2])) {
            
            result[0] = coordinates[2];
            result[1] = coordinates[3];
            result[2] = coordinates[0];
            result[3] = coordinates[1];

            return result;
        }

        return coordinates;
    }

    public static int[] convertThirdCase(String coordinates) {

        int[] coords = new int[4];

        switch (coordinates.charAt(0)) {
            case 'A': coords[0] = 0; break;
            case 'B': coords[0] = 1; break;
            case 'C': coords[0] = 2; break;
            case 'D': coords[0] = 3; break;
            case 'E': coords[0] = 4; break;
            case 'F': coords[0] = 5; break;
            case 'G': coords[0] = 6; break;
            case 'H': coords[0] = 7; break;
            case 'I': coords[0] = 8; break;
            case 'J': coords[0] = 9; break;
        }
        
        coords[1] = 9;
        
        switch (coordinates.charAt(4)) {
            case 'A': coords[2] = 0; break;
            case 'B': coords[2] = 1; break;
            case 'C': coords[2] = 2; break;
            case 'D': coords[2] = 3; break;
            case 'E': coords[2] = 4; break;
            case 'F': coords[2] = 5; break;
            case 'G': coords[2] = 6; break;
            case 'H': coords[2] = 7; break;
            case 'I': coords[2] = 8; break;
            case 'J': coords[2] = 9; break;
        }
        
        coords[3] = 9;
        
        return coords;
    }

    public static int[] convertSecondCase(String coordinates) {

        int[] coords = new int[4];

        if (coordinates.charAt(2) == ' ') {
            
            switch (coordinates.charAt(0)) {   
                case 'A': coords[0] = 0; break;
                case 'B': coords[0] = 1; break;
                case 'C': coords[0] = 2; break;
                case 'D': coords[0] = 3; break;
                case 'E': coords[0] = 4; break;
                case 'F': coords[0] = 5; break;
                case 'G': coords[0] = 6; break;
                case 'H': coords[0] = 7; break;
                case 'I': coords[0] = 8; break;
                case 'J': coords[0] = 9; break;
            } 
            
            switch (coordinates.charAt(1)) {
                case '1': coords[1] = 0; break;
                case '2': coords[1] = 1; break;
                case '3': coords[1] = 2; break;
                case '4': coords[1] = 3; break;
                case '5': coords[1] = 4; break;
                case '6': coords[1] = 5; break;
                case '7': coords[1] = 6; break;
                case '8': coords[1] = 7; break;
                case '9': coords[1] = 8; break;
            }
            
            switch (coordinates.charAt(3)) {   
                case 'A': coords[2] = 0; break;
                case 'B': coords[2] = 1; break;
                case 'C': coords[2] = 2; break;
                case 'D': coords[2] = 3; break;
                case 'E': coords[2] = 4; break;
                case 'F': coords[2] = 5; break;
                case 'G': coords[2] = 6; break;
                case 'H': coords[2] = 7; break;
                case 'I': coords[2] = 8; break;
                case 'J': coords[2] = 9; break;
            }
            
            coords[3] = 9;
        }

        if (coordinates.charAt(3) == ' ') {
            
            switch (coordinates.charAt(0)) {   
                case 'A': coords[0] = 0; break;
                case 'B': coords[0] = 1; break;
                case 'C': coords[0] = 2; break;
                case 'D': coords[0] = 3; break;
                case 'E': coords[0] = 4; break;
                case 'F': coords[0] = 5; break;
                case 'G': coords[0] = 6; break;
                case 'H': coords[0] = 7; break;
                case 'I': coords[0] = 8; break;
                case 'J': coords[0] = 9; break;
            } 
            
            coords[1] = 9;
            
            switch (coordinates.charAt(4)) {   
                case 'A': coords[2] = 0; break;
                case 'B': coords[2] = 1; break;
                case 'C': coords[2] = 2; break;
                case 'D': coords[2] = 3; break;
                case 'E': coords[2] = 4; break;
                case 'F': coords[2] = 5; break;
                case 'G': coords[2] = 6; break;
                case 'H': coords[2] = 7; break;
                case 'I': coords[2] = 8; break;
                case 'J': coords[2] = 9; break;
            }
           
            switch (coordinates.charAt(5)) {
                case '1': coords[3] = 0; break;
                case '2': coords[3] = 1; break;
                case '3': coords[3] = 2; break;
                case '4': coords[3] = 3; break;
                case '5': coords[3] = 4; break;
                case '6': coords[3] = 5; break;
                case '7': coords[3] = 6; break;
                case '8': coords[3] = 7; break;
                case '9': coords[3] = 8; break;
            }

        }

        return coords;
    }

    public static int[] convertFirstCase(String coordinates) {

        int[] coords = new int[4];

        switch (coordinates.charAt(0)) {   
            case 'A': coords[0] = 0; break;
            case 'B': coords[0] = 1; break;
            case 'C': coords[0] = 2; break;
            case 'D': coords[0] = 3; break;
            case 'E': coords[0] = 4; break;
            case 'F': coords[0] = 5; break;
            case 'G': coords[0] = 6; break;
            case 'H': coords[0] = 7; break;
            case 'I': coords[0] = 8; break;
            case 'J': coords[0] = 9; break;
        }
        
        switch (coordinates.charAt(1)) {
            case '1': coords[1] = 0; break;
            case '2': coords[1] = 1; break;
            case '3': coords[1] = 2; break;
            case '4': coords[1] = 3; break;
            case '5': coords[1] = 4; break;
            case '6': coords[1] = 5; break;
            case '7': coords[1] = 6; break;
            case '8': coords[1] = 7; break;
            case '9': coords[1] = 8; break;
        } 
        
        switch (coordinates.charAt(3)) {   
            case 'A': coords[2] = 0; break;
            case 'B': coords[2] = 1; break;
            case 'C': coords[2] = 2; break;
            case 'D': coords[2] = 3; break;
            case 'E': coords[2] = 4; break;
            case 'F': coords[2] = 5; break;
            case 'G': coords[2] = 6; break;
            case 'H': coords[2] = 7; break;
            case 'I': coords[2] = 8; break;
            case 'J': coords[2] = 9; break;
        }
        
        switch (coordinates.charAt(4)) {
            case '1': coords[3] = 0; break;
            case '2': coords[3] = 1; break;
            case '3': coords[3] = 2; break;
            case '4': coords[3] = 3; break;
            case '5': coords[3] = 4; break;
            case '6': coords[3] = 5; break;
            case '7': coords[3] = 6; break;
            case '8': coords[3] = 7; break;
            case '9': coords[3] = 8; break;
        }
        
        return coords;
    }

    public static int whichCase(String coordinates) {

        if (coordinates.length() == 5) {
            return 1;
        } else if (coordinates.length() == 6) {
            return 2;
        } else if (coordinates.length() == 7) {
            return 3;
        }

        return 0;
    }

    public static void showBoard(char[][] board) {
        
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        char start = 'A';
        for (int i = 0; i < 10; i++){
            System.out.print(start + " ");
            start++;
            for (int j = 0; j < 10; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static char[][] prepareBoard(char[][] board) {
        
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                board[i][j] = '~';
            }
        }
        return board;
    }
}
