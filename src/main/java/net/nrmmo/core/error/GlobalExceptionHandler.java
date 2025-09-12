package net.nrmmo.core.error;

import lombok.extern.slf4j.Slf4j;
import net.nrmmo.core.error.http.AbstractHttpException;
import net.nrmmo.core.error.http.BadRequestHttpException;
import net.nrmmo.web.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AbstractHttpException.class)
    public ResponseEntity<ResponseDto> handleHttpException(AbstractHttpException ex) {
        if (ex.getHttpStatus() == INTERNAL_SERVER_ERROR) {
            log.error("{}", ex.getClass().getName(), ex);
        }
        return ResponseEntity.status(ex.getHttpStatus()).body(new ResponseDto(ex.getMessage()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestHttpException.class)
    public ResponseEntity<ResponseDto> handleBadRequestHttpExceptions(BadRequestHttpException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(new ResponseDto(ex.getMessage()));
    }
}
