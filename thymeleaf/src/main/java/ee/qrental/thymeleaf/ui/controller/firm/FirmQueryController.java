package ee.qrental.thymeleaf.ui.controller.firm;


import ee.qrental.transaction.application.port.in.query.GetFirmQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/firms")
public class FirmQueryController {

    private final GetFirmQuery firmQuery;

    @GetMapping()
    public String getFirmView(final Model model) {
        model.addAttribute("firms", firmQuery.getAll());
        return "firms";
    }
}