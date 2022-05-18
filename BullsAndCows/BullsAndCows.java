import java.util.Random;
import java.util.Scanner;

public class BullsAndCows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int size = scanner.nextInt();
        int maxSize = 10;
        int newDigit;
        String code = "";

        if (size <= maxSize) {
            newDigit = random.nextInt(9) + 1;
            code = code + newDigit;
            while (code.length() < size) {
                newDigit = random.nextInt(9);
                //code.indexOf(String.valueOf(newDigit)) != -1
                if (code.contains(String.valueOf(newDigit))) {
                    continue;
                }
                code = code + newDigit;
            }
            System.out.printf("The random secret number is %s.", code);
        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d " + 
            "because there aren't enough unique digits.", size);
        }
        scanner.close();
    }
}
