import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int requiredWater = 200;
        int requiredMilk = 50;
        int requiredBeans = 15;
        
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int order = scanner.nextInt();
        
        int cupsOfWater = water / requiredWater;
        int cupsOfMilk = milk / requiredMilk;
        int cupsOfBeans = beans / requiredBeans;
        
        int cups = 0;
        
        if (cupsOfWater <= cupsOfMilk && cupsOfWater <= cupsOfBeans) {
            cups = cupsOfWater;    
        } else if (cupsOfMilk <= cupsOfWater && cupsOfMilk <= cupsOfBeans) {
            cups = cupsOfMilk;    
        } else if (cupsOfBeans <= cupsOfWater && cupsOfBeans <= cupsOfMilk) {
            cups = cupsOfBeans;    
        }
        
        if (cups < order) {
            System.out.println("No, I can make only " + cups + " cup(s) of coffee");
        } else if (cups == order) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cups > order) {
            int delta = cups - order;
            System.out.println("Yes, I can make that amount of coffee (and even " + delta + " more than that)");
        }
    }
}
