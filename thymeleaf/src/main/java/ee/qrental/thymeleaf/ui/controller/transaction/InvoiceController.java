package ee.qrental.thymeleaf.ui.controller.transaction;

import ee.qrental.driver.application.port.in.query.GetDriverQuery;
import ee.qrental.transaction.application.port.in.query.GetBalanceQuery;
import ee.qrental.transaction.application.port.in.query.GetInvoiceQuery;

import ee.qrental.transaction.application.port.in.request.transaction.TransactionFilterRequest;
import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ee.qrental.transaction.application.port.in.utils.TransactionUtils.getSum;


@Controller
@RequestMapping("/invoices")

@AllArgsConstructor
public class InvoiceController {

    private final GetInvoiceQuery invoiceQuery;

    @GetMapping
    public String getInvoiceView(final Model model) {
        model.addAttribute("invoices", invoiceQuery.getAll());
        return "invoices";
    }


}