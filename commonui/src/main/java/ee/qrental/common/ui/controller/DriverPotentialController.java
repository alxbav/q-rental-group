package ee.qrental.common.ui.controller;


import ee.qrental.driverpotential.application.port.in.command.DriverPotentialAddCommand;
import ee.qrental.driverpotential.application.port.in.command.DriverPotentialUpdateCommand;
import ee.qrental.driverpotential.application.port.in.usecase.DriverPotentialAddUseCase;
import ee.qrental.driverpotential.application.port.in.usecase.DriverPotentialDeleteUseCase;
import ee.qrental.driverpotential.application.port.in.usecase.DriverPotentialUpdateUseCase;
import ee.qrental.driverpotential.application.port.out.DriverPotentialLoadPort;
import ee.qrental.driverpotential.domain.DriverPotential;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor

@Controller
@RequestMapping("/drivers-potential")
public class DriverPotentialController {

    private final DriverPotentialAddUseCase driverPotentialAddUseCase;
    private final DriverPotentialUpdateUseCase driverPotentialUpdateUseCase;
    private final DriverPotentialLoadPort driverPotentialLoadPort;
    private final DriverPotentialDeleteUseCase driverPotentialDeleteUseCase;

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("driverAddCommand", new DriverPotentialAddCommand());
        return "addFormDriverPotential";
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        final var driverUpdateCommand = mapToCommand(driverPotentialLoadPort.loadPotentialDriverById(id));
        model.addAttribute("driverUpdateCommand", driverUpdateCommand);
        return "updateFormDriverPotential";
    }

    private DriverPotentialUpdateCommand mapToCommand(final DriverPotential domain) {
        final var result = new DriverPotentialUpdateCommand();
        result.setId(domain.getId());
        result.setFirstName(domain.getFirstName());
        result.setLastName(domain.getLastName());
        result.setPhone(domain.getPhone());
        result.setComment(domain.getComment());
        return result;
    }

    @PostMapping("/update")
    public String updateDriverDriverPotential(
            final DriverPotentialUpdateCommand driverUpdateCommand) {
        driverPotentialUpdateUseCase.update(driverUpdateCommand);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") long id) {
        driverPotentialDeleteUseCase.delete(id);
        return "redirect:/";
    }
}