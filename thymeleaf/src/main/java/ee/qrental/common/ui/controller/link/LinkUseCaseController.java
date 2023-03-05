package ee.qrental.common.ui.controller.link;


import ee.qrental.car.application.port.out.CarLoadPort;
import ee.qrental.link.application.port.in.query.GetLinkQuery;
import ee.qrental.link.application.port.in.request.LinkAddRequest;
import ee.qrental.link.application.port.in.request.LinkDeleteRequest;
import ee.qrental.link.application.port.in.request.LinkUpdateRequest;
import ee.qrental.link.application.port.in.usecase.LinkAddUseCase;
import ee.qrental.link.application.port.in.usecase.LinkDeleteUseCase;
import ee.qrental.link.application.port.in.usecase.LinkUpdateUseCase;
import ee.qrental.transaction.application.port.in.query.GetBalanceQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor

@Controller
@RequestMapping("/links")
public class LinkUseCaseController {

    private final LinkAddUseCase linkAddUseCase;
    private final LinkUpdateUseCase linkUpdateUseCase;
    private final LinkDeleteUseCase linkDeleteUseCase;
    private final CarLoadPort carLoadPort;
    private final GetLinkQuery linkQuery;
    private final GetBalanceQuery balanceQuery;

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        addAddRequestToModel(model, new LinkAddRequest());
        addCarListToModel(model);
        addDriverListToModel(model);

        return "forms/addLink";
    }

    @PostMapping(value = "/add")
    public String addLinkLink(@ModelAttribute final LinkAddRequest addRequest,
                              final Model model) {
        linkAddUseCase.add(addRequest);
        if (addRequest.hasViolations()) {
            addAddRequestToModel(model, addRequest);
            addCarListToModel(model);
            addDriverListToModel(model);

            return "forms/addLink";
        }

        return "redirect:/links";
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        final var updateRequest = linkQuery.getUpdateRequestById(id);
        model.addAttribute("updateRequest", updateRequest);
        addCarListToModel(model);
        addDriverListToModel(model);

        return "forms/updateLink";
    }

    private void addAddRequestToModel(final Model model, final LinkAddRequest addRequest) {
        model.addAttribute("addRequest", addRequest);
    }

    private void addCarListToModel(final Model model) {
        final var cars = carLoadPort.loadAllCars();
        model.addAttribute("cars", cars);
    }

    private void addDriverListToModel(final Model model) {
        final var drivers = balanceQuery.getAll();
        model.addAttribute("drivers", drivers);
    }

    @PostMapping("/update")
    public String updateLinkLink(final LinkUpdateRequest updateRequest) {
        linkUpdateUseCase.update(updateRequest);

        return "redirect:/links";
    }

    @GetMapping(value = "/delete-form/{id}")
    public String deleteForm(@PathVariable("id") long id, final Model model) {
        final var deleteRequest = new LinkDeleteRequest(id);
        model.addAttribute("deleteRequest", deleteRequest);
        model.addAttribute("objectInfo", linkQuery.getObjectInfo(id));

        return "forms/deleteLink";
    }

    @PostMapping("/delete")
    public String deleteForm(final LinkDeleteRequest deleteRequest) {
        linkDeleteUseCase.delete(deleteRequest);

        return "redirect:/links";
    }
}