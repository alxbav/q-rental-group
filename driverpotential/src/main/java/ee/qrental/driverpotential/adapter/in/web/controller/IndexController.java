package ee.qrental.driverpotential.adapter.in.web.controller;


import ee.qrental.driverpotential.application.port.in.command.DriverPotentialAddCommand;
import ee.qrental.driverpotential.application.port.in.command.DriverPotentialUpdateCommand;
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

    @GetMapping(value = "/")
    public String getDrivers(final Model model) {
        final var drivers = driverPotentialLoadPort.loadAllPotentialDrivers();
        model.addAttribute("drivers", drivers);
        model.addAttribute("driverAddCommand", new DriverPotentialAddCommand());
        model.addAttribute("driverUpdateCommand", new DriverPotentialUpdateCommand());
        return "index";
    }

}
