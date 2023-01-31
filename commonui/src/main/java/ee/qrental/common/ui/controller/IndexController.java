package ee.qrental.common.ui.controller;

import ee.qrental.driverpotential.application.port.out.DriverPotentialLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor

@Controller
@RequestMapping("/")
public class IndexController {

    private final DriverPotentialLoadPort driverPotentialLoadPort;

    @GetMapping
    public String getIndexView(final Model model) {
        addDriverPotentialListToModel(model);
        return "index";
    }

    private void addDriverPotentialListToModel(final Model model) {
        final var drivers = driverPotentialLoadPort.loadAllPotentialDrivers();
        model.addAttribute("driversPotential", drivers);
    }
}
