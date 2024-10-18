package com.fintect.MobileMoneyTransactionMs.dtos.request;

import com.fintect.MobileMoneyTransactionMs.annotation.CustomBigDecimalConstraint;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;


@Schema(
        name = "InterBankRequest",
        description = "Schema to hold InterBankRequest information"
)
public class InterBankRequest {

    @NotEmpty(message = "sourceAccount cannot be empty")
    @Size(min = 10, max = 10, message = "sourceAccount must be 10 digits")
    @PositiveOrZero(message = "only positive digit are allowed")
    @Pattern(message = "only 10 digits are allowed",regexp = "^[\\d]{10}$")
    private String sourceAccount ;

    @NotEmpty(message = "destinationAccount cannot be empty")
    @Size(min = 10, max = 10, message = "destinationAccount must be 10 digits")
    @PositiveOrZero(message = "only positive digit are allowed")
    @Pattern(message = "only 10 digits are allowed",regexp = "^[\\d]{10}$")
    private String destinationAccount ;

    @NotEmpty(message = "bankcode cannot be empty")
    @Pattern(message = "only 5 digits are allowed",regexp = "^[\\d]{5}$")
    private String bankcode ;

    @NotEmpty(message = "destinationBankcode cannot be empty")
    @Pattern(message = "only 5 digits are allowed",regexp = "^[\\d]{5}$")
    private String destinationBankcode ;
    @NotEmpty(message = "narration cannot be empty")
    private String narration;

    @CustomBigDecimalConstraint(message = "amount cannot be empty")
    @DecimalMin(value = "1.0", inclusive = true,message = "Minimum amount exceeded/Must be a decimal")
    @DecimalMax(value = "1000000.0",message = "Maximum amount exceeded/Must be a decimal")
    private BigDecimal amount ;
    public String getSourceAccount() {
        return sourceAccount;
    }
    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public String getDestinationBankcode() {
        return destinationBankcode;
    }

    public void setDestinationBankcode(String destinationBankcode) {
        this.destinationBankcode = destinationBankcode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }
}
