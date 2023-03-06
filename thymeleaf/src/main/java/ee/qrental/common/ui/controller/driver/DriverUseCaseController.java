package ee.qrental.common.ui.controller.driver;


import ee.qrental.driver.application.port.in.query.GetDriverQuery;
import ee.qrental.driver.application.port.in.request.driver.DriverAddRequest;
import ee.qrental.driver.application.port.in.request.driver.DriverDeleteRequest;
import ee.qrental.driver.application.port.in.request.driver.DriverUpdateRequest;
import ee.qrental.driver.application.port.in.usecase.driver.DriverAddUseCase;
import ee.qrental.driver.application.port.in.usecase.driver.DriverDeleteUseCase;
import ee.qrental.driver.application.port.in.usecase.driver.DriverUpdateUseCase;
import ee.qrental.transaction.application.port.in.query.GetTransactionTypeQuery;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeAddRequest;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeDeleteRequest;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeUpdateRequest;
import ee.qrental.transaction.application.port.in.usecase.transactiontype.TransactionTypeAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.transactiontype.TransactionTypeDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.transactiontype.TransactionTypeUpdateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/drivers")
public class DriverUseCaseController {

    private final DriverAddUseCase addUseCase;
    private final DriverUpdateUseCase updateUseCase;
    private final DriverDeleteUseCase deleteUseCase;

    private final GetDriverQuery driverQuery;

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("addRequest", new DriverAddRequest());

        return "forms/addDriver";
    }

    @PostMapping(value = "/add")
    public String addDriverDriver(
            @ModelAttribute final DriverAddRequest driverInfo) {
        addUseCase.add(driverInfo);

        return "redirect:/drivers";
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, final Model model) {
        model.addAttribute("updateRequest", driverQuery.getUpdateRequestById(id));

        return "forms/updateDriver";
    }

    @PostMapping("/update")
    public String updateDriverDriver(
            final DriverUpdateRequest driverUpdateRequest) {
        updateUseCase.update(driverUpdateRequest);

        return "redirect:/drivers";
    }

    @GetMapping(value = "/delete-form/{id}")
    public String deleteForm(@PathVariable("id") long id, final Model model) {
        model.addAttribute("deleteRequest", new DriverDeleteRequest(id));
        model.addAttribute("objectInfo", driverQuery.getObjectInfo(id));

        return "forms/deleteDriver";
    }

    @PostMapping("/delete")
    public String deleteForm(final DriverDeleteRequest deleteRequest) {
        deleteUseCase.delete(deleteRequest);

        return "redirect:/drivers";
    }
}