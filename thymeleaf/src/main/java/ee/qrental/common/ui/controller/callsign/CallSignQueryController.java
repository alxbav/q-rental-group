package ee.qrental.common.ui.controller.callsign;


import ee.qrental.callsignlink.application.port.in.query.GetCallSignQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor

@Controller
@RequestMapping("/call-signs")
public class CallSignQueryController {
    private final GetCallSignQuery callSignQuery;

    @GetMapping
    public String getCallSignView(final Model model) {
        model.addAttribute("callSigns", callSignQuery.getAll());

        return "callSigns";
    }
}