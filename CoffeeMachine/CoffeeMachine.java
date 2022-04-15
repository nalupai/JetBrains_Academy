import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int basicWater = 400;
        int basicMilk = 540;
        int basicBeans = 120;
        int basicCups = 9;
        int basicMoney = 550;

        int[] machineContents = {basicWater, basicMilk, basicBeans, basicCups, basicMoney};

        int cup = 1;

        int waterEspresso = 250;
        int milkEspresso = 0;
        int beansEspresso = 16;
        int moneyEspresso = 4;

        int[] espresso = {waterEspresso, milkEspresso, beansEspresso, cup, moneyEspresso};
        
        int waterLatte = 350;
        int milkLatte = 75;
        int beansLatte = 20;
        int moneyLatte = 7;

        int[] latte = {waterLatte, milkLatte, beansLatte, cup, moneyLatte};
        
        int waterCappuccino = 200;
        int milkCappuccino = 100;
        int beansCappuccino = 12;
        int moneyCappuccino = 6;

        int[] cappuccino = {waterCappuccino, milkCappuccino, beansCappuccino, cup, moneyCappuccino};

        int add = 0;

        boolean run = true;

        while(run == true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String option = scanner.next();
                    switch (option) {
                        case "1":
                            machineContents = buy(machineContents, espresso);
                            break;
                        case "2":
                            machineContents = buy(machineContents, latte);
                            break;
                        case "3":
                            machineContents = buy(machineContents, cappuccino);
                            break;
                        case "back":
                            break;
                    }
                    break;

                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    add = scanner.nextInt();
                    machineContents[0] += add;
                    System.out.println("Write how many ml of milk do you want to add:");
                    add = scanner.nextInt();
                    machineContents[1] += add;
                    System.out.println("Write how many grams of coffee beans do you want to add:"); 
                    add = scanner.nextInt();
                    machineContents[2] += add;
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    add = scanner.nextInt();
                    machineContents[3] += add;
                    break;
                
                case "take":
                    System.out.println("I gave you $" + machineContents[4]);
                    machineContents[4] = 0;
                    break;

                case "remaining":
                    show(machineContents);
                    break;

                case "exit":
                    run = false;
                    break;
            }
        }
    }

    public static int[] buy(int[] machineContents, int[] coffee) {

        int[] newMachineContents = new int[5];

        for (int i = 0; i < 4; i++) {
            if (machineContents[i] < coffee[i]) {
                if ( i == 1) {
                    System.out.println("Sorry, not enough water!");
                }
                if ( i == 2) {
                    System.out.println("Sorry, not enough milk!");
                }
                if ( i == 3) {
                    System.out.println("Sorry, not enough beans!");
                }
                if ( i == 4) {
                    System.out.println("Sorry, not enough cups!");
                }
                return machineContents;
            }
        }

        System.out.println("I have enough resources, making you a coffee!");

        for (int i = 0; i < 5; i++) {
            if (i == 4) {
                newMachineContents[i] = machineContents[i] + coffee[i];
            } else {
                newMachineContents[i] = machineContents[i] - coffee[i];
            }
        }

        return newMachineContents;
    }

    public static void show(int[] machineContents) {

        System.out.println("The coffee machine has:");
        System.out.println(machineContents[0] + " ml of water");
        System.out.println(machineContents[1] + " ml of milk");
        System.out.println(machineContents[2] + " g of coffee beans");
        System.out.println(machineContents[3] + " disposable cups");
        System.out.println("$" + machineContents[4] + " of money");
    }
}
