//import java.util.Random;
import java.util.Scanner;

public class BullsAndCows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length:");
        int size = scanner.nextInt();
        int maxSize = 10;

        while(!(size <= maxSize)) {
            System.out.printf("Error: can't generate a secret number with a length of %d " + 
            "because there aren't enough unique digits.\n", size);
            System.out.println("Please, enter the secret code's length:");
            size = scanner.nextInt();
        }

        String code = generate(size); 
        int bulls = 0;
        int cows = 0;
        int turn = 1;
        boolean run = true;
        System.out.println("Okay, let's start a game!");
        while(run) {
            System.out.printf("Turn %d:", turn);
            String input = scanner.next();
            for (int i = 0; i < input.length(); i++) {
                int index = code.indexOf(input.charAt(i));
                if (index == i) {
                    bulls++;
                } else if (index >= 0) {
                    cows++;
                }
            }
            System.out.println(grade(bulls, cows, size));
            if (bulls == size) {
                break;
            }
            bulls = 0;
            cows = 0;
            turn++;
        }
        scanner.close();
    }

    public static String grade(int bulls, int cows, int size) {
        String result;
        if (bulls == size) {
            result = String.format("Grade: %d bulls\nCongratulations! You guessed the secret code.", size);
        } else if (bulls > 0 && cows > 0) {
            result = String.format("%d bull(s) and %d cow(s)", bulls, cows);
        } else if (bulls > 0) {
            result = String.format("%d bull(s)", bulls);
        } else if (cows > 0) {
            result = String.format("%d cow(s)", cows);
        } else {
            result = "None";
        }
        return String.format("Grade: %s", result);
    }

    public static String generate(int size) {
        //Random random = new Random();
        String code = "";
        int maxDigit = 9;
        int newDigit;
        newDigit = (int)(Math.random() * maxDigit) + 1;//random.nextInt(maxDigit) + 1;
        code += newDigit;
        while (code.length() < size) {
            newDigit = (int)(Math.random() * maxDigit);//random.nextInt(maxDigit)
            if (code.contains(String.valueOf(newDigit))) {
                continue;
            }
            code += newDigit;
        }
        return code;
    }
}
