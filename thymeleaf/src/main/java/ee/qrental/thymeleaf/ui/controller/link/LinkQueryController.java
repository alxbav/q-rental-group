package ee.qrental.thymeleaf.ui.controller.link;


import ee.qrental.car.application.port.in.query.GetCarQuery;
import ee.qrental.link.application.port.in.query.GetLinkQuery;
import ee.qrental.transaction.application.port.in.query.GetBalanceQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/links")
public class LinkQueryController {

    private final GetLinkQuery linkQuery;
    private final GetCarQuery carQuery;
    private final GetBalanceQuery balanceQuery;

    @GetMapping
    public String getLinkView(final Model model) {
        addLinkListToModel(model);
        addCarListToModel(model);
        addDriverListToModel(model);
        return "links";
    }

    private void addLinkListToModel(final Model model) {
        final var links = linkQuery.getAll();
        model.addAttribute("links", links);
    }

    private void addCarListToModel(final Model model) {
        final var cars = carQuery.getAll();
        model.addAttribute("cars", cars);
    }

    private void addDriverListToModel(final Model model) {
        final var drivers = balanceQuery.getAll();
        model.addAttribute("drivers", drivers);
    }
}