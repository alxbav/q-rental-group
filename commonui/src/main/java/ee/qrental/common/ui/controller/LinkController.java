package ee.qrental.common.ui.controller;


import ee.qrental.car.application.port.out.CarLoadPort;
import ee.qrental.link.application.port.in.command.LinkDeleteCommand;
import ee.qrental.link.application.port.in.command.LinkAddCommand;
import ee.qrental.link.application.port.in.command.LinkUpdateCommand;
import ee.qrental.link.application.port.in.usecase.LinkAddUseCase;
import ee.qrental.link.application.port.in.usecase.LinkDeleteUseCase;
import ee.qrental.link.application.port.in.usecase.LinkUpdateUseCase;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.link.application.port.out.LinkLoadPort;
import ee.qrental.link.domain.Link;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;

@AllArgsConstructor

@Controller
@RequestMapping("/links")
public class LinkController {

    private final LinkAddUseCase linkAddUseCase;
    private final LinkUpdateUseCase linkUpdateUseCase;
    private final LinkDeleteUseCase linkDeleteUseCase;
    private final LinkLoadPort linkLoadPort;
    private final DriverLoadPort driverLoadPort;
    private final CarLoadPort carLoadPort;


    @GetMapping
    public String getLinkView(final Model model) {
        addLinkListToModel(model);
        addCarListToModel(model);
        addDriverListToModel(model);
        return "links";
    }

    private void addLinkListToModel(final Model model) {
        final var links = linkLoadPort.loadAllLinks();
        model.addAttribute("links", links);
    }

    private void addCarListToModel(final Model model) {
        final var cars = carLoadPort.loadAllCars();
        model.addAttribute("cars", cars);
    }

    private void addDriverListToModel(final Model model) {
        final var drivers = driverLoadPort.loadAllDrivers();
        model.addAttribute("drivers", drivers);
    }

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("linkAddCommand", new LinkAddCommand());
        addCarListToModel(model);
        addDriverListToModel(model);
        return "forms/addLink";
    }

    @PostMapping(value = "/add")
    public String addLinkLink(@ModelAttribute final LinkAddCommand linkInfo) {
        linkAddUseCase.add(linkInfo);
        return "redirect:/links";
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        final var linkUpdateCommand = mapToCommand(linkLoadPort.loadLinkById(id));
        model.addAttribute("linkUpdateCommand", linkUpdateCommand);
        addCarListToModel(model);
        addDriverListToModel(model);
        return "forms/updateLink";
    }

    @PostMapping("/update")
    public String updateLinkLink(final LinkUpdateCommand linkUpdateCommand) {
        linkUpdateUseCase.update(linkUpdateCommand);
        return "redirect:/links";
    }

    @GetMapping(value = "/delete-form/{id}")
    public String deleteForm(@PathVariable("id") long id, Model model) {
        final var link = linkLoadPort.loadLinkById(id);
        final var linkDeleteCommand = new LinkDeleteCommand();
        linkDeleteCommand.setId(link.getId());
        linkDeleteCommand.setObjectInfo(getObjectInfo(link));
        model.addAttribute("linkDeleteCommand", linkDeleteCommand);
        return "forms/deleteLink";
    }

    private String getObjectInfo(final Link link) {
        final var driver = driverLoadPort.loadDriverById(link.getDriverId());
        final var car = carLoadPort.loadCarById(link.getCarId());
        final var linkType = link.getLinkType();
        final var linkDateStart = link.getDateStart().toString();
        final var linkDateEnd = link.getDateEnd().toString();
        final var linkDriver = driver.getFirstName() + " " + driver.getLastName();
        final var linkCar = car.getRegNumber();

        return format("Link: %s for Car: %s  and Driver: %s from: %s - to: %s",
                linkType,
                linkCar,
                linkDriver,
                linkDateStart,
                linkDateEnd);


    }


    @PostMapping("/delete")
    public String deleteForm(final LinkDeleteCommand linkDeleteCommand) {
        linkDeleteUseCase.delete(linkDeleteCommand);
        return "redirect:/links";
    }


    private LinkUpdateCommand mapToCommand(final Link domain) {
        final var result = new LinkUpdateCommand();
        result.setId(domain.getId());
        result.setCarId(domain.getCarId());
        result.setDriverId(domain.getDriverId());
        result.setLinkType(domain.getLinkType());
        result.setDateStart(domain.getDateStart());
        result.setDateEnd(domain.getDateEnd());
        result.setComment(domain.getComment());
        return result;
    }


}