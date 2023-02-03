package ee.qrental.common.ui.controller;

import ee.qrental.car.application.port.in.command.CarAddCommand;
import ee.qrental.car.application.port.in.command.CarUpdateCommand;
import ee.qrental.car.application.port.in.usecase.CarAddUseCase;
import ee.qrental.car.application.port.in.usecase.CarDeleteUseCase;
import ee.qrental.car.application.port.in.usecase.CarUpdateUseCase;
import ee.qrental.car.application.port.out.CarLoadPort;
import ee.qrental.car.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarLoadPort carLoadPort;
    private final CarAddUseCase carAddUseCase;
    private final CarUpdateUseCase carUpdateUseCase;
    private final CarDeleteUseCase carDeleteUseCase;

    @GetMapping()
    public String getCarView(final Model model) {
        addCarListToModel(model);
        return "cars";
    }

    private void addCarListToModel(final Model model) {
        final var cars = carLoadPort.loadAllCars();
        model.addAttribute("cars", cars);
    }

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("carAddCommand", new CarAddCommand());
        return "addFormCar";
    }

    @PostMapping(value = "/add")
    public String addCarCar(@ModelAttribute final CarAddCommand carInfo) {
        carAddUseCase.add(carInfo);
        return "redirect:/cars";
    }

    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        final var carUpdateCommand = mapToCommand(carLoadPort.loadCarById(id));
        model.addAttribute("carUpdateCommand", carUpdateCommand);
        return "updateFormCar";
    }

    @PostMapping("/update")
    public String updateCarCar(
            final CarUpdateCommand carUpdateCommand) {
        carUpdateUseCase.update(carUpdateCommand);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") long id) {
        carDeleteUseCase.delete(id);
        return "redirect:/cars";
    }


    private CarUpdateCommand mapToCommand(final Car domain) {
        final var result = new CarUpdateCommand();
        result.setId(domain.getId());
        result.setActive(domain.getActive());
        result.setQRent(domain.getQRent());
        result.setRegNumber(domain.getRegNumber());
        result.setVin(domain.getVin());
        result.setReleaseDate(domain.getReleaseDate());
        result.setManufacturer(domain.getManufacturer());
        result.setModel(domain.getModel());
        result.setAppropriation(domain.getAppropriation());
        result.setElegance(domain.getElegance());
        result.setGearType(domain.getGearType());
        result.setFuelType(domain.getFuelType());
        result.setLpg(domain.getLpg());
        result.setDateInstallLpg(domain.getDateInstallLpg());
        result.setInsuranceFirm(domain.getInsuranceFirm());
        result.setInsuranceDateStart(domain.getInsuranceDateStart());
        result.setInsuranceDateEnd(domain.getInsuranceDateEnd());
        result.setSCard(domain.getSCard());
        result.setKey2(domain.getKey2());
        result.setGps(domain.getGps());
        result.setTechnicalInspectionEnd(domain.getTechnicalInspectionEnd());
        result.setGasInspectionEnd(domain.getGasInspectionEnd());
        result.setComment(domain.getComment());
        return result;
    }
}