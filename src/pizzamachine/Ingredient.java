package pizzamachine;

public class Ingredient {

    private String name;
    private double calories;
    private double weight;

    public Ingredient(String name, double pizzasize) throws StorageSpaceException {
        setName(name);
        setWeight(pizzasize);
        setCalories();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories() {
        switch (this.name) {
            case "tomato":
                this.calories = (this.weight * 22) / 100;
                break;
            case "garlic":
                this.calories = (this.weight * 149) / 100;
                break;
            case "onion":
                this.calories = (this.weight * 40) / 100;
                break;
            case "pizza sauce":
                this.calories = (this.weight * 46) / 100;
                break;
            case "oregano":
                this.calories = (this.weight * 306) / 100;
                break;
            case "mozzarella cheese":
                this.calories = (this.weight * 280) / 100;
                break;
            case "salt":
                this.calories = 0;
                break;
            case "flour":
                this.calories = (this.weight * 728) / 100;
                break;
            case "yeast":
                this.calories = (this.weight * 105) / 100;
                break;
            case "olive oil":
                this.calories = (this.weight * 884) / 100;
                break;
            case "butter":
                this.calories = (this.weight * 717) / 100;
                break;
            case "active yeast":
                this.calories = (this.weight * 295) / 100;
                break;
            case "pepper":
                this.calories = (this.weight * 40) / 100;
                break;
            case "corn":
                this.calories = (this.weight * 86) / 100;
                break;
            case "chicken":
                this.calories = (this.weight * 239) / 100;
                break;
            case "barbecue sauce":
                this.calories = (this.weight * 172) / 100;
                break;
            case "pepperoni":
                this.calories = (this.weight * 494) / 100;
                break;
            case "chili":
                this.calories = (this.weight * 40) / 100;
                break;
            case "black olive":
                this.calories = (this.weight * 105) / 100;
                break;
            case "mushroom":
                this.calories = (this.weight * 22) / 100;
                break;
            case "water":
                this.calories = 0;
                break;

            default:
                break;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double pizzaSize) throws StorageSpaceException {
        switch (this.name) {
            case "tomato":
                if (StorageSpace.getTotalTomato() >= 100 * pizzaSize) {
                    this.weight = 100 * pizzaSize;
                    StorageSpace.setTotalTomato(StorageSpace.getTotalTomato() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "garlic":
                if (StorageSpace.getTotalGarlic() >= 10 * pizzaSize) {
                    this.weight = 10 * pizzaSize;
                    StorageSpace.setTotalGarlic(StorageSpace.getTotalGarlic() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "onion":
                if (StorageSpace.getTotalOnion() >= 28.75 * pizzaSize) {
                    this.weight = 28.75 * pizzaSize;
                    StorageSpace.setTotalOnion(StorageSpace.getTotalOnion() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "pizza sauce":
                if (StorageSpace.getTotalPizzaSaous() >= 100 * pizzaSize) {
                    this.weight = 100 * pizzaSize;
                    StorageSpace.setTotalPizzaSaous(StorageSpace.getTotalPizzaSaous() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "oregano":
                if (StorageSpace.getTotalOregano() >= 10 * pizzaSize) {
                    this.weight = 10 * pizzaSize;
                    StorageSpace.setTotalOregano(StorageSpace.getTotalOregano() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "mozzarella cheese":
                if (StorageSpace.getTotalMozzarellaCheese() >= 100 * pizzaSize) {
                    this.weight = 100 * pizzaSize;
                    StorageSpace.setTotalMozzarellaCheese(StorageSpace.getTotalMozzarellaCheese() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "salt":
                if (StorageSpace.getTotalSalt() >= 10 * pizzaSize) {
                    this.weight = 10 * pizzaSize;
                    StorageSpace.setTotalSalt(StorageSpace.getTotalSalt() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "flour":
                if (StorageSpace.getTotalFlour() >= 200 * pizzaSize) {
                    this.weight = 200 * pizzaSize;
                    StorageSpace.setTotalFlour(StorageSpace.getTotalFlour() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "yeast":
                if (StorageSpace.getTotalYeast() >= 1.420 * pizzaSize) {
                    this.weight = 1.420 * pizzaSize;
                    StorageSpace.setTotalYeast(StorageSpace.getTotalYeast() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "olive oil":
                if (StorageSpace.getTotalOliveOil() >= 1.430 * pizzaSize) {
                    this.weight = 1.430 * pizzaSize;
                    StorageSpace.setTotalOliveOil(StorageSpace.getTotalOliveOil() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "butter":
                if (StorageSpace.getTotalButter() >= 2.830 * pizzaSize) {
                    this.weight = 2.830 * pizzaSize;
                    StorageSpace.setTotalButter(StorageSpace.getTotalButter() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "active yeast":
                if (StorageSpace.getTotalActiveYeast() >= 2.845 * pizzaSize) {
                    this.weight = 2.845 * pizzaSize;
                    StorageSpace.setTotalActiveYeast(StorageSpace.getTotalActiveYeast() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "pepper":
                if (StorageSpace.getTotalPepper() >= 30.00 * pizzaSize) {
                    this.weight = 30.00 * pizzaSize;
                    StorageSpace.setTotalPepper(StorageSpace.getTotalPepper() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "corn":
                if (StorageSpace.getTotalCorn() >= 40.00 * pizzaSize) {
                    this.weight = 40.00 * pizzaSize;
                    StorageSpace.setTotalCorn(StorageSpace.getTotalCorn() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "chicken":
                if (StorageSpace.getTotalChicken() >= 70.00 * pizzaSize) {
                    this.weight = 70.00 * pizzaSize;
                    StorageSpace.setTotalChicken(StorageSpace.getTotalChicken() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "barbecue sauce":
                if (StorageSpace.getTotalBarbecueSauce() >= 100 * pizzaSize) {
                    this.weight = 100 * pizzaSize;
                    StorageSpace.setTotalBarbecueSauce(StorageSpace.getTotalBarbecueSauce() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "pepperoni":
                if (StorageSpace.getTotalPepperoni() >= 70.00 * pizzaSize) {
                    this.weight = 70.00 * pizzaSize;
                    StorageSpace.setTotalPepperoni(StorageSpace.getTotalPepperoni() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "chili":

                if (StorageSpace.getTotalChili() >= 15.00 * pizzaSize) {
                    this.weight = 15.00 * pizzaSize;
                    StorageSpace.setTotalChili(StorageSpace.getTotalChili() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }

                break;
            case "black olive":

                if (StorageSpace.getTotalBlackOlive() >= 15.00 * pizzaSize) {
                    this.weight = 15.00 * pizzaSize;
                    StorageSpace.setTotalBlackOlive(StorageSpace.getTotalBlackOlive() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }

                break;
            case "mashroom":
                if (StorageSpace.getTotalMushrooms() >= 30 * pizzaSize) {
                    this.weight = 30 * pizzaSize;
                    StorageSpace.setTotalMushrooms(StorageSpace.getTotalMushrooms() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;
            case "water":
                if (StorageSpace.getTotalWater() >= 140 * pizzaSize) {
                    this.weight = 140 * pizzaSize;
                    StorageSpace.setTotalWater(StorageSpace.getTotalWater() - this.weight);
                } else {
                    throw new StorageSpaceException();
                }
                break;

            default:
                break;
        }
    }

    public String getInfo() {
        return "Ingrediant " + "Name=" + this.name + " ,calories=" + this.calories + ", and weight=" + this.weight;
    }
}
