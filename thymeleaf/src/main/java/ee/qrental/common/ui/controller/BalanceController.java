package ee.qrental.common.ui.controller;

import ee.qrental.transaction.application.port.out.BalanceLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/balances")
public class BalanceController {

    private final BalanceLoadPort balanceLoadPort;

    @GetMapping
    public String getBalanceView(final Model model) {
        model.addAttribute("balances", balanceLoadPort.loadBalances());
        return "balances";
    }




}
