package net.nrmmo.core.error.http;

import org.springframework.http.HttpStatus;

/**
 * Ошибка возникающая при валидации данных, к примеру существует ли пользователь
 */
public class UnprocessableEntityHttpException extends AbstractHttpException {

    public UnprocessableEntityHttpException(String message) {
        super(message);
    }

    public UnprocessableEntityHttpException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
