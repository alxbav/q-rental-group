package ee.qrental.common.ui.controller;


import ee.qrental.transactiontype.application.port.in.command.TransactionTypeAddCommand;
import ee.qrental.transactiontype.application.port.in.command.TransactionTypeUpdateCommand;
import ee.qrental.transactiontype.application.port.in.usecase.TransactionTypeAddUseCase;
import ee.qrental.transactiontype.application.port.in.usecase.TransactionTypeDeleteUseCase;
import ee.qrental.transactiontype.application.port.in.usecase.TransactionTypeUpdateUseCase;
import ee.qrental.transactiontype.application.port.out.TransactionTypeLoadPort;
import ee.qrental.transactiontype.domain.TransactionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor

@Controller
@RequestMapping("/transactions")
public  class TransactionController {


    @GetMapping
    public String getTransactionView(final Model model){
        return "transactions";
    }



}