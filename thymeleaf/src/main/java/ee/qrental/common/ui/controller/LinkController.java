package ee.qrental.common.ui.controller;


import ee.qrental.car.application.port.out.CarLoadPort;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.link.application.port.in.query.GetLinkQuery;
import ee.qrental.link.application.port.in.request.LinkAddRequest;
import ee.qrental.link.application.port.in.request.LinkDeleteRequest;
import ee.qrental.link.application.port.in.request.LinkUpdateRequest;
import ee.qrental.link.application.port.in.usecase.LinkAddUseCase;
import ee.qrental.link.application.port.in.usecase.LinkDeleteUseCase;
import ee.qrental.link.application.port.in.usecase.LinkUpdateUseCase;
import ee.qrental.link.application.port.out.LinkLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private final GetLinkQuery linkQuery;

    @GetMapping
    public String getLinkView(final Model model) {
        addLinkListToModel(model);
        addCarListToModel(model);
        addDriverListToModel(model);
        return "links";
    }

    private void addLinkListToModel(final Model model) {
        final var links = linkLoadPort.loadAll();
        model.addAttribute("links", links);
    }

    private void addCarListToModel(final Model model) {
        final var cars = carLoadPort.loadAllCars();
        model.addAttribute("cars", cars);
    }

    private void addDriverListToModel(final Model model) {
        final var drivers = driverLoadPort.loadAll();
        model.addAttribute("drivers", drivers);
    }

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("linkAddCommand", new LinkAddRequest());
        addCarListToModel(model);
        addDriverListToModel(model);
        return "forms/addLink";
    }

    @PostMapping(value = "/add")
    public String addLinkLink(@ModelAttribute final LinkAddRequest linkInfo) {
        linkAddUseCase.add(linkInfo);
        return "redirect:/links";
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        final var linkUpdateCommand = linkQuery.getUpdateRequestById(id);
        model.addAttribute("linkUpdateCommand", linkUpdateCommand);
        addCarListToModel(model);
        addDriverListToModel(model);
        return "forms/updateLink";
    }

    @PostMapping("/update")
    public String updateLinkLink(final LinkUpdateRequest linkUpdateCommand) {
        linkUpdateUseCase.update(linkUpdateCommand);
        return "redirect:/links";
    }

    @GetMapping(value = "/delete-form/{id}")
    public String deleteForm(@PathVariable("id") long id, Model model) {
        final var request = new LinkDeleteRequest(id);
        model.addAttribute("linkDeleteCommand", request);
        model.addAttribute("objectInfo", linkQuery.getObjectInfo(id));
        return "forms/deleteLink";
    }

    @PostMapping("/delete")
    public String deleteForm(final LinkDeleteRequest request) {
        linkDeleteUseCase.delete(request);
        return "redirect:/links";
    }
}