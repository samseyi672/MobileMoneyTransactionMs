package com.fintect.MobileMoneyTransactionMs.service;

import com.fintect.MobileMoneyTransactionMs.dtos.request.InterBankRequest;
import com.fintect.MobileMoneyTransactionMs.dtos.request.IntraBankRequest;
import com.fintect.MobileMoneyTransactionMs.dtos.response.ResponseDto;

public interface ITransactionService {
    ResponseDto processInterBankTransaction(InterBankRequest interBankRequest) ;
    ResponseDto processIntraBankTransaction(IntraBankRequest interBankRequest) ;
}
