package ee.qrental.common.ui.controller.callsignlink;


import ee.qrental.callsignlink.application.port.in.query.GetCallSignLinkQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor

@Controller
@RequestMapping("/call-sign-links")
public class CallSignLinkQueryController {
    private final GetCallSignLinkQuery callSignLinkQuery;

    @GetMapping
    public String getCallSignLinkView(final Model model) {
        model.addAttribute("callSignLinks", callSignLinkQuery.getAll());
        return "callSignLinks";
    }
}