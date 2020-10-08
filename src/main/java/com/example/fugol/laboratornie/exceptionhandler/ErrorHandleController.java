package com.example.fugol.laboratornie.exceptionhandler;


import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@ControllerAdvice
public class ErrorHandleController {

    @RequestMapping("/errorMath")
    @ExceptionHandler({NumberFormatException.class})
    public String handleMathError(HttpServletRequest request, Exception e) {
        log.error(String.format("Client abort operation on %s \n %s", request.getRequestURI(), e));
        return "errorMath";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        log.error(String.format("User tried to access non-existing url %s", request.getRequestURI()));
        return "errorMath";
    }
}
