
package pizzamachine;

public class StorageSpaceException extends Exception {

    @Override
    public String getMessage() {
        return " Is Out Of Stock";
    }
    public String getMessageForDough() {
        return "A Mulfuction Occurred.Try Later";
    }
    
}
