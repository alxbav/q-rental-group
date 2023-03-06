package ee.qrental.thymeleaf.ui.controller.firm;


import ee.qrental.transaction.application.port.in.query.GetFirmQuery;
import ee.qrental.transaction.application.port.in.request.firm.FirmAddRequest;
import ee.qrental.transaction.application.port.in.request.firm.FirmDeleteRequest;
import ee.qrental.transaction.application.port.in.request.firm.FirmUpdateRequest;
import ee.qrental.transaction.application.port.in.usecase.firm.FirmAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.firm.FirmDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.firm.FirmUpdateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/firms")
public class FirmUseCaseController {

    private final FirmAddUseCase addUseCase;
    private final FirmUpdateUseCase updateUseCase;
    private final FirmDeleteUseCase deleteUseCase;

    private final GetFirmQuery firmQuery;

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("addRequest", new FirmAddRequest());

        return "forms/addFirm";
    }

    @PostMapping(value = "/add")
    public String addFirmFirm(
            @ModelAttribute final FirmAddRequest firmInfo) {
        addUseCase.add(firmInfo);

        return "redirect:/firms";
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, final Model model) {
        model.addAttribute("updateRequest", firmQuery.getUpdateRequestById(id));

        return "forms/updateFirm";
    }

    @PostMapping("/update")
    public String updateFirmFirm(
            final FirmUpdateRequest firmUpdateRequest) {
        updateUseCase.update(firmUpdateRequest);

        return "redirect:/firms";
    }

    @GetMapping(value = "/delete-form/{id}")
    public String deleteForm(@PathVariable("id") long id, final Model model) {
        model.addAttribute("deleteRequest", new FirmDeleteRequest(id));
        model.addAttribute("objectInfo", firmQuery.getObjectInfo(id));

        return "forms/deleteFirm";
    }

    @PostMapping("/delete")
    public String deleteForm(final FirmDeleteRequest deleteRequest) {
        deleteUseCase.delete(deleteRequest);

        return "redirect:/firms";
    }
}