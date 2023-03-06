package ee.qrental.thymeleaf.ui.controller.link;


import ee.qrental.car.application.port.out.CarLoadPort;
import ee.qrental.link.application.port.out.LinkLoadPort;
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

    private final LinkLoadPort linkLoadPort;
    private final CarLoadPort carLoadPort;
    private final GetBalanceQuery balanceQuery;

    @GetMapping
    public String getLinkView(final Model model) {
        addLinkListToModel(model);
        addCarListToModel(model);
        addDriverListToModel(model);
        return "links";
    }

    private void addLinkListToModel(final Model model) {
        final var links = linkLoadPort.loadAll();
        model.addAttribute("links", links);
    }

    private void addCarListToModel(final Model model) {
        final var cars = carLoadPort.loadAllCars();
        model.addAttribute("cars", cars);
    }

    private void addDriverListToModel(final Model model) {
        final var drivers = balanceQuery.getAll();
        model.addAttribute("drivers", drivers);
    }
}