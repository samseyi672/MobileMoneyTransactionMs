package com.fintect.MobileMoneyTransactionMs.serviceimpl;


import com.fintect.MobileMoneyTransactionMs.utlis.AppUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class InterBankSettlement {

    private final static Map<String,String> destinationAccountStore = new ConcurrentHashMap<>() ;

    public static Map<String,String> findAndGetDestinationAccount() {  // in memory dummy destination account store
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("AccountName","Moses Samuel");
            jsonObject.put("AccountNumber",AppUtils.generateRequestID(10));
            jsonObject.put("AccountBalance",new BigDecimal(AppUtils.generateRequestID(5)));
            destinationAccountStore.put("accounts",jsonObject.toString());
           return destinationAccountStore ;
    }

}
