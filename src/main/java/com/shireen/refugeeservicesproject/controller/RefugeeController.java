package com.shireen.refugeeservicesproject.controller;


import com.shireen.refugeeservicesproject.model.Refugee;
import com.shireen.refugeeservicesproject.service.RefugeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/refugees")
public class RefugeeController {
    @Autowired
    private RefugeeService refugeeService;

    @GetMapping
    public String getAllRefugees(Model model) {
        log.info("Fetching all refugees");
        List<Refugee> refugees = refugeeService.getAllRefugees();
        model.addAttribute("refugees", refugees);
        return "refugee-list";
    }





}
