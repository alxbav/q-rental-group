package ee.qrental.common.ui.controller.driver;



import ee.qrental.driver.application.port.in.query.GetDriverQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/drivers")
public class DriverQueryController {

    private final GetDriverQuery driverQuery;

    @GetMapping()
    public String getDriverView(final Model model) {
        model.addAttribute("drivers", driverQuery.getAll());
        return "drivers";
    }
}