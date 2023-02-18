package ee.qrental.common.ui.controller;


import ee.qrental.transaction.application.port.in.command.*;
import ee.qrental.transaction.application.port.in.usecase.ConstantDeleteUseCase;
import ee.qrental.transaction.application.port.in.usecase.ConstantAddUseCase;
import ee.qrental.transaction.application.port.in.usecase.ConstantUpdateUseCase;
import ee.qrental.transaction.application.port.out.ConstantLoadPort;
import ee.qrental.transaction.domain.Constant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;

@AllArgsConstructor

@Controller
@RequestMapping("/settings")
public class ConstantController {

    private final ConstantAddUseCase constantAddUseCase;
    private final ConstantUpdateUseCase constantUpdateUseCase;
    private final ConstantLoadPort constantLoadPort;
    private final ConstantDeleteUseCase constantDeleteUseCase;

    @GetMapping()
    public String getConstantView(final Model model) {
        addConstantListToModel(model);
        return "constants";
    }

    private void addConstantListToModel(final Model model) {
        final var constants = constantLoadPort.loadAllConstants();
        model.addAttribute("constants", constants);
    }

    @GetMapping(value = "/add-form")
    public String addForm(final Model model) {
        model.addAttribute("constantAddCommand", new ConstantAddCommand());
        return "forms/addConstant";
    }

    @PostMapping(value = "/add")
    public String addConstantConstant(@ModelAttribute final ConstantAddCommand constantInfo) {
        constantAddUseCase.add(constantInfo);
        return "redirect:/settings";
    }


    @GetMapping(value = "/update-form/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        final var constantUpdateCommand = mapToCommand(constantLoadPort.loadConstantById(id));
        model.addAttribute("constantUpdateCommand", constantUpdateCommand);
        return "forms/updateConstant";
    }

    @PostMapping("/update")
    public String updateConstantConstant(
            final ConstantUpdateCommand constantUpdateCommand) {
        constantUpdateUseCase.update(constantUpdateCommand);
        return "redirect:/settings";
    }

    @GetMapping(value = "/delete-form/{id}")
    public String deleteForm(@PathVariable("id") long id, Model model) {
        final var constant = constantLoadPort.loadConstantById(id);
        final var constantDeleteCommand = new ConstantDeleteCommand();
        constantDeleteCommand.setId(constant.getId());
        constantDeleteCommand.setObjectInfo(getObjectInfo(constant));
        model.addAttribute("constantDeleteCommand", constantDeleteCommand);
        return "forms/deleteConstant";
    }

    private String getObjectInfo(final Constant constant) {
        final var constantName = constant.getName();

        return format("Constant : %s ",
                constantName);
    }


    @PostMapping("/delete")
    public String deleteForm(final ConstantDeleteCommand constantDeleteCommand) {
        constantDeleteUseCase.delete(constantDeleteCommand);
        return "redirect:/settings";
    }

    private ConstantUpdateCommand mapToCommand(final Constant domain) {
        final var result = new ConstantUpdateCommand();
        result.setId(domain.getId());
        result.setName(domain.getName());
        result.setValue(domain.getValue());
        result.setDescription(domain.getDescription());
        result.setNegative(domain.getNegative());
        return result;
    }
}