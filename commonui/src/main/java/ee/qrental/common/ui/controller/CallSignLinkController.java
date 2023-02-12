package ee.qrental.common.ui.controller;

import ee.qrental.driver.application.port.in.command.CallSignLinkAddCommand;
import ee.qrental.driver.application.port.in.command.CallSignLinkDeleteCommand;
import ee.qrental.driver.application.port.in.command.CallSignLinkUpdateCommand;
import ee.qrental.driver.application.port.in.usecase.CallSignLinkAddUseCase;
import ee.qrental.driver.application.port.in.usecase.CallSignLinkDeleteUseCase;
import ee.qrental.driver.application.port.in.usecase.CallSignLinkUpdateUseCase;
import ee.qrental.driver.application.port.out.CallSignLinkLoadPort;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.driver.domain.CallSignLink;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;

@AllArgsConstructor

@Controller
@RequestMapping("/call-sign-links")
public class CallSignLinkController {

    private final CallSignLinkAddUseCase callSignLinkAddUseCase;
    private final CallSignLinkUpdateUseCase callSignLinkUpdateUseCase;
    private final CallSignLinkDeleteUseCase callSignLinkDeleteUseCase;
    private final CallSignLinkLoadPort callSignLinkLoadPort;
    private final DriverLoadPort driverLoadPort;

    @GetMapping
    public String getCallSignLinkView(final Model model) {
        addCallSignLinkListToModel(model);
        addDriverListToModel(model);
        return "callSignLinks";
    }

    private void addCallSignLinkListToModel(final Model model) {
        final var callSignLinks = callSignLinkLoadPort.loadAllCallSignLinks();
        model.addAttribute("callSignLinks", callSignLinks);
    }

    private void addDriverListToModel(final Model model) {
        final var drivers = driverLoadPort.loadAllDrivers();
        model.addAttribute("drivers", drivers);
    }

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("callSignLinkAddCommand", new CallSignLinkAddCommand());
        addDriverListToModel(model);
        return "forms/addCallSignLink";
    }


    @PostMapping(value = "/add")
    public String addCallSignLink(@ModelAttribute final CallSignLinkAddCommand addCommand) {
        callSignLinkAddUseCase.add(addCommand);
        return "redirect:/call-sign-links";
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        final var callSignLinkUpdateCommand = mapToCommand(callSignLinkLoadPort.loadCallSignLinkById(id));
        model.addAttribute("callSignLinkUpdateCommand", callSignLinkUpdateCommand);
        addDriverListToModel(model);
        return "forms/updateCallSignLink";
    }

    @PostMapping("/update")
    public String updateCallSignCallSignLink(
            final CallSignLinkUpdateCommand callSignLinkUpdateCommand) {
        callSignLinkUpdateUseCase.update(callSignLinkUpdateCommand);
        return "redirect:/call-sign-links";
    }

    @GetMapping(value = "/delete-form/{id}")
    public String deleteForm(@PathVariable("id") long id, Model model) {
        final var callSignLink = callSignLinkLoadPort.loadCallSignLinkById(id);
        final var callSignLinkDeleteCommand = new CallSignLinkDeleteCommand();
        callSignLinkDeleteCommand.setId(callSignLink.getId());
        callSignLinkDeleteCommand.setObjectInfo(getObjectInfo(callSignLink));
        model.addAttribute("callSignLinkDeleteCommand", callSignLinkDeleteCommand);
        return "forms/deleteCallSignLink";
    }

    private String getObjectInfo(final CallSignLink callSignLink) {
        final var driver = driverLoadPort.loadDriverById(
                callSignLink.getDriverId());
        final var driverFirstName = driver.getFirstName();
        final var driverLastName = driver.getLastName();
        final var callSignNumber = callSignLink.getCallSign();
        return format(" Call Sign '%d' for driver: %s %s",
                callSignNumber,
                driverLastName,
                driverFirstName);
    }

    @PostMapping("/delete")
    public String deleteForm(final CallSignLinkDeleteCommand callSignLinkDeleteCommand) {
        callSignLinkDeleteUseCase.delete(callSignLinkDeleteCommand);
        return "redirect:/call-sign-links";
    }

    private CallSignLinkUpdateCommand mapToCommand(final CallSignLink domain) {
        final var result = new CallSignLinkUpdateCommand();
        result.setId(domain.getId());
        result.setDriverId(domain.getDriverId());
        result.setCallSign(domain.getCallSign());
        result.setDateStart(domain.getDateStart());
        result.setDateEnd(domain.getDateEnd());
        result.setComment(domain.getComment());
        return result;
    }
}