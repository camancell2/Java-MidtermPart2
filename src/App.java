import java.util.ArrayList;
import java.util.Scanner;

import Drink.Coffee;

import Drink.*;

public class App {
    private static ArrayList<Drink> menu = new ArrayList<Drink>();
    private static ArrayList<String> toppings = new ArrayList<String>();

    public static void ListMenu()
    {
        System.out.println("Menu Items:");
        for (int i = 0; i < menu.size(); i++) 
        {
            Drink drink = menu.get(i);
            System.out.println(drink.toString());
        }
    }

    public static void OrderDrink()
    {
        double orderTotal = 0.0f;

        ListMenu();

        Scanner reader = new Scanner(System.in);

        System.out.print("Please choose an item from our menu: ");

        String item = reader.nextLine();

        Drink drink = null;

        switch (item.toLowerCase())
        {
            case "coffee":
                drink = new Coffee();
                break;
            case "iced coffee":
            case "icedcoffee":
                drink = new IcedCoffee();
                break;
            case "tea":
                drink = new Tea();
                break;
            default:
                System.out.println("You choose an invalid item!");
                break;
        }

        if (drink != null) 
        {
            orderTotal += drink.GetValue();

            System.out.println("Added a " + drink.GetName() + " to cart.");
            System.out.println("You may add 3 toppings (25 cents each) else leave it blank");
            System.out.println("Options: Honey, Chocolate Syrup, Caramel Syrup, Vanilla Syrup, Coconut Milk, Whipped Cream, Cinnamon");
            System.out.println("Type 'done' if you don't want 3 toppings or less than 3");

            ArrayList<String> toppings = new ArrayList<String>();

            for (int i = 0; i <= 2; i++) {
                String topping = reader.nextLine();

                if (topping.equals("done"))
                {
                    break;
                }

                toppings.add(topping);
            }

            orderTotal += toppings.size() * 0.25;

            orderTotal += orderTotal * 0.07;
            orderTotal += orderTotal * 0.05;

            System.out.println(String.format("Order Total (/w tax): $%.2f", orderTotal));

            reader.close();
            
            return;
        }

        reader.close();
    }

    public static void main(String[] args) throws Exception {
        boolean running = true;

        Coffee coffee = new Coffee();
        IcedCoffee icedCoffee = new IcedCoffee();
        Tea tea = new Tea();

        menu.add(coffee);
        menu.add(icedCoffee);
        menu.add(tea);

        Scanner reader = new Scanner(System.in);

        while (running) {
            System.out.println("Coffee Order System 1.0");
            System.out.println("Please select an option: ");
            System.out.println("0. List Menu");
            System.out.println("1. Order a drink");
    
            int option = reader.nextInt();
    
            switch (option) {
                case 0:
                    ListMenu();
                    break;
                case 1:
                    OrderDrink();
                    running = false;
                    break;
            }
        }

        reader.close();
    }
}
