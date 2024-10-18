package com.fintect.MobileMoneyTransactionMs.controllers;


import com.fintect.MobileMoneyTransactionMs.config.Apipath;
import com.fintect.MobileMoneyTransactionMs.constants.AccountsConstants;
import com.fintect.MobileMoneyTransactionMs.dtos.request.InterBankRequest;
import com.fintect.MobileMoneyTransactionMs.dtos.request.IntraBankRequest;
import com.fintect.MobileMoneyTransactionMs.dtos.response.ErrorResponseDto;
import com.fintect.MobileMoneyTransactionMs.dtos.response.ResponseDto;
import com.fintect.MobileMoneyTransactionMs.exceptions.InsufficientAccountBalance;
import com.fintect.MobileMoneyTransactionMs.service.ITransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;


@Tag(
        name = "CRUD REST APIs for Transaction in MobileMoney",
        description = "CRUD REST APIs in MobileMOney to process both interBank and Intrabank transaction"
)
@RestController
@RequestMapping(path="/api/v1/transaction", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@AllArgsConstructor
public class TransactionController {

    private ITransactionService transactionService ;

    @Operation(
            summary = "Create Account REST API",
            description = "REST API to trnafer fund from the bank to destination bank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PostMapping("/interBankTransferFund")
    public ResponseEntity<ResponseDto> processInterBankTransaction(@RequestBody InterBankRequest interBankRequest){
        ResponseDto responseDto = transactionService.processInterBankTransaction(interBankRequest) ;
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
    }


    @Operation(
            summary = "Create Account REST API",
            description = "REST API to transfer fund within the banks"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> processIntraBankTransaction(IntraBankRequest intraBankRequest){
       ResponseDto responseDto = transactionService.processIntraBankTransaction(intraBankRequest) ;
       return ResponseEntity.ok(responseDto);
    }

}

























































































































































































