package pizzamachine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Mixer {

    private Ingredient[] panDoughIngredients;
    private static double weightOfPanMix;
    private Ingredient[] deepDishDoughIngredients;
    private static double weightOfDeepDishMix;

    public Mixer() {
        setPanDoughIngredients();
        setDeepDishDoughIngredients();
    }
    Logger log=new Logger() {
        @Override
        public void log(String str) {
            try {
                FileWriter file;
                file=new FileWriter(new File("Pizza.txt"),true);
                try (PrintWriter pw = new PrintWriter(file)) {
                    pw.println(str);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    };
    public void mix() {
        for (Ingredient e : panDoughIngredients) {
            weightOfPanMix = 200;//(10 * e.getWeight());
        }
        for (Ingredient ex : deepDishDoughIngredients) {
            weightOfDeepDishMix = 300;//(10 * ex.getWeight());
        }
    }

    public static Dough pizzaDough(String doughType, int doughSize) throws AmountOdDoughInMixerException {

        if (doughType.equals("pan")) {
            if (weightOfPanMix < 150 * doughSize) {
                throw new AmountOdDoughInMixerException();
            } else {
                weightOfPanMix -= 150 * doughSize;
                return new Dough("pan", doughSize, 150 * doughSize);
            }
        } else {
            if (weightOfDeepDishMix < 200 * doughSize) {
                throw new AmountOdDoughInMixerException();
            } else {
                weightOfDeepDishMix -= 200 * doughSize;
                return new Dough("deep dish", doughSize, 200 * doughSize);
            }
        }

    }

    public Ingredient[] getPanDoughIngredients() {

        return panDoughIngredients;
    }

    public void setPanDoughIngredients() {
        panDoughIngredients = new Ingredient[6];
        try {
            panDoughIngredients[0] = new Ingredient("salt", 3);
            panDoughIngredients[1] = new Ingredient("flour", 3);
            panDoughIngredients[2] = new Ingredient("yeast", 3);
            panDoughIngredients[3] = new Ingredient("olive oil", 3);
            panDoughIngredients[4] = new Ingredient("butter", 3);
            panDoughIngredients[5] = new Ingredient("water", 3);
        } catch (StorageSpaceException ex) {
            log.log("A Pan Dough Ingredient"+ex.getMessage()+ ", So The Machine Will Stop Warking Suddenly.");
            JOptionPane.showMessageDialog(null, ex.getMessageForDough());
            System.exit(0);
        }
    }

    public static double getWeightOfPanMix() {
        return weightOfPanMix;
    }

    public static void setWeightOfPanMix(double weightOfPanMix) {
        Mixer.weightOfPanMix = weightOfPanMix;
    }

    public Ingredient[] getDeepDishDoughIngredients() {
        return deepDishDoughIngredients;
    }

    public void setDeepDishDoughIngredients() {
        deepDishDoughIngredients = new Ingredient[5];
        try {
            deepDishDoughIngredients[0] = new Ingredient("salt", 3);
            deepDishDoughIngredients[1] = new Ingredient("flour", 3);
            deepDishDoughIngredients[2] = new Ingredient("active yeast", 3);
            deepDishDoughIngredients[3] = new Ingredient("olive oil", 3);
            deepDishDoughIngredients[4] = new Ingredient("water", 3);
        } catch (StorageSpaceException ex) {
            log.log("A Deep Dish Dough Ingredient"+ex.getMessage()+", So The Machine Will Stop Warking Suddenly.");
            JOptionPane.showMessageDialog(null, ex.getMessageForDough());
            System.exit(0);
        }
    }

    public static double getWeightOfDeepDishMix() {
        return weightOfDeepDishMix;
    }

    public static void setWeightOfDeepDishMix(double weightOfDeepDishMix) {
        Mixer.weightOfDeepDishMix = weightOfDeepDishMix;
    }

}
