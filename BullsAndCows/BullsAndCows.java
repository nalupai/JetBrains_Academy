import java.util.Scanner;

public class BullsAndCows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String code = String.valueOf(9305);
        int bulls = 0;
        int cows = 0;
        String userInput = scanner.nextLine();
        String[] answer = userInput.split("");

        for (int i = 0; i < answer.length; i++) {
            int index = code.indexOf(answer[i]);
            if (index == i) {
                bulls++;
            } else if (index >= 0) {
                cows++;
            }
        }

        System.out.println(grade(bulls, cows, code));
        scanner.close();
    }

    private static String grade(int bulls, int cows, String code) {
        String result;

        if (bulls > 0 && cows > 0) {
            result = String.format("%d bull(s) and %d cow(s)", bulls, cows);
        } else if (bulls > 0) {
            result = String.format("%d bull(s)", bulls);
        } else if (cows > 0) {
            result = String.format("%d cow(s)", cows);
        } else {
            result = "None";
        }

        return String.format("Grade: %s. The secret code is %s.", result, code);
    }
}
