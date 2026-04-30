package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int mlWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int mlMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int gCoffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int countOfCups = scanner.nextInt();
        int availableCount = 0;

        while ((mlWater/200.0 >= 1) && (mlMilk/50.0 >= 1) && (gCoffee/15.0 >= 1)) {
            mlWater -= 200;
            mlMilk -= 50;
            gCoffee -= 15;

            availableCount += 1;
        }


        if (availableCount == countOfCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            if (availableCount < countOfCups) {
                System.out.println("No, I can make only " + availableCount + " cup(s) of coffee");
            } else {
                int diff  = availableCount - countOfCups;
                System.out.println("Yes, I can make that amount of coffee (and even " + diff + " more than that)");
            }
        }

        //System.out.println("For " + count + " cups of coffee you will need:");
        //System.out.println((200 * count) + " ml of water");
        //System.out.println((50 * count) + " ml of milk");
        //System.out.println((15 * count) + " g of coffee beans");
    }
}