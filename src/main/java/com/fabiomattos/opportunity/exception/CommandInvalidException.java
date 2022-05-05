package com.fabiomattos.opportunity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Comando Inválido!")
public class CommandInvalidException extends Exception {

    public CommandInvalidException() {
    }
}