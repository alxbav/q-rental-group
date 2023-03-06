package ee.qrental.thymeleaf.ui.controller.callsignlink;


import ee.qrental.callsignlink.application.port.in.query.GetCallSignLinkQuery;
import ee.qrental.callsignlink.application.port.in.query.GetCallSignQuery;
import ee.qrental.callsignlink.application.port.in.request.callsignlink.CallSignLinkAddRequest;
import ee.qrental.callsignlink.application.port.in.request.callsignlink.CallSignLinkDeleteRequest;
import ee.qrental.callsignlink.application.port.in.request.callsignlink.CallSignLinkUpdateRequest;
import ee.qrental.callsignlink.application.port.in.usecase.callsignlink.CallSignLinkAddUseCase;
import ee.qrental.callsignlink.application.port.in.usecase.callsignlink.CallSignLinkDeleteUseCase;
import ee.qrental.callsignlink.application.port.in.usecase.callsignlink.CallSignLinkUpdateUseCase;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeDeleteRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor

@Controller
@RequestMapping("/call-sign-links")
public class CallSignLinkUseCaseController {

    private final CallSignLinkAddUseCase callSignLinkAddUseCase;
    private final CallSignLinkUpdateUseCase callSignLinkUpdateUseCase;
    private final CallSignLinkDeleteUseCase callSignLinkDeleteUseCase;
    private final GetCallSignLinkQuery callSignLinkQuery;
    private final DriverLoadPort driverLoadPort;

    private final GetCallSignQuery callSignQuery;


    private void addDriverListToModel(final Model model) {
        final var drivers = driverLoadPort.loadAll();
        model.addAttribute("drivers", drivers);
    }

    private void addCallSignListToModel(final Model model) {
        final var callSigns = callSignQuery.getAll();
        model.addAttribute("callSigns", callSigns);
    }

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        addAddRequestToModel(new CallSignLinkAddRequest(), model);
        addDriverListToModel(model);
        addCallSignListToModel(model);

        return "forms/addCallSignLink";
    }


    @PostMapping(value = "/add")
    public String addCallSignLink(@ModelAttribute final CallSignLinkAddRequest addRequest,
                                  final Model model) {
        callSignLinkAddUseCase.add(addRequest);
        if (addRequest.hasViolations()) {
            addAddRequestToModel(addRequest, model);
            addDriverListToModel(model);
            addCallSignListToModel(model);

            return "forms/addCallSignLink";
        }

        return "redirect:/call-sign-links";
    }


    private void addAddRequestToModel(
            final CallSignLinkAddRequest addRequest,
            final Model model) {
        model.addAttribute("addRequest", addRequest);
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id,
                             final Model model) {
        model.addAttribute(
                "updateRequest",
                callSignLinkQuery.getUpdateRequestById(id));
        addDriverListToModel(model);
        addCallSignListToModel(model);

        return "forms/updateCallSignLink";
    }

    @PostMapping("/update")
    public String updateCallSignCallSignLink(
            final Model model,
            final CallSignLinkUpdateRequest updateRequest) {
        callSignLinkUpdateUseCase.update(updateRequest);
        if (updateRequest.hasViolations()) {
            addUpdateRequestToModel(model, updateRequest);
            addDriverListToModel(model);
            addCallSignListToModel(model);

            return "forms/updateCallSignLink";
        }

        return "redirect:/call-sign-links";
    }

    private void addUpdateRequestToModel(final Model model,
                                         final CallSignLinkUpdateRequest updateRequest) {
        model.addAttribute("updateRequest", updateRequest);
    }

    @GetMapping(value = "/delete-form/{id}")
    public String deleteForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("deleteRequest", new TransactionTypeDeleteRequest(id));
        model.addAttribute("objectInfo", callSignLinkQuery.getObjectInfo(id));

        return "forms/deleteCallSignLink";
    }

    @PostMapping("/delete")
    public String deleteForm(final CallSignLinkDeleteRequest deleteRequest) {
        callSignLinkDeleteUseCase.delete(deleteRequest);
        return "redirect:/call-sign-links";
    }
}