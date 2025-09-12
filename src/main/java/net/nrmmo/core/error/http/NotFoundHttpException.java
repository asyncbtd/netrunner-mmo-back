package net.nrmmo.core.error.http;

import org.springframework.http.HttpStatus;

public class NotFoundHttpException extends AbstractHttpException {

    public NotFoundHttpException(String message) {
        super(message);
    }

    public NotFoundHttpException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
