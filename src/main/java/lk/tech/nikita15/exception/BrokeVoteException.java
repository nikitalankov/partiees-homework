package lk.tech.nikita15.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK, reason = "Твой голос ушел за ЕР")
public class BrokeVoteException extends RuntimeException {
    public BrokeVoteException() {

    }
}
