import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private boolean state;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        while (coffeeMachine.state) {
            coffeeMachine.menu();
        }
    }

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
        this.state = true;
    }

    void info() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = scanner.next();
        switch (action) {
            case "buy" -> buy();
            case "fill" -> fill();
            case "take" -> {
                System.out.println("I gave you $" + money);
                money = 0;
            }
            case "remaining" -> info();
            case "exit" -> state = false;
        }
    }

    void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choose = scanner.next();
        if (!choose.equals("back")) {
            int i = Integer.parseInt(choose);
            if (cups >= 1) {
                switch (i) {
                    case 1 -> makeEspresso();
                    case 2 -> makeLatte();
                    case 3 -> makeCappuccino();
                }
            } else System.out.println("Sorry, not enough cups!");
        }
    }

    void makeEspresso() {
        if (water >= 250) {
            if (beans >= 16) {
                System.out.println("I have enough resources, making you a coffee!");
                water -= 250;
                beans -= 16;
                money += 4;
                cups--;
            } else System.out.println("Sorry, not enough beans!");
        } else System.out.println("Sorry, not enough water!");
    }

    void makeLatte() {
        if (water >= 350) {
            if (milk >= 75) {
                if (beans >= 20) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    money += 7;
                    cups--;
                } else System.out.println("Sorry, not enough beans!");
            } else System.out.println("Sorry, not enough milk!");
        } else System.out.println("Sorry, not enough water!");
    }

    void makeCappuccino() {
        if (water >= 200) {
            if (milk >= 100) {
                if (beans >= 12) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    money += 6;
                    cups--;
                } else System.out.println("Sorry, not enough beans!");
            } else System.out.println("Sorry, not enough milk!");
        } else System.out.println("Sorry, not enough water!");
    }

    void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        cups += scanner.nextInt();
    }
}