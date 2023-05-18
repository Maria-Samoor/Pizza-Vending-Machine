package pizzamachine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JOptionPane;

public class Pizza {

    private Dough dough;
    private Pan pan;
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    private int pizzaSize;
    private String pizzaType;
    private int numOfSlices;
    private double totalWeight;
    private double totalCalories;

    public Pizza(String doughType, int pizzaSize, String pizzaType) {
        setPizzaSize(pizzaSize);
        setDough(doughType);
        setPan(new Pan(pizzaSize));
        setPizzaType(pizzaType);
        setIngredients();
        setNumOfSlices();
        setTotalWeight();
        setTotalCalories();
        log.log(getInfoForStoarage());
        suggestedPizza();
    }

    public Pizza(String doughType, int pizzaSize, String pizzaType, String[] ingredientsNames) {
        setPizzaSize(pizzaSize);
        setDough(doughType);
        setPan(new Pan(pizzaSize));
        setPizzaType(pizzaType);
        setIngredients(ingredientsNames);
        setNumOfSlices();
        setTotalWeight();
        setTotalCalories();
        log.log(getInfoForStoarage());
        suggestedPizza();
    }
    Logger log = new Logger() {
        @Override
        public void log(String str) {
            try {
                FileWriter file;
                file = new FileWriter(new File("Pizza.txt"), true);
                try (PrintWriter pw = new PrintWriter(file)) {
                    pw.println(str);
                }
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Pizza.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    public Dough getDough() {
        return dough;
    }

    public void setDough(String doughType) {
        int x = 0;
        try {
            this.dough = Mixer.pizzaDough(doughType, getPizzaSize());
        } catch (AmountOdDoughInMixerException ex) {
            log.log(doughType.toUpperCase() + ex.getMessage());

          x= JOptionPane.showConfirmDialog(null, doughType.toUpperCase() + ex.getMessageForUser() + " If You Want To Modify Your Order With Another Type Of Dough", "Dough",  JOptionPane.YES_NO_OPTION);
            if (x == 0) {
                try {
                    if (doughType.equalsIgnoreCase("pan")) {
                        this.dough = Mixer.pizzaDough("deep dish", getPizzaSize());
                    } else {
                        this.dough = Mixer.pizzaDough("pan", pizzaSize);
                    }
                } catch (AmountOdDoughInMixerException e) {
                    log.log(e.getMessage() + ", So The Machine Will Stop Warking Suddenly.");
                    JOptionPane.showMessageDialog(null, "Sorry For Inform You That " + e.getMessage() + "\nWe Will ReFill It.Try Again Later.");
                    System.exit(0);
                }

            } else {
                log.log(ex.getMessage() + ". And The User Decided Not To Complete, So The Machine Will Stop Warking Suddenly.");
                System.exit(0);
            }
        }
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getInfoforAllIngerdients() {
        String Ingredient = "";
        for (Ingredient R : ingredients) {
            Ingredient += R.getInfo() + "\n";
        }
        return "[" + Ingredient + "]";

    }

    public void setIngredients() {
        int size = getPizzaSize();
        String str = getPizzaType();
        try {
            if (str.equalsIgnoreCase("Vegetarian")) {
                ingredients.add(new Ingredient("pizza sauce", size));
                ingredients.add(new Ingredient("mozzarella cheese", size));
                ingredients.add(new Ingredient("tomato", size));
                ingredients.add(new Ingredient("mashroom", size));
                ingredients.add(new Ingredient("black olive", size));
                ingredients.add(new Ingredient("corn", size));
                ingredients.add(new Ingredient("pepper", size));
                ingredients.add(new Ingredient("oregano", size));
            } else if (str.equalsIgnoreCase("Pepperoni")) {
                ingredients.add(new Ingredient("pepperoni", size));
                ingredients.add(new Ingredient("mozzarella cheese", size));
                ingredients.add(new Ingredient("pizza sauce", size));
                ingredients.add(new Ingredient("tomato", size));
                ingredients.add(new Ingredient("oregano", size));
                ingredients.add(new Ingredient("chili", size));
            } else if (str.equalsIgnoreCase("BBQ Chicken")) {
                ingredients.add(new Ingredient("barbecue sauce", size));
                ingredients.add(new Ingredient("mozzarella cheese", size));
                ingredients.add(new Ingredient("chicken", size));
                ingredients.add(new Ingredient("chili", size));
                ingredients.add(new Ingredient("oregano", size));
            }
        } catch (StorageSpaceException ex) {
            int x=0;
            if (str.equalsIgnoreCase("Vegetarian")) {
                log.log("Failed To Make " + str + " Pizza Because An Ingredient " + ex.getMessage());
                try{
                x = Integer.parseInt(JOptionPane.showInputDialog("One Of The Main Ingrediants " + ex.getMessage() + "Choose Another Pizza Type \n1-Pepperoni    2-BBQ Chicken    3-Exit:"));
                }catch(NumberFormatException e){}
                switch (x) {
                    case 1:
                        setPizzaType("Pepperoni");
                        ingredients.clear();
                        setIngredients();
                        break;
                    case 2:
                        setPizzaType("BBQ Chicken");
                        ingredients.clear();
                        setIngredients();
                        break;
                    default:
                        log.log("An Ingredient" + ex.getMessage() + ". And The User Decided Not To Complete, So The Machine Will Stop Warking Suddenly.");
                        System.exit(0);
                }
            } else if (str.equalsIgnoreCase("Pepperoni")) {
                log.log("Failed To Make " + str + " Pizza Because An Ingredient " + ex.getMessage());
               try{
                   x = Integer.parseInt(JOptionPane.showInputDialog("One Of The Main Ingrediants " + ex.getMessage() + "Choose Another Pizza Type \n1-Vegetarian    2-BBQ Chicken     3-Exit:"));
               }catch(NumberFormatException e){}
                switch (x) {
                    case 1:
                        setPizzaType("Vegetarian");
                        ingredients.clear();
                        setIngredients();
                        break;
                    case 2:
                        setPizzaType("BBQ Chicken");
                        ingredients.clear();
                        setIngredients();
                        break;
                    default:
                        log.log("An Ingredient" + ex.getMessage() + ". And The User Decided Not To Complete, So The Machine Will Stop Warking Suddenly.");
                        System.exit(0);
                }
            } else {
                log.log("Failed To Make " + str + " Pizza Because An Ingredient " + ex.getMessage());
                try{
                    x = Integer.parseInt(JOptionPane.showInputDialog("One Of The Main Ingrediants " + ex.getMessage() + "Choose Another Pizza Type \n1-Pepperoni     2-Vegetarian       3-Exit:"));
                }catch(NumberFormatException e){}
                switch (x) {
                    case 1:
                        setPizzaType("Pepperoni");
                        ingredients.clear();
                        setIngredients();
                        break;
                    case 2:
                        setPizzaType("Vegetarian");
                        ingredients.clear();
                        setIngredients();
                        break;
                    default:
                        log.log("An Ingredient" + ex.getMessage() + ". And The User Decided Not To Complete, So The Machine Will Stop Warking Suddenly.");
                        System.exit(0);
                }
            }
        }
    }

    public void setIngredients(String[] ingredientsNames) {
        int ingNum = 0;
        int size = getPizzaSize();
        String str = getPizzaType();
        try {
            for (int i = 0; i < ingredientsNames.length; ++i) {
                try {
                    ingredients.add(new Ingredient(ingredientsNames[i], size));
                    ingNum++;
                } catch (NullPointerException e) {
                    break;
                }
            }

        } catch (StorageSpaceException ex) {

            log.log("Failed To Make " + str + " Pizza Because " + ingredientsNames[ingNum] + ex.getMessage());
            ingredientsNames[ingNum] = (JOptionPane.showInputDialog(ingredientsNames[ingNum].toUpperCase() + ex.getMessage() + "\nPlease Enter The Name Another ingrediant:\n"
                    + "1.Pizza Sauce                 4.Chicken          7.Pepper          10.Corn       13.Tomato  "
                    + "\n2.Barbecue Sauce         5.Pepperoni       8.Oregano       11.Onion    14.Garlic  "
                    + "\n3.Mozzarella Cheese     6.Black Olive    9.Mashroom    12.Chili"));
            ingredients.clear();
            setIngredients(ingredientsNames);
        }
    }

    public Pan getPan() {
        return pan;
    }

    public void setPan(Pan pan) {
        this.pan = pan;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public int getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(int pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public int getNumOfSlices() {
        return numOfSlices;
    }

    public void setNumOfSlices() {
        switch (getPizzaSize()) {
            case 1:
                numOfSlices = 4;
                break;
            case 2:
                numOfSlices = 6;
                break;
            case 3:
                numOfSlices = 8;
                break;

        }
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories() {
        for (Ingredient e : ingredients) {
            this.totalCalories += e.getCalories();
        }
        this.totalCalories += dough.getDoughCaloreies();
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight() {
        int counter = 0;
        this.totalWeight += dough.getDoughWeight();
        try {
            for (Ingredient e : ingredients) {
                pan.cheackPanCapacity(totalWeight + e.getWeight());
                this.totalWeight += e.getWeight();
                counter++;
            }
        } catch (PanCapacityException e) {
            String str = "  ";
            for (int i = counter; i < ingredients.size(); i++) {
                str += ingredients.get(i).getName() + ", ";
            }
            for(int i = counter; i < ingredients.size(); i++){
                ingredients.remove(i);
            }
            JOptionPane.showMessageDialog(null, "The Following Ingredients[" + str.substring(0, str.length() - 2) + "]Are Not Added Because " + e.getMessageForUser());
            log.log(e.getMessage());
        }

    }

    public String getInfoForStoarage() {
        return "A Pizza Has Been Made \nIt's " + this.dough.getInfo() + "\ningredients:\n" + getInfoforAllIngerdients() + "\n" + this.pan.getInfo() + ", Pizza Type: " + pizzaType + ", Number Of Slices=" + numOfSlices + ", Total Amount Of Calories=" + totalCalories + ", Calories per Slice:" + (this.totalCalories / this.numOfSlices) + ",Total Weight=" + this.totalWeight + " gm";
    }

    public String getInfo() {
        return "Pizza Type: " + pizzaType + ", Number Of Slices=" + numOfSlices + ", Total Amount Of Calories=" + totalCalories + ", Calories per Slice:" + (this.totalCalories / this.numOfSlices) + ",Total Weight=" + this.totalWeight + " gm\n\n";
    }
    public void suggestedPizza(){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("PizzaStorage.txt"));
            writer.write(pizzaType);
            writer.write("\n"+dough.getDoughType());
            writer.write("\n"+pizzaSize);
            for(int i =0;i<ingredients.size();i++)
                writer.write("\n"+ingredients.get(i).getName());
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Pizza.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Pizza.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }

}
