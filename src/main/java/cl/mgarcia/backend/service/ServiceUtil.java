package cl.mgarcia.backend.service;

import cl.mgarcia.backend.model.Aduana;

import javax.validation.*;
import java.util.Set;

public class ServiceUtil {

    public static <T> void validarModelo(T t) throws ConstraintViolationException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(t);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
