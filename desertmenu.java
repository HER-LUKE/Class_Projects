/** 
 * This code manages the DessertMenu
 * 
 * @author Luke Herron 
 * 
 * 
*/


     
            abstract class DessertItem{
                protected String name;
                protected double price;
                public DessertItem(String name, double price){
                    this.name = name;
                    this.price = price;
                }
                public String getName(){
                    return name;
                }
                public double getPrice(){
                    return price;
                }
                public abstract void displayItem();
                }
            

            class IceCream extends DessertItem{
                private String baseIceCreamFlavor;
                private StringBuilder toppings;

                public IceCream(String name, double price, String baseIceCreamFlavor){
                    super(name,price);
                    this.baseIceCreamFlavor = baseIceCreamFlavor;
                    this.toppings = new StringBuilder();
                }
                public void addTopping(String topping){
                    if (toppings.length() > 0 ){
                        toppings.append(", ");
                    }
                    toppings.append(topping);

                }
                @Override
                public void displayItem(){
                    System.out.println("Ice Cream flavor: " + getName());
                    System.out.println("Price: $" + String.format("%.2f", getPrice()));
                    System.out.println("Base flavor: " + baseIceCreamFlavor);
                    System.out.println("Topping(s): " + toppings.toString());
                }
            }

            class CakeDessert extends DessertItem{
                private String frosting;
                private StringBuilder toppings;

                public CakeDessert(String name, double price, String frosting){
                    super(name,price);
                    this.frosting = frosting;
                    this.toppings = new StringBuilder();
                }
                public void addTopping(String topping){
                    if (toppings.length() > 0 ){
                        toppings.append(", ");
                    }
                    toppings.append(topping);
                }

                @Override
                public void displayItem(){
                    System.out.println("Cake: " + getName());
                    System.out.println("Price: $" + String.format("%.2f", getPrice()));
                    System.out.println("Frosting: " + frosting);
                    System.out.println("Topping(s): " + toppings.toString());
            }
        }
            class PieDessert extends DessertItem{
                String crust;
                private StringBuilder toppings;
                
                public PieDessert(String name, double price, String crust){
                super(name,price);
                this.crust = crust;
                this.toppings = new StringBuilder();
                }
                public void addTopping(String topping){
                    if (toppings.length() > 0 ){
                        toppings.append(", ");
                    }
                    toppings.append(topping);
                }
                @Override
                public void displayItem(){
                    System.out.println("Pie: " + getName());
                    System.out.println("Price: $" + String.format("%.2f", getPrice()));
                    System.out.println("crust: " + crust);
                    System.out.println("Topping(s): " + toppings.toString());
            }
        }
    

            
            