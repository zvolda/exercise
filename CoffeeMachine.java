package machine;
import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;
    static int money = 550;
    static int usedCups = 0;
    static String action;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        action = askAction();
        while (!action.equals("exit")) {
            switch (action) {
                case "buy" -> {
                    buy();
                }
                case "fill" -> {
                    fill();
                }
                case "take" -> {
                    take();
                }
                case "remaining" -> {
                    printState();
                }
                case "clean" -> {
                    cleaning();
                }
            }
            action = askAction();
        }

    }

    static String askAction(){
        System.out.println("Write action (buy, fill, take, clean, remaining, exit): ");
        String ac = scanner.next();
        return ac;
    }

    static void printState(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();

    }

    static void buy() {
        if (usedCups == 10) {
            System.out.println("I need cleaning!");
            return;
        }
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String option = scanner.next();
        switch (option){
            case "1" -> {
                verifyAndCalculateResources(250, 0, 16, 4);
            }
            case "2" -> {
                verifyAndCalculateResources(350, 75, 20, 7);
            }
            case "3" -> {
                verifyAndCalculateResources(200, 100, 12, 6);
            }
        }
    }

    static void cleaning() {
        usedCups = 0;
        System.out.println("I have been cleaned!");
    }

    static void verifyAndCalculateResources(int lwater,int lmilk, int lcoffee, int lmoney){
        if (water < lwater) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (milk < lmilk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (coffee < lcoffee) {
            System.out.println("Sorry, not enough coffee!");
            return;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
            return;
        }
        water -= lwater;
        milk -= lmilk;
        coffee -= lcoffee;
        money += lmoney;
        cups --;
        usedCups++;
        System.out.println("I have enough resources, making you a coffee!");
    }

    static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add::");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cups += scanner.nextInt();
    }

    static void take(){
        System.out.println("I gave you $" + money);
        money = 0;
    }
}