package com.fintect.MobileMoneyTransactionMs.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InsufficientAccountBalance extends RuntimeException{

    public InsufficientAccountBalance(String message) {
        super(message);
    }
}
