package ee.qrental.thymeleaf.ui.controller.car;

import ee.qrental.car.application.port.in.query.GetCarQuery;
import ee.qrental.car.application.port.in.request.CarAddRequest;
import ee.qrental.car.application.port.in.request.CarDeleteRequest;
import ee.qrental.car.application.port.in.request.CarUpdateRequest;
import ee.qrental.car.application.port.in.usecase.CarAddUseCase;
import ee.qrental.car.application.port.in.usecase.CarDeleteUseCase;
import ee.qrental.car.application.port.in.usecase.CarUpdateUseCase;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeDeleteRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")

@AllArgsConstructor
public class CarUseCaseController {

    private final GetCarQuery carQuery;
    private final CarAddUseCase addUseCase;
    private final CarUpdateUseCase updateUseCase;
    private final CarDeleteUseCase deleteUseCase;


    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        addAddRequestToModel(new CarAddRequest(), model);

        return "forms/addCar";
    }

    @PostMapping(value = "/add")
    public String addCarCar(
            final Model model,
            @ModelAttribute final CarAddRequest addRequest) {

        addUseCase.add(addRequest);
        if (addRequest.hasViolations()) {
            addAddRequestToModel(addRequest, model);

            return "forms/addCar";
        }

        return "redirect:/cars";
    }

    private void addAddRequestToModel(
            final CarAddRequest addRequest,
            final Model model) {
        model.addAttribute("addRequest", addRequest);
    }


    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        addUpdateRequestToModel(model, carQuery.getUpdateRequestById(id));

        return "forms/updateCar";
    }

    @PostMapping("/update")
    public String updateCarCar(
            final Model model,
            final CarUpdateRequest updateRequest) {
        updateUseCase.update(updateRequest);
        if (updateRequest.hasViolations()) {
            addUpdateRequestToModel(model, updateRequest);

            return "forms/updateCar";
        }

        return "redirect:/cars";
    }

    private void addUpdateRequestToModel(final Model model,
                                         final CarUpdateRequest updateRequest) {
        model.addAttribute("updateRequest", updateRequest);
    }

    @GetMapping(value = "/delete-form/{id}")
    public String deleteForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("deleteRequest", new TransactionTypeDeleteRequest(id));
        model.addAttribute("objectInfo", carQuery.getObjectInfo(id));

        return "forms/deleteCar";
    }

    @PostMapping("/delete")
    public String deleteForm(final CarDeleteRequest deleteRequest) {
        deleteUseCase.delete(deleteRequest);

        return "redirect:/cars";
    }
}