package cat.tecnocampus.elcercle.application.exception;

public class ActionNonPermitedException extends RuntimeException{
    public ActionNonPermitedException()  {
        super("Acció no permesa");
    }
}
