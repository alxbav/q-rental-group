package ee.qrental.common.ui.controller;


import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.link.application.port.in.command.LinkAddCommand;
import ee.qrental.link.application.port.in.command.LinkUpdateCommand;
import ee.qrental.link.application.port.in.usecase.LinkAddUseCase;
import ee.qrental.link.application.port.in.usecase.LinkDeleteUseCase;
import ee.qrental.link.application.port.in.usecase.LinkUpdateUseCase;
import ee.qrental.link.application.port.out.LinkLoadPort;
import ee.qrental.link.domain.Link;
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
    private final LinkLoadPort linkLoadPort;
    private final LinkDeleteUseCase linkDeleteUseCase;


    @GetMapping
    public String getLinkView(final Model model) {
        addLinkListToModel(model);
        return "links";
    }

    private void addLinkListToModel(final Model model) {
        final var links = linkLoadPort.loadAllLinks();
        model.addAttribute("links", links);
    }


    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("linkAddCommand", new LinkAddCommand());
        return "addFormLink";
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
        return "updateFormLink";
    }

    @PostMapping("/update")
    public String updateLinkLink(final LinkUpdateCommand linkUpdateCommand) {
        linkUpdateUseCase.update(linkUpdateCommand);
        return "redirect:/links";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") long id) {
        linkDeleteUseCase.delete(id);
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