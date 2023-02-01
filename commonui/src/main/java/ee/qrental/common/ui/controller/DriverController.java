package ee.qrental.common.ui.controller;

import ee.qrental.driver.application.port.in.command.DriverAddCommand;
import ee.qrental.driver.application.port.in.command.DriverUpdateCommand;
import ee.qrental.driver.application.port.in.usecase.DriverAddUseCase;
import ee.qrental.driver.application.port.in.usecase.DriverDeleteUseCase;
import ee.qrental.driver.application.port.in.usecase.DriverUpdateUseCase;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.driver.domain.Driver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor

@Controller
@RequestMapping("/drivers")
public class DriverController {

    private final DriverAddUseCase driverAddUseCase;
    private final DriverUpdateUseCase driverUpdateUseCase;
    private final DriverLoadPort driverLoadPort;
    private final DriverDeleteUseCase driverDeleteUseCase;

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("driverAddCommand", new DriverAddCommand());
        return "addFormDriver";
    }

    @PostMapping(value = "/add")
    public String addDriverDriver(@ModelAttribute final DriverAddCommand driverInfo) {
        driverAddUseCase.add(driverInfo);
        return "redirect:/";
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        final var driverUpdateCommand = mapToCommand(driverLoadPort.loadDriverById(id));
        model.addAttribute("driverUpdateCommand", driverUpdateCommand);
        return "updateFormDriver";
    }

    @PostMapping("/update")
    public String updateDriverDriver(
            final DriverUpdateCommand driverUpdateCommand) {
        driverUpdateUseCase.update(driverUpdateCommand);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") long id) {
        driverDeleteUseCase.delete(id);
        return "redirect:/";
    }

    private DriverUpdateCommand mapToCommand(final Driver domain) {
        final var result = new DriverUpdateCommand();
        result.setId(domain.getId());
        result.setFirstName(domain.getFirstName());
        result.setLastName(domain.getLastName());
        result.setPhone(domain.getPhone());
        result.setComment(domain.getComment());
        return result;
    }
}