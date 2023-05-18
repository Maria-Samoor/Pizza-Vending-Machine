
package pizzamachine;

public class AmountOdDoughInMixerException extends Exception {

    @Override
    public String getMessage() {
        return " Dough Amount In Mixer Is not Enough For Making a Pizza!!";
    }
    public String getMessageForUser() {
        return " Dough Is Not Available";
    }
    
            
}
