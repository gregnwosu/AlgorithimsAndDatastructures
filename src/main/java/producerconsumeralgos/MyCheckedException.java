package producerconsumeralgos;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 21/02/13
 * Time: 14:06
 * To change this template use File | Settings | File Templates.
 */
public class MyCheckedException extends Exception {

    public MyCheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
