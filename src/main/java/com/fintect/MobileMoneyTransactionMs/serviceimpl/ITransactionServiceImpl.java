package com.fintect.MobileMoneyTransactionMs.serviceimpl;

import com.fintect.MobileMoneyTransactionMs.config.Apipath;
import com.fintect.MobileMoneyTransactionMs.constants.AccountsConstants;
import com.fintect.MobileMoneyTransactionMs.dtos.request.InterBankRequest;
import com.fintect.MobileMoneyTransactionMs.dtos.request.IntraBankRequest;
import com.fintect.MobileMoneyTransactionMs.dtos.response.ResponseDto;
import com.fintect.MobileMoneyTransactionMs.exceptions.InsufficientAccountBalance;
import com.fintect.MobileMoneyTransactionMs.service.ITransactionService;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;


@Service
@AllArgsConstructor
public class ITransactionServiceImpl implements ITransactionService {


    @Autowired
    private  BalanceLeggerAccount balanceLeggerAccount ;

    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    private Apipath apipath ;
    @Override
    public ResponseDto processInterBankTransaction(InterBankRequest interBankRequest) {
        // call api to get source account balance
        BigDecimal balance = restTemplate.getForObject(apipath.getName().concat("api/v1/accounts/accountBalance").concat(interBankRequest.getSourceAccount()),BigDecimal.class);
        if(interBankRequest.getAmount().subtract(balance).equals(0.0)){
            throw new InsufficientAccountBalance("Insufficent account balance");
        }
       Map<String,String> destinationAccount  =   InterBankSettlement.findAndGetDestinationAccount() ;
        String accounts  = destinationAccount.get("accounts");
        JSONObject jsonObject  = new JSONObject(accounts) ;
        return null;
    }

    @Override
    public ResponseDto processIntraBankTransaction(IntraBankRequest intraBankRequest) {
        // call api to get source account balance
        BigDecimal balance = restTemplate.getForObject(apipath.getName().concat("api/v1/accounts/accountBalance").concat(intraBankRequest.getSourceAccount()),BigDecimal.class);
        if(intraBankRequest.getAmount().subtract(balance).equals(0.0)){
            throw new InsufficientAccountBalance("Insufficent account balance");
        }
        //debit and credit another internal customer
        BigDecimal beneficiaryAccountBalance = restTemplate.getForObject(apipath.getName().concat("api/v1/accounts/accountBalance").concat(intraBankRequest.getDestinationAccount()),BigDecimal.class);
        //take away  the money from sourceAccount
        BigDecimal remainingBalance = balance.subtract(intraBankRequest.getAmount()) ;
        // use remainingBalance to update customer account on coreBanking
        //credit beneficaryAccount
        BigDecimal credit = beneficiaryAccountBalance.add(intraBankRequest.getAmount());
        //use credit to update beneficary account
        //balance up the legdger
        //balanceLeggerAccount.setLedgerBalance();
        ResponseDto responseDto  = new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200);
        return responseDto;
    }
}


