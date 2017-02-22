package exception;

/**
 * Class which throws an expection when unable to add new creator to database
 *
 * @author 
 * @version 1.0
 */
public class UnableAddCreatorException extends Exception {
    
    /**
     * version control of an object
     */
    private static final long serialVersionUID = 1L;

    /**
     * Get the information about error
     *
     * @return the message
     */
    @Override
    public String getMessage() {
        return "Error: Unable to add new creator information.";
    }
}
