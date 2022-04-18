public class CinemaRoomManager {
    
    public static void main(String[] args) {

        int cinemaRoomHeight = 7, cinemaRoomWidth = 8;

        char[][] cinemaRoom = new char[cinemaRoomHeight][cinemaRoomWidth];

        prepareRoom(cinemaRoom, cinemaRoomHeight, cinemaRoomWidth);

        System.out.println("Cinema:");

        showRoom(cinemaRoom, cinemaRoomHeight, cinemaRoomWidth);
    }

    public static void showRoom(char[][] room, int height, int width) {
        
        System.out.println("  1 2 3 4 5 6 7 8");

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
