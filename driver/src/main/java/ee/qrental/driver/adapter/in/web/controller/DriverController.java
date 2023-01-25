package ee.qrental.driver.adapter.in.web.controller;


import ee.qrental.driver.application.port.in.command.DriverAddCommand;
import ee.qrental.driver.application.port.in.usecase.DriverAddUseCase;
import ee.qrental.driver.application.port.out.LoadDriverPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor

@Controller
@RequestMapping("/drivers")
public class DriverController {

    private final DriverAddUseCase driverRegistrationUseCase;

    private final LoadDriverPort loadDriverPort;

    @GetMapping(value = "/")
    public String getDrivers(final Model model) {
        final var drivers = loadDriverPort.loadAllDrivers();
        model.addAttribute("drivers", drivers);
        model.addAttribute("driverInfo", new DriverAddCommand());
        return "drivers";
    }

    @PostMapping(value = "/")
    public String createDriver(
            final Model model,
            @ModelAttribute DriverAddCommand driverInfo) {
        driverRegistrationUseCase.add(driverInfo);
        return "redirect:/drivers/";
    }

}
