import java.util.Scanner;

public class CinemaRoomManager {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int cinemaRoomHeight = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int cinemaRoomWidth = scanner.nextInt();

        char[][] cinemaRoom = new char[cinemaRoomHeight][cinemaRoomWidth];
        prepareRoom(cinemaRoom, cinemaRoomHeight, cinemaRoomWidth);

        int purchasedTickets = 0;
        float percentage = 0.00f;
        int currentIncome = 0;

        boolean run = true;

        while(run) {

            System.out.println("""
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit""");

            String action = scanner.next();
    
            switch (action) {
                case "1":
                    System.out.println("Cinema:");
                    showRoom(cinemaRoom, cinemaRoomHeight, cinemaRoomWidth);
                    break;
                case "2":
                    run = false;
                    while(!run) {
                        System.out.println("Enter a row number:");
                        int rowNumber = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int seatNumber = scanner.nextInt();
                        if (checkAvailability(cinemaRoom, rowNumber, seatNumber)) {
                            System.out.println("Ticket price: $" + ticketPrice(cinemaRoom, cinemaRoomHeight, cinemaRoomWidth, rowNumber));
                            cinemaRoom = reservation(cinemaRoom, rowNumber, seatNumber);
                            purchasedTickets++;
                            currentIncome = currentIncome + ticketPrice(cinemaRoom, cinemaRoomHeight, cinemaRoomWidth, rowNumber);
                            run = true;
                        } else {
                            System.out.println("That ticket has already been purchased!");
                            run = false;
                        }
                    }
                    break;
                case "3":
                    System.out.println("Number of purchased tickets: " + purchasedTickets);
                    percentage = purchasedTickets * 100f / (cinemaRoomHeight * cinemaRoomWidth);
                    System.out.printf("Percentage: %.2f%%\n", percentage);
                    System.out.println("Current income: $" + currentIncome);
                    System.out.println("Total income: $" + totalIncome(cinemaRoom, cinemaRoomHeight, cinemaRoomWidth));
                    break;
                case "0":
                    run = false; 
                    break;
            }
        }
    }

    public static boolean checkAvailability(char[][] room, int row, int seat) {

        if (row > 9 || seat > 9) {
            System.out.println("Wrong input!");
            return false;
        } else {
            if (room[row-1][seat-1] == 'B') {
                return false;
            } else {
                return true;
            }
        }
    }

    public static char[][] reservation(char[][] room, int row, int seat) {

        room[row-1][seat-1] = 'B';
        return room;
    }

    public static int ticketPrice(char[][] room, int height, int width, int row) {

        if (height * width < 60) {
            return 10;
        } else {
            if (row <= height / 2) {
                return 10;
            } else {
                return 8;
            }
        }
    }

    public static int totalIncome(char[][] room, int height, int width) {

        if (height * width < 60) {
            return height * width * 10;
        } else {
            if (height % 2 != 0) {
                return height / 2 * 10 * width + (height - height / 2) * 8 * width;
            } else {
                return height / 2 * 10 * width + height / 2 * 8 * width;
            }
        }
    }

    public static void showRoom(char[][] room, int height, int width) {
        
        String label = " ";

        for (int i = 1; i <= width; i++) {
            label = label + " " + String.valueOf(i);
        }

        System.out.println(label);

        for(int i = 0; i < height; i++){
            System.out.print(i + 1 + " ");

            for(int j = 0; j < width; j++){
                System.out.print(room[i][j] + " ");
            }
            
            System.out.println();
        } 
    }

    public static char[][] prepareRoom(char[][] room, int height, int width) {
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                room[i][j] = 'S';
            }
        }
        
        return room;
    }
}
