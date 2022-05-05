package com.fabiomattos.opportunity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Limite de área atingido!")
public class AreaLimitReachedException extends Exception {

    public AreaLimitReachedException() {
    }
}