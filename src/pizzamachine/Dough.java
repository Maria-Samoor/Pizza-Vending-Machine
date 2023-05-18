package pizzamachine;

public class Dough {

    private String doughType;
    private int doughSize;
    private double doughWeight;
    private double doughCaloreies;

    public Dough(String doughType, int doughSize, double doughWeight) {
        setDoughType(doughType);
        setDoughSize(doughSize);
        setDoughWeight(doughWeight);
        setDoughCaloreies();
    }

    public String getDoughType() {
        return doughType;
    }

    public void setDoughType(String doughType) {
        this.doughType = doughType;
    }

    public int getDoughSize() {
        return doughSize;
    }

    public void setDoughSize(int doughSize) {
        this.doughSize = doughSize;
    }

    public double getDoughWeight() {
        return doughWeight;
    }

    public void setDoughWeight(double doughWeight) {
        this.doughWeight = doughWeight;
    }

    public double getDoughCaloreies() {
        return doughCaloreies;
    }

    public void setDoughCaloreies() {
        if (this.doughType.equalsIgnoreCase("pan")) {
            this.doughCaloreies = (300 * this.doughWeight) / 200;
        } else {
            this.doughCaloreies = (390 * this.doughWeight) / 250;
        }
    }

    public String getInfo() {
        return "Dough" + " Type is :" + this.doughType + ",Size: " + this.doughSize + ",Weight: " + this.doughWeight + ",and Calories: " + this.doughCaloreies;
    }

}
