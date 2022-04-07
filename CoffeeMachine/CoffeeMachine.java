import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int basicWater = 400;
        int basicMilk = 540;
        int basicBeans = 120;
        int basicCups = 9;
        int basicMoney = 550;

        int requiredWaterForEspresso = 250;
        int requiredMilkForEspresso = 0;
        int requiredBeansForEspresso = 16;
        int requiredMoneyForEspresso = 4;
        
        int requiredWaterForLatte = 350;
        int requiredMilkForLatte = 75;
        int requiredBeansForLatte = 20;
        int requiredMoneyForLatte = 7;
        
        int requiredWaterForCappuccino = 200;
        int requiredMilkForCappuccino = 100;
        int requiredBeansForCappuccino = 12;
        int requiredMoneyForCappuccino = 6;

        int add = 0;

        System.out.println("The coffee machine has:");
        System.out.println(basicWater + " of water");
        System.out.println(basicMilk + " of milk");
        System.out.println(basicBeans + " of coffee beans");
        System.out.println(basicCups + " of disposable cups");
        System.out.println(basicMoney + " of money");
        System.out.println();
        System.out.println("Write action (buy, fill, take):");

        String action = scanner.next();

        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                int option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            basicWater -= requiredWaterForEspresso;
                            basicMilk -= requiredMilkForEspresso;
                            basicBeans -= requiredBeansForEspresso;
                            basicCups -= 1;
                            basicMoney += requiredMoneyForEspresso;
                            System.out.println("The coffee machine has:");
                            System.out.println(basicWater + " of water");
                            System.out.println(basicMilk + " of milk");
                            System.out.println(basicBeans + " of coffee beans");
                            System.out.println(basicCups + " of disposable cups");
                            System.out.println(basicMoney + " of money");
                            break;
                        case 2: 
                            basicWater -= requiredWaterForLatte;
                            basicMilk -= requiredMilkForLatte;
                            basicBeans -= requiredBeansForLatte;
                            basicCups -= 1;
                            basicMoney += requiredMoneyForLatte;
                            System.out.println("The coffee machine has:");
                            System.out.println(basicWater + " of water");
                            System.out.println(basicMilk + " of milk");
                            System.out.println(basicBeans + " of coffee beans");
                            System.out.println(basicCups + " of disposable cups");
                            System.out.println(basicMoney + " of money");
                            break;
                        case 3:
                            basicWater -= requiredWaterForCappuccino;
                            basicMilk -= requiredMilkForCappuccino;
                            basicBeans -= requiredBeansForCappuccino;
                            basicCups -= 1;
                            basicMoney += requiredMoneyForCappuccino;
                            System.out.println("The coffee machine has:");
                            System.out.println(basicWater + " of water");
                            System.out.println(basicMilk + " of milk");
                            System.out.println(basicBeans + " of coffee beans");
                            System.out.println(basicCups + " of disposable cups");
                            System.out.println(basicMoney + " of money");
                            break;
                    }
                break;

            case "fill":
                System.out.println("Write how many ml of water do you want to add:");
                add = scanner.nextInt();
                basicWater += add;
                System.out.println("Write how many ml of milk do you want to add:");
                add = scanner.nextInt();
                basicMilk += add;
                System.out.println("Write how many grams of coffee beans do you want to add:"); 
                add = scanner.nextInt();
                basicBeans += add;
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                add = scanner.nextInt();
                basicCups += add;
                System.out.println("The coffee machine has:");
                System.out.println(basicWater + " of water");
                System.out.println(basicMilk + " of milk");
                System.out.println(basicBeans + " of coffee beans");
                System.out.println(basicCups + " of disposable cups");
                System.out.println(basicMoney + " of money");
                break;
                
            case "take":
                System.out.println("I gave you $" + basicMoney);
                basicMoney = 0;
                System.out.println("The coffee machine has:");
                System.out.println(basicWater + " of water");
                System.out.println(basicMilk + " of milk");
                System.out.println(basicBeans + " of coffee beans");
                System.out.println(basicCups + " of disposable cups");
                System.out.println(basicMoney + " of money");
                break;
        }
    }
}
