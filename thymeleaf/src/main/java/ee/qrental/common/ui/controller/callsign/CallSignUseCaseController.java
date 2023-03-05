package ee.qrental.common.ui.controller.callsign;


import ee.qrental.callsignlink.application.port.in.query.GetCallSignQuery;
import ee.qrental.callsignlink.application.port.in.request.callsign.CallSignAddRequest;
import ee.qrental.callsignlink.application.port.in.request.callsign.CallSignDeleteRequest;
import ee.qrental.callsignlink.application.port.in.request.callsign.CallSignUpdateRequest;
import ee.qrental.callsignlink.application.port.in.usecase.callsign.CallSignAddUseCase;
import ee.qrental.callsignlink.application.port.in.usecase.callsign.CallSignDeleteUseCase;
import ee.qrental.callsignlink.application.port.in.usecase.callsign.CallSignUpdateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/call-signs")
@AllArgsConstructor
public class CallSignUseCaseController {

    private final CallSignAddUseCase callSignAddUseCase;
    private final CallSignUpdateUseCase callSignUpdateUseCase;
    private final CallSignDeleteUseCase callSignDeleteUseCase;
    private final GetCallSignQuery callSignQuery;

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        addAddRequestToModel(new CallSignAddRequest(), model);

        return "forms/addCallSign";
    }

    @PostMapping(value = "/add")
    public String addCallSignLink(
            @ModelAttribute final CallSignAddRequest addRequest,
            final Model model) {
        callSignAddUseCase.add(addRequest);
        if (addRequest.hasViolations()) {
            addAddRequestToModel(addRequest, model);
            return "forms/addCallSign";
        }

        return "redirect:/call-signs";
    }

    private void addAddRequestToModel(final CallSignAddRequest addRequest,
                                      final Model model) {
        model.addAttribute("addRequest", addRequest);
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, final Model model) {
        addUpdateRequestToModel(model, callSignQuery.getUpdateRequestById(id));

        return "forms/updateCallSign";
    }

    @PostMapping("/update")
    public String updateCallSignCallSignLink(
            final CallSignUpdateRequest updateRequest,
            final Model model) {
        callSignUpdateUseCase.update(updateRequest);
        if (updateRequest.hasViolations()) {
            addUpdateRequestToModel(model, updateRequest);
            return "forms/updateCallSign";
        }

        return "redirect:/call-signs";
    }

    private void addUpdateRequestToModel(final Model model,
                                         final CallSignUpdateRequest updateRequest) {
        model.addAttribute("updateRequest", updateRequest);
    }


    @GetMapping(value = "/delete-form/{id}")
    public String deleteForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("deleteRequest", new CallSignDeleteRequest(id));
        model.addAttribute("objectInfo", callSignQuery.getObjectInfo(id));

        return "forms/deleteCallSign";
    }

    @PostMapping("/delete")
    public String deleteForm(final CallSignDeleteRequest deleteRequest) {
        callSignDeleteUseCase.delete(deleteRequest);

        return "redirect:/call-signs";
    }
}