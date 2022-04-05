import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stepsNecessaryToMakeCoffee = """
                                        Starting to make a coffee
                                        Grinding coffee beans
                                        Boiling water
                                        Mixing boiled water with crushed coffee beans
                                        Pouring coffee into the cup
                                        Pouring some milk into the cup
                                        Coffee is ready!""";
                                        
        System.out.println(stepsNecessaryToMakeCoffee);

        System.out.println("Write how many cups of coffee you will need:");
        
        int howManyCups = scanner.nextInt();
        
        int water = 200;
        int milk = 50;
        int beans = 15;
        
        System.out.println("For " + howManyCups + " cups of coffee you will need:");
        System.out.println(howManyCups * water + " ml of water");
        System.out.println(howManyCups * milk + " ml of milk");
        System.out.println(howManyCups * beans + " g of coffee beans");
    }
}
