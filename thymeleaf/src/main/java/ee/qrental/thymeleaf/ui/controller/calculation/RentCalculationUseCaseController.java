package ee.qrental.thymeleaf.ui.controller.calculation;


import ee.qrental.calculation.application.port.in.request.RentCalculationAddRequest;
import ee.qrental.calculation.application.port.in.usecase.RentCalculationAddUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/calculations")

@AllArgsConstructor
public class RentCalculationUseCaseController {

    private final RentCalculationAddUseCase addUseCase;

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        addAddRequestToModel(new RentCalculationAddRequest(), model);

        return "forms/addCalculation";
    }

    @PostMapping(value = "/add")
    public String addCallSignLink(
            @ModelAttribute final RentCalculationAddRequest addRequest,
            final Model model) {
        addUseCase.add(addRequest);
        if (addRequest.hasViolations()) {
            addAddRequestToModel(addRequest, model);
            return "forms/addCalculation";
        }

        return "redirect:/calculations";
    }

    private void addAddRequestToModel(
            final RentCalculationAddRequest addRequest,
            final Model model) {
        model.addAttribute("addRequest", addRequest);
    }
}