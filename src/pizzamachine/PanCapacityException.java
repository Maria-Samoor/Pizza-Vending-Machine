
package pizzamachine;

public class PanCapacityException extends Exception{
    
    public String getMessageForUser() {
        return "The Total Weight Will Exeed The Capacity Of The Pan.";
    }

    @Override
    public String getMessage() {
        return "The Total Weight Exeed The Capacity Of The Pan, An Ingredients Are Not Added.";
    }
    
}
