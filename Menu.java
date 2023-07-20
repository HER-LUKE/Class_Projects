/** 
 * This code creates the Dessert Items array and passes items into it
 * 
 * @author Luke Herron 
 * 
 * 
*/


import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<DessertItem> dessertItems;  //creates array variable for dessert items
    private Scanner scanner;

    public Menu(){
        dessertItems = new ArrayList<>(); //creates array
        scanner = new Scanner(System.in);
    }
    public void displayMenu(){  //displays menu 
        int x = 0;
        while (x < 1){ //keeps menu open until user "quits"
        int answer = 0;
        System.out.println("Actions: ");
        System.out.println("1) Add a pie dessert");
        System.out.println("2) Add a cake dessert");
        System.out.println("3) Add an ice cream treat dessert");
        System.out.println("4) Display an item");
        System.out.println("5) Display all items");
        System.out.println("6) Add a topping to an item");
        System.out.println("9) Quit");
        while (answer != (1) && answer != (2) && answer != (3) && answer != (4) && answer != (5) && answer != (6) && answer != (9)) {
            System.out.print("Please chose from the above actions: ");
            answer = scanner.nextInt();
            if (answer != (1) && answer != (2) && answer != (3) && answer != (4) && answer != (5) && answer != (6) && answer != (9)) {
                System.out.println("Sorry, \"" + answer + "\" is not 1,2,3,4,5,6 or 9");
            }
        }

        if (answer == (1)) {
            addPie();
        } else if (answer == (2)) {
            addCake();
        } else if (answer == (3)) {
            addIceCream();
        } else if (answer == (4)) {
            displayItem();
        } else if (answer == (5)) {
            displayAllItems();
        } else if (answer == (6)) {
            addToppingToItem();
        } else if (answer == (9)) {
            x = 1;
        }
    }
    }
    public void addIceCream(){ // creates IceCream object
        System.out.print("Enter Ice Cream name: ");
        String name = scanner.next();
        System.out.println("You entered: " + name);
        double price; 
        do{ //ensures a valid price is inputted
            System.out.print("Enter Ice Cream price: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input! Please enter a valid number:   ");
                scanner.next(); // Clear the invalid input from the scanner buffer
            }
            price = scanner.nextDouble();
        } while (price <= 0); 
        System.out.println("Ice Cream price: " + price);
        String baseFlavor;
        do { //ensures a valid flavor is inputted
            System.out.print("Enter Ice Cream base Flavor (vanilla or chocolate): ");
            baseFlavor = scanner.next();

            if (baseFlavor.equalsIgnoreCase("vanilla") || baseFlavor.equalsIgnoreCase("chocolate")) {
                // Valid crust entered
                break;
            } else {
                System.out.println(baseFlavor + " is invalid. (vanilla or chocolate only)");
            }
        } while (true);
        System.out.println("You entered: " + baseFlavor );
        IceCream iceCream = new IceCream(name, price, baseFlavor); //creates icecream 
        dessertItems.add(iceCream); //passes icecream object into array

        System.out.println("Ice Cream added successfully!");
    }
    public void addPie(){ //creates pie
        System.out.print("Enter Pie name: ");
        String name = scanner.next();
        System.out.println("You entered: " + name );
        double price; 
        do{ //ensures price is valid
            System.out.print("Enter Pie price: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input! Please enter a valid number: ");
                scanner.next(); // Clear the invalid input from the scanner buffer
            }
            price = scanner.nextDouble();
        } while (price <= 0); 
        System.out.println("Pie price: " + price);
        String crust;
        do { //ensures crust is valid
            System.out.print("Enter Pie crust (standard, spice, or chocolate): ");
            crust = scanner.next();

            if (crust.equalsIgnoreCase("standard") || crust.equalsIgnoreCase("spice") || crust.equalsIgnoreCase("chocolate")) {
                // Valid crust entered
                break;
            } else {
                System.out.println(crust + " is invalid. (standard, spice, or chocolate only)");
            }
        } while (true);
        System.out.println("You entered: " + crust );

        PieDessert pie = new PieDessert(name, price, crust); //creates pie object
        dessertItems.add(pie); //passes pie to the array

        System.out.println("Pie added successfully!");
    }
    public void addCake(){ //creates cake
        System.out.print("Enter Cake name: ");
        String name = scanner.next();
        System.out.println("You entered: " + name);
        double price; 
        do{ //ensures price is valid
            System.out.print("Enter Cake price: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input! Please enter a valid number: ");
                scanner.next(); // Clear the invalid input from the scanner buffer
            }
            price = scanner.nextDouble();
        } while (price <= 0); 
        System.out.println("Cake price: " + price);
        String frosting;
        do { //ensures frosting is valid
            System.out.print("Enter Cake frosting (buttercream, whipped, or chocolate): ");
            frosting = scanner.next();

            if (frosting.equalsIgnoreCase("buttercream") || frosting.equalsIgnoreCase("whipped") || frosting.equalsIgnoreCase("chocolate")) {
                // Valid frosting entered
                break;
            } else {
                System.out.println(frosting + " is invalid. (buttercream, whipped, or chocolate only)");
            }
        } while (true);
        System.out.println("You entered: " + frosting );
        CakeDessert cake = new CakeDessert(name, price, frosting); //creates cake object
        dessertItems.add(cake); //passes cake to array list

        System.out.println("Cake added successfully!");
    }
    public void displayItem(){ //displays item
        System.out.print("Enter dessert item name to display: ");
        String name = scanner.next();

        boolean found = false;
        for (DessertItem item : dessertItems) {
            if (item.getName().equalsIgnoreCase(name)) { //looks for object in array
                item.displayItem();
                found = true;
                break;
            }
        }

        if (!found) { //goes back to menu 
            System.out.println("Dessert item not found!");
            System.out.println("Enter a valid name");
        }
    }    
    public void displayAllItems(){ //displays all objects in array
        if (dessertItems.isEmpty()) { //if array is empty, return to menu
            System.out.println("Menu is empty!");
        } else {
            for (DessertItem item : dessertItems) {
                item.displayItem();
                System.out.println();
            }
        }
    }
    public void addToppingToItem(){  //add topping to item
        System.out.print("Enter dessert item name to add topping: ");
        String name = scanner.next();

        boolean found = false;
        for (DessertItem item : dessertItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                if (item instanceof IceCream){  //checks to see object is an icecream object
                System.out.print("Enter topping to add: ");
                String topping = scanner.next();
                ((IceCream)item).addTopping(topping);
                found = true;
                break;
            } else if (item instanceof PieDessert){ //checks object if its a pie object
                System.out.print("Enter topping to add: ");
                String topping = scanner.next();
                ((PieDessert)item).addTopping(topping);
                found = true;
                break;
            } else if (item instanceof CakeDessert){ //checks if object is a cake object
                System.out.print("Enter topping to add: ");
                String topping = scanner.next();
                ((CakeDessert)item).addTopping(topping);
                found = true;
                break;
            }
        }
        }

        if (!found) {  //object not found, return to menu
            System.out.println("Dessert item not found!");
        } else { //if everything is sucessfull, print success message
            System.out.println("Topping added successfully!");
        }
        
    }
    public static void main(String[] args){  //start code
        Menu menu = new Menu(); //creates menu 
        menu.displayMenu(); //displays menu and runs program
    }
}
