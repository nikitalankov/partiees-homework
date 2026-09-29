package lk.tech.nikita15.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Наряд за тобой уже выехал")
public class PrisonAppleException extends RuntimeException {
    public PrisonAppleException() {

    }
}
