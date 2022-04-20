import java.util.Scanner;

public class CinemaRoomManager {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int cinemaRoomHeight = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int cinemaRoomWidth = scanner.nextInt();

        char[][] cinemaRoom = new char[cinemaRoomHeight][cinemaRoomWidth];

        //System.out.println("Total income:\n$" + totalIncome(cinemaRoom, cinemaRoomHeight, cinemaRoomWidth));

        prepareRoom(cinemaRoom, cinemaRoomHeight, cinemaRoomWidth);

        System.out.println("Cinema:");

        showRoom(cinemaRoom, cinemaRoomHeight, cinemaRoomWidth);

        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();

        System.out.println("Ticket price: $" + ticketPrice(cinemaRoom, cinemaRoomHeight, cinemaRoomWidth, rowNumber));

        cinemaRoom = reservation(cinemaRoom, rowNumber, seatNumber);

        System.out.println("Cinema:");

        showRoom(cinemaRoom, cinemaRoomHeight, cinemaRoomWidth);
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
        
        //System.out.println("  1 2 3 4 5 6 7 8");
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
