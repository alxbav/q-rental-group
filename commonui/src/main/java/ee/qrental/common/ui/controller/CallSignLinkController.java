package ee.qrental.common.ui.controller;

import ee.qrental.driver.application.port.in.command.CallSignAddCommand;
import ee.qrental.driver.application.port.in.command.DriverAddCommand;
import ee.qrental.driver.application.port.in.command.DriverUpdateCommand;
import ee.qrental.driver.application.port.in.usecase.CallSignLinkAddUseCase;
import ee.qrental.driver.application.port.in.usecase.DriverAddUseCase;
import ee.qrental.driver.application.port.in.usecase.DriverDeleteUseCase;
import ee.qrental.driver.application.port.in.usecase.DriverUpdateUseCase;
import ee.qrental.driver.application.port.out.CallSignLinkLoadPort;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.driver.domain.Driver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor

@Controller
@RequestMapping("/call-sign-links")
public class CallSignLinkController {

    private final CallSignLinkLoadPort callSignLinkLoadPort;
    private final CallSignLinkAddUseCase callSignLinkAddUseCase;
    private final DriverLoadPort driverLoadPort;

    @GetMapping
    public String getCallSignLinkView(final Model model) {
        addCallSignLinkListToModel(model);
        return "callSignLinks";
    }

    private void addCallSignLinkListToModel(final Model model) {
        final var callSignLinks = callSignLinkLoadPort.loadAllCallSignLinks();
        model.addAttribute("callSignLinks", callSignLinks);
    }

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("callSignLinkAddCommand", new CallSignAddCommand());
        addDriverListToModel(model);
        return "addFormCallSignLink";
    }

    private void addDriverListToModel(final Model model) {
        final var drivers = driverLoadPort.loadAllDrivers();
        model.addAttribute("drivers", drivers);
    }

    @PostMapping(value = "/add")
    public String addCallSignLink(@ModelAttribute final CallSignAddCommand addCommand) {
        callSignLinkAddUseCase.add(addCommand);
        return "redirect:/call-sign-links";
    }
/*
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
        return "redirect:/drivers";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") long id) {
        driverDeleteUseCase.delete(id);
        return "redirect:/drivers";
    }*/

    private DriverUpdateCommand mapToCommand(final Driver domain) {
        final var result = new DriverUpdateCommand();
        result.setId(domain.getId());
        result.setFirstName(domain.getFirstName());
        result.setLastName(domain.getLastName());
        result.setIsikukood(domain.getIsikukood());
        result.setPhone(domain.getPhone());
        result.setEmail(domain.getEmail());
        result.setIban1(domain.getIban1());
        result.setIban2(domain.getIban2());
        result.setIban3(domain.getIban3());
        result.setDriverLicenseNumber(domain.getDriverLicenseNumber());
        result.setDriverLicenseExp(domain.getDriverLicenseExp());
        result.setTaxiLicense(domain.getTaxiLicense());
        result.setAddress(domain.getAddress());
        result.setComment(domain.getComment());
        return result;
    }
}