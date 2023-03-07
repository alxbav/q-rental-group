package ee.qrental.thymeleaf.ui.controller.car;


import ee.qrental.car.application.port.in.query.GetCarQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")

@AllArgsConstructor
public class CarQueryController {

    private final GetCarQuery carQuery;


    @GetMapping
    public String getCarView(final Model model) {
        addCarListToModel(model);

        return "cars";
    }

    private void addCarListToModel(final Model model) {
        final var cars = carQuery.getAll();
        model.addAttribute("cars", cars);
    }
}