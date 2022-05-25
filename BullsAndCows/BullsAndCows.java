import java.util.Random;
import java.util.Scanner;

public class BullsAndCows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the length of the secret code:");
        int size = scanner.nextInt();
        int maxSize = 36;
        int maxSizeForNumbers = 10;

        while(!(size <= maxSize)) {
            System.out.printf("Error: can't generate a secret number with a length of %d " + 
                    "because there aren't enough unique digits.\n", size);
            System.out.println("Please, enter the secret code's length:");
            size = scanner.nextInt();
        }

        System.out.println("Input the number of possible symbols in the code:");
        int possibleSymbols = scanner.nextInt();

        char[] symbols = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f','g', 'h','i','j','k','l','m','n',
                'o','p','q','r','s','t','u','v','w','x','y','z'};

        String code = "";

        String stars = "";
        for(int i = 0; i < size; i++) {
            stars += "*";
        }

        if (possibleSymbols <= maxSizeForNumbers) {
            code = generate(size, maxSizeForNumbers - 1);
            System.out.println("The secret code is prepared: " + stars + " (0-" + symbols[possibleSymbols - 1] + ")");
        } else {
            code = secretCode(size, possibleSymbols, symbols);
            System.out.println("The secret code is prepared: " + stars + " (0-9, a-" + symbols[possibleSymbols - 1] + ")");
        }

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

    public static String secretCode(int size, int possibleElements, char[] elements) {
        String code = "";

        char[] temp = new char[possibleElements];

        for(int i = 0; i < possibleElements; i++) {
            temp[i] = elements[i];
        }

        int[] indexes = generateIndexes(size, possibleElements);

        for(int i=0; i < size; i++) {
            code += temp[indexes[i]];
        }

        return code;
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

    public static int[] generateIndexes(int size, int elements) {
        Random random = new Random();
        int[] indexes = new int[size];
        indexes[0] = random.nextInt(elements);
        int index;
        setIndexes:
        for (int i = 1; i < size;) {
            index = random.nextInt(elements);
            if (index == indexes[i - 1] || index == indexes[0]) {
                continue setIndexes;
            }
            indexes[i] = index;
            i++;
        }
        return indexes;
    }

    public static String generate(int size, int maxDigit) {
        Random random = new Random();
        String code = "";
        int newDigit;
        newDigit = random.nextInt(maxDigit) + 1;
        code += newDigit;
        while (code.length() < size) {
            newDigit = random.nextInt(maxDigit);
            if (code.contains(String.valueOf(newDigit))) {
                continue;
            }
            code += newDigit;
        }
        return code;
    }
}
