package ee.qrental.common.ui.controller;


import ee.qrental.driver.application.port.in.command.DriverDeleteCommand;
import ee.qrental.driver.domain.Driver;
import ee.qrental.driverpotential.application.port.in.command.DriverPotentialAddCommand;
import ee.qrental.driverpotential.application.port.in.command.DriverPotentialDeleteCommand;
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

import static java.lang.String.format;

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
        model.addAttribute("driverPotentialAddCommand", new DriverPotentialAddCommand());
        return "forms/addDriverPotential";
    }

    @PostMapping(value = "/add")
    public String addDriverDriverPotential(@ModelAttribute final DriverPotentialAddCommand driverPotentialInfo) {
        driverPotentialAddUseCase.add(driverPotentialInfo);
        return "redirect:/";
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        final var driverPotentialUpdateCommand = mapToCommand(driverPotentialLoadPort.loadPotentialDriverById(id));
        model.addAttribute("driverPotentialUpdateCommand", driverPotentialUpdateCommand);
        return "forms/updateDriverPotential";
    }

    @PostMapping("/update")
    public String updateDriverDriverPotential(
            final DriverPotentialUpdateCommand driverPotentialUpdateCommand) {
        driverPotentialUpdateUseCase.update(driverPotentialUpdateCommand);
        return "redirect:/";
    }
    @GetMapping(value = "/delete-form/{id}")
    public String deleteForm(@PathVariable("id") long id, Model model) {
        final var driverPotential = driverPotentialLoadPort.loadPotentialDriverById(id);
        final var driverPotentialDeleteCommand = new DriverPotentialDeleteCommand();
        driverPotentialDeleteCommand.setId(driverPotential.getId());
        driverPotentialDeleteCommand.setObjectInfo(getObjectInfo(driverPotential));
        model.addAttribute("driverPotentialDeleteCommand", driverPotentialDeleteCommand);
        return "forms/deleteDriverPotential";
    }

    private String getObjectInfo(final DriverPotential driverPotential) {
        final var driverPotentialFirstName = driverPotential.getFirstName();
        final var driverPotentialLastName = driverPotential.getLastName();
        return format(" Driver Potential: %s, %s ",
                driverPotentialLastName,
                driverPotentialFirstName);

    }

    @PostMapping("/delete")
    public String deleteForm(final DriverPotentialDeleteCommand driverPotentialDeleteCommand) {
        driverPotentialDeleteUseCase.delete(driverPotentialDeleteCommand);
        return "redirect:/";
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
}