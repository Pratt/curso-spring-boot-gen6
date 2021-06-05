package cl.mgarcia.backend.exception;

public class ModeloNotFoundException extends RuntimeException {

    public ModeloNotFoundException(String message) {
        super(message);
    }
}
