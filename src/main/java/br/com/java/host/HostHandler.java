package br.com.java.host;

import br.com.java.application.exception.BusinessException;
import br.com.java.application.exception.NoContentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class HostHandler {

    @ExceptionHandler(BusinessException.class)
    public final ResponseEntity handle(final BusinessException ex, final WebRequest request) {
        return new ResponseEntity("Erro de negócio", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoContentException.class)
    public final ResponseEntity handle(final NoContentException ex, final WebRequest request) {
        return new ResponseEntity("Sem contêudo", HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity handle(final Exception ex, final WebRequest request) {
        return new ResponseEntity("Falha sistêmica", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}