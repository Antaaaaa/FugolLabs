package com.example.fugol.laboratornie.laba4.controller;


import com.example.fugol.laboratornie.laba4.service.ChickenService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/laba4")
public class EggController {
    @Autowired
    ChickenService chickenService;

    @GetMapping("/getEggAvg")
    public Double eggAvg() {
        log.info("User invoked getEggAvg endpoint");
        return chickenService.getEggAvg();
    }
}
