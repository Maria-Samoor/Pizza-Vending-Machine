
package pizzamachine;

public class PanSizeException extends Exception {

    @Override
    public String getMessage() {
        return "Pan Size Is Samller Than Pizza Size!!";
    }
    public String getMessageForUser() {
        return "A Mulfuction Occurred.Try Later";
    }
}
