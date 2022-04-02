package cat.tecnocampus.elcercle.application.exception;

public class UsuariNotFoundException extends RuntimeException{
    public UsuariNotFoundException(String correu)  {
        super("L'usuari amb correu " + correu + " no existeix.");
    }
}
