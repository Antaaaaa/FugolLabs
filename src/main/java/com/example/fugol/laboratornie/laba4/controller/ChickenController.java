package com.example.fugol.laboratornie.laba4.controller;

import com.example.fugol.laboratornie.laba4.enums.ChickenEnum;
import com.example.fugol.laboratornie.laba4.model.Chicken;
import com.example.fugol.laboratornie.laba4.service.ChickenService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequestMapping(value = "/laba4")
public class ChickenController {
    @Autowired
    private ChickenService service;

    @GetMapping("/")
    public String index(@RequestParam(required = false, defaultValue = "0") Long eggCounter,
                        Model model) {
        model.addAttribute("chickens", service.getAllChickensByEggCounterGreaterThan(eggCounter));
        log.info("User invoked basic laba4 endpoint");
        return "starterLaba4";
    }

    @PostMapping("/add")
    public String addNewChicken(@RequestParam("chickenName") String chickenName,
                              @RequestParam("chickenEnum") ChickenEnum chickenEnum,
                              @RequestParam("eggCounter") Long eggCounter) {
        service.addChicken(new Chicken(null, chickenName, chickenEnum, eggCounter));
        log.info("User invoked adding new chicken");
        return "redirect:/laba4/";
    }
}