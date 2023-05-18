package pizzamachine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Pan {

    private double capacity;
    private int panSize;
    private static int[] pans = {1, 1, 2, 2, 3, 3};

    public Pan(int pizzaSize) {
        setPanSize(pizzaSize);
        setCapacity();
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity() {
        switch (this.panSize) {
            case 1:
                this.capacity = 600;
                break;
            case 2:
                this.capacity = 1500;
                break;
            case 3:
                this.capacity = 1800;
                break;
        }

    }

    public int getPanSize() {
        return panSize;
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
                ex.printStackTrace();
            }
        }
    };

    public void setPanSize(int pizzaSize) {
        switch (pizzaSize) {
            case 1: {
                for (int i = 0; i < pans.length; i++) {
                    if (pans[i] != 0) {
                        panSize = pans[i];
                        pans[i] = 0;
                        break;
                    } else {
                        panSize = 0;
                    }
                }
                break;
            }
            case 2: {
                for (int i = 2; i < pans.length; i++) {
                    if (pans[i] != 0) {
                        panSize = pans[i];
                        pans[i] = 0;
                        break;
                    } else {
                        panSize = 0;
                    }
                }
                break;
            }
            case 3: {
                for (int i = 4; i < pans.length; i++) {
                    if (pans[i] != 0) {
                        panSize = pans[i];
                        pans[i] = 0;
                        break;
                    } else {
                        panSize = 0;
                    }
                }
                break;
            }
            default:
                panSize = 0;
                break;
        }
        try {
            if (panSize < pizzaSize) {
                throw new PanSizeException();
            }
        } catch (PanSizeException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage()+"\n"+ ex.getMessageForUser());
            log.log(ex.getMessageForUser() + ", So The Machine Will Stop Warking Suddenly.");
            System.exit(0);
        }
    }

    public void cheackPanCapacity(double totalWeight) throws PanCapacityException {
        if (totalWeight > this.capacity) {
            throw new PanCapacityException();
        }
    }

    public String getInfo() {
        return "Pan " + "Capacity: " + this.capacity + ", and it's Size: " + this.panSize;
    }

}
