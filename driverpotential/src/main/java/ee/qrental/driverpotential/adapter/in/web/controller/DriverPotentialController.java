package ee.qrental.driverpotential.adapter.in.web.controller;


import ee.qrental.driverpotential.application.port.in.command.DriverPotentialAddCommand;
import ee.qrental.driverpotential.application.port.in.command.DriverPotentialUpdateCommand;
import ee.qrental.driverpotential.application.port.in.usecase.DriverPotentialAddUseCase;
import ee.qrental.driverpotential.application.port.in.usecase.DriverPotentialUpdateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor

@Controller
@RequestMapping("/drivers-potential")
public class DriverPotentialController {

    private final DriverPotentialAddUseCase driverPotentialRegistrationUseCase;
    private final DriverPotentialUpdateUseCase driverPotentialUpdateUseCase;

    @PostMapping(value = "/add")
    public String addPotentialDriver(
            final Model model,
            @ModelAttribute DriverPotentialAddCommand driverInfo) {
        driverPotentialRegistrationUseCase.add(driverInfo);
        return "redirect:/";
    }

    @PostMapping(value = "/update")
    public String updatePotentialDriver(
            final Model model,
            @ModelAttribute DriverPotentialUpdateCommand driverInfo) {
        driverPotentialUpdateUseCase.update(driverInfo);
        return "redirect:/";
    }
}
