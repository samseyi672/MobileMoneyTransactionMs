package com.fintect.MobileMoneyTransactionMs.serviceimpl;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class BalanceLeggerAccount {
    private BigDecimal ledgerBalance = new BigDecimal(2_000_000);

    public BigDecimal getLedgerBalance() {
        return ledgerBalance;
    }

    public void setLedgerBalance(BigDecimal balance1) {
        this.ledgerBalance.add(balance1);
    }
}
