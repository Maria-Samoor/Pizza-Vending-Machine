package pizzamachine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PizzaMachine {

    public static void main(String[] args) {
        StorageSpace.setTotalTomato(10);
        StorageSpace.setTotalActiveYeast(2845);
        StorageSpace.setTotalBarbecueSauce(10000);
        StorageSpace.setTotalBlackOlive(1500);
        StorageSpace.setTotalButter(2830);
        StorageSpace.setTotalChili(1500);
        StorageSpace.setTotalChicken(7000);
        StorageSpace.setTotalCorn(4000);
        StorageSpace.setTotalFlour(20000);
        StorageSpace.setTotalGarlic(1000);
        StorageSpace.setTotalMozzarellaCheese(10000);
        StorageSpace.setTotalOliveOil(1430);
        StorageSpace.setTotalOnion(2875);
        StorageSpace.setTotalOregano(1000);
        StorageSpace.setTotalPepper(3000);
        StorageSpace.setTotalPepperoni(7000);
        StorageSpace.setTotalPizzaSaous(10000);
        StorageSpace.setTotalSalt(1000);
        StorageSpace.setTotalMushrooms(3000);
        StorageSpace.setTotalYeast(1420);
        StorageSpace.setTotalWater(10000);
        Mixer m = new Mixer();
        m.mix();
        String pizzaType, doughType;
        int pizzaSize, type = 0, choice, doughTypeInt = 0;
        String[] ingredientsNames;
        boolean flag;
        Scanner input = new Scanner(System.in);
        while (true) {
            pizzaType = null;
            doughType = null;
            pizzaSize = 0;
            ingredientsNames = null;
            flag = true;
            choice = JOptionPane.showConfirmDialog(null, "HI!\nIf You Want To Take The Suggested Pizza Click Yes", "SuggestedPizza", JOptionPane.YES_NO_OPTION);
            if (choice == 0) {
                try (BufferedReader reader = new BufferedReader(new FileReader("PizzaStorage.txt"))) {
                    String line;
                    for (int i = 0; (line = reader.readLine()) != null; i++) {
                        switch (i) {
                            case 0:
                                pizzaType = line;
                                if (pizzaType.equals("Make My Own Pizza")) {
                                    ingredientsNames = new String[8];
                                }
                                continue;
                            case 1:
                                doughType = line;
                                continue;
                            case 2:
                                pizzaSize = Integer.parseInt(line);
                                continue;
                            default:
                                if (pizzaType.equals("Vegetarian") || pizzaType.equalsIgnoreCase("Pepperoni") || pizzaType.equalsIgnoreCase("BBQ Chicken")) {
                                    break;
                                } else {
                                    ingredientsNames[i - 3] = line;
                                }
                        }
                    }
                } catch (IOException e) {
                    e.getMessage();
                }
            } else {

                while (flag) {
                    try {
                        type = Integer.parseInt(JOptionPane.showInputDialog("Enter Type Of Pizza You Want\n1-Vegetarian    2-Pepperoni    3-BBQ Chicken   4-Make My Own Pizza"));
                    } catch (NumberFormatException x) {
                        
                    }
                    switch (type) {
                        case 1: {
                            pizzaType = "Vegetarian";
                            flag = false;
                            break;
                        }

                        case 2: {
                            pizzaType = "Pepperoni";
                            flag = false;
                            break;
                        }

                        case 3: {
                            pizzaType = "BBQ Chicken";
                            flag = false;
                            break;
                        }

                        case 4: {
                            ingredientsNames = new String[8];
                            pizzaType = "Make My Own Pizza";
                            
                            int ingreientNum=0 ;
                            for (int i = 0; i < 8; ++i) {
                                try{
                                ingreientNum=Integer.parseInt(JOptionPane.showInputDialog("\nEnter The Ingredients You Want To Add:\n1.Chili\n2.Corn.\n3.Garlic\n4.Pepper\n5.Tomato"
                                        + "\n6.Chicken\n7.Pepperoni\n8.Oregano\n9.Onion\n10.Mushroom"
                                    + "\n11.Black Olive\n12.Pizza Sauce\n13.Barbecue Sauce\n14.Mozzarella Cheese\n15.Stop"));
                                
                                }catch(NumberFormatException ex){}
                                if (ingreientNum == 15) {
                                    break;
                                } else {
                                    switch (ingreientNum) {
                                        case 12:
                                            ingredientsNames[i] = "pizza sauce";
                                            break;
                                        case 13:
                                            ingredientsNames[i] = "barbecue sauce";
                                            break;
                                        case 14:
                                            ingredientsNames[i] = "mozzarella cheese";
                                            break;
                                        case 6:
                                            ingredientsNames[i] = "chicken";
                                            break;
                                        case 7:
                                            ingredientsNames[i] = "pepperoni";
                                            break;
                                        case 11:
                                            ingredientsNames[i] = "black olive";
                                            break;
                                        case 4:
                                            ingredientsNames[i] = "pepper";
                                            break;
                                        case 8:
                                            ingredientsNames[i] = "oregano";
                                            break;
                                        case 10:
                                            ingredientsNames[i] = "mushroom";
                                            break;
                                        case 2:
                                            ingredientsNames[i] = "corn";
                                            break;
                                        case 9:
                                            ingredientsNames[i] = "onion";
                                            break;
                                        case 1:
                                            ingredientsNames[i] = "chili";
                                            break;
                                        case 5:
                                            ingredientsNames[i] = "tomato";
                                            break;
                                        case 3:
                                            ingredientsNames[i] = "garlic";
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Invalid Entery,Try Again");
                                            i--;
                                            break;
                                    }
                                }
                            }
                            flag = false;
                            break;
                        }
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid Entery,Try Again");
                            
                            break;

                    }
                }

                while (!flag) {
                    try{
                    doughTypeInt = Integer.parseInt(JOptionPane.showInputDialog("Enter Type Of Dough You Want:\n1-Pan   2-Deep Dish"));
                    }catch(NumberFormatException x){}
                    switch (doughTypeInt) {
                        case 1:
                            doughType = "pan";
                            flag = true;
                            break;
                        case 2:
                            doughType = "deep dish";
                            flag = true;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid Entery,Try Again");
                            break;
                    }
                }
                while (flag) {
                    try{
                    pizzaSize = Integer.parseInt(JOptionPane.showInputDialog("Enter Size Of Pizza You Want:\n1-Small   2-Medium   3-Large"));
                    }catch(NumberFormatException x){}                
                    switch (pizzaSize) {
                        case 1:
                        case 2:
                        case 3:
                            flag = false;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid Entery,Try Again");
                            break;
                    }
                }
            }
            Pizza p1;
            if (ingredientsNames != null) {
                p1 = new Pizza(doughType, pizzaSize, pizzaType, ingredientsNames);
            } else {
                p1 = new Pizza(doughType, pizzaSize, pizzaType);
            }
            JOptionPane.showMessageDialog(null, "Your Order Is Ready\n" + p1.getInfo());
            System.out.println("\n\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PizzaMachine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
