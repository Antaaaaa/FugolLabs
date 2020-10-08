package com.example.fugol.laboratornie.laba3.controller;


import com.example.fugol.laboratornie.laba3.service.MathService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/laba3")
@RequiredArgsConstructor
public class MathController {
    private static final String MAX_ATTRIBUTE = "max";
    @Autowired
    private MathService mathService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) List<Double> array){
        if (array == null) model.addAttribute(MAX_ATTRIBUTE, "");
        else { model.addAttribute(MAX_ATTRIBUTE, mathService.findMaxElement(array)); }
        return "starterLaba3";
    }
}
