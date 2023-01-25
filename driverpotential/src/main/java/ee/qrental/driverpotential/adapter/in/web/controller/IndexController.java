package ee.qrental.driverpotential.adapter.in.web.controller;


import ee.qrental.driverpotential.application.port.in.command.DriverPotentialAddCommand;
import ee.qrental.driverpotential.application.port.in.command.DriverPotentialUpdateCommand;
import ee.qrental.driverpotential.application.port.out.LoadDriverPotentialPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor

@Controller
@RequestMapping("/")
public class IndexController {
    private final LoadDriverPotentialPort loadDriverPotentialPort;

    @GetMapping(value = "/")
    public String getDrivers(final Model model) {
        final var drivers = loadDriverPotentialPort.loadAllPotentialDrivers();
        model.addAttribute("drivers", drivers);
        model.addAttribute("driverAddCommand", new DriverPotentialAddCommand());
        model.addAttribute("driverUpdateCommand", new DriverPotentialUpdateCommand());
        return "index";
    }

}
