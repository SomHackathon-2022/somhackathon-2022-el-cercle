package cat.tecnocampus.elcercle.application.exception;

public class ProducteNotFoundException extends RuntimeException{
    public ProducteNotFoundException(String id)  {
        super("El producte amb id " + id + " no existeix.");
    }
}
