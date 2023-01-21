package ee.qrental.driverpotential.adapter.in.web.controller;


import ee.qrental.driverpotential.application.port.in.command.DriverPotentialAddCommand;
import ee.qrental.driverpotential.application.port.in.usecase.DriverPotentialAddUseCase;
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
@RequestMapping("/drivers-potential")
public class DriverPotentialController {

    private final DriverPotentialAddUseCase driverPotentialRegistrationUseCase;

    private final LoadDriverPotentialPort loadDriverPotentialPort;

    @GetMapping(value = "/")
    public String getDrivers(final Model model) {
        final var drivers = loadDriverPotentialPort.loadAllPotentialDrivers();
        model.addAttribute("drivers", drivers);
        model.addAttribute("driverInfo", new DriverPotentialAddCommand());
        return "drivers-potential";
    }

    @PostMapping(value = "/")
    public String createDriver(
            final Model model,
            @ModelAttribute DriverPotentialAddCommand driverInfo) {
        driverPotentialRegistrationUseCase.add(driverInfo);
        return "redirect:/drivers-potential/";
    }

}
