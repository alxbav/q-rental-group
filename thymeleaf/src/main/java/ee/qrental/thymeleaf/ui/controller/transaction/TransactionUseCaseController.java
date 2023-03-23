package ee.qrental.thymeleaf.ui.controller.transaction;


import ee.qrental.driver.application.port.in.query.GetDriverQuery;
import ee.qrental.transaction.application.port.in.query.GetTransactionQuery;
import ee.qrental.transaction.application.port.in.query.GetTransactionTypeQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionAddRequest;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionDeleteRequest;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionUpdateRequest;
import ee.qrental.transaction.application.port.in.usecase.transaction.TransactionAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.transaction.TransactionDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.transaction.TransactionUpdateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/transactions")

@AllArgsConstructor
public class TransactionUseCaseController {

    private final TransactionAddUseCase addUseCase;
    private final TransactionUpdateUseCase updateUseCase;
    private final TransactionDeleteUseCase deleteUseCase;
    private final GetTransactionQuery transactionQuery;
    private final GetTransactionTypeQuery transactionTypeQuery;
    private final GetDriverQuery driverQuery;

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("addRequest", new TransactionAddRequest());
        model.addAttribute("positiveTransactionTypes", transactionTypeQuery.getPositive());
        model.addAttribute("negativeTransactionTypes", transactionTypeQuery.getNegative());
        model.addAttribute("drivers", driverQuery.getAll());

        return "forms/addTransaction";
    }

    @PostMapping(value = "/add")
    public String addTransaction(
            @ModelAttribute final TransactionAddRequest addRequest) {
        addUseCase.add(addRequest);

        return "redirect:/transactions";
    }

    @GetMapping(value = "/add-form/driver/{driverId}")
    public String addFormWithDriver(
            @PathVariable("driverId") long driverId,
            final Model model) {
        final var addRequest = new TransactionAddRequest();
        addRequest.setDriverId(driverId);
        model.addAttribute("addRequest", addRequest);
        model.addAttribute("positiveTransactionTypes", transactionTypeQuery.getPositive());
        model.addAttribute("negativeTransactionTypes", transactionTypeQuery.getNegative());
        model.addAttribute("driverInfo", driverQuery.getObjectInfo(driverId));
        model.addAttribute("driverId", driverId);

        return "forms/addTransactionWithDriver";
    }

    @PostMapping(value = "/add/driver")
    public String addTransactionWithDriver(@ModelAttribute final TransactionAddRequest addRequest) {
        addUseCase.add(addRequest);
        final var driverId = addRequest.getDriverId();

        return "redirect:/balances/driver/" + driverId;
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("updateRequest", transactionQuery.getUpdateRequestById(id));
        model.addAttribute("transactionTypes", transactionTypeQuery.getAll());
        model.addAttribute("drivers", driverQuery.getAll());

        return "forms/updateTransaction";
    }

    @PostMapping("/update")
    public String updateTransactionTransaction(final TransactionUpdateRequest updateRequest) {
        updateUseCase.update(updateRequest);

        return "redirect:/transactions";
    }

    @GetMapping(value = "/update-form/driver/{id}")
    public String updateFormWithDriver(@PathVariable("id") long id, Model model) {
        final var updateRequest = transactionQuery.getUpdateRequestById(id);
        final var driverId = updateRequest.getDriverId();
        model.addAttribute("updateRequest", updateRequest);
        model.addAttribute("transactionTypes", transactionTypeQuery.getAll());
        model.addAttribute("driverInfo", driverQuery.getObjectInfo(driverId));
        model.addAttribute("driverId", driverId);

        return "forms/updateTransactionWithDriver";
    }

    @PostMapping("/update/driver")
    public String updateTransactionWithDriver(
            final TransactionUpdateRequest updateRequest) {
        updateUseCase.update(updateRequest);
        final var driverId = updateRequest.getDriverId();

        return "redirect:/balances/driver/" + driverId;
    }

    @GetMapping(value = "/delete-form/{id}")
    public String deleteForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("deleteRequest", new TransactionDeleteRequest(id));
        model.addAttribute("objectInfo", transactionQuery.getObjectInfo(id));

        return "forms/deleteTransaction";
    }

    @PostMapping("/delete")
    public String deleteForm(final TransactionDeleteRequest transactionDeleteCommand) {
        deleteUseCase.delete(transactionDeleteCommand);

        return "redirect:/transactions";
    }

    @GetMapping(value = "/delete-form/driver/{id}")
    public String deleteFormWithDriver(@PathVariable("id") Long id, Model model) {
        final var driverId = transactionQuery.getUpdateRequestById(id).getDriverId();
        model.addAttribute("deleteRequest", new TransactionDeleteRequest(id));
        model.addAttribute("objectInfo", transactionQuery.getObjectInfo(id));
        model.addAttribute("driverId", driverId);

        return "forms/deleteTransactionWithDriver";
    }

    @PostMapping("/delete/driver/{driverId}")
    public String deleteTransactionWithDriver(
            @PathVariable("driverId") long driverId,
            final TransactionDeleteRequest transactionDeleteCommand) {
        deleteUseCase.delete(transactionDeleteCommand);

        return "redirect:/balances/driver/" + driverId;
    }
}