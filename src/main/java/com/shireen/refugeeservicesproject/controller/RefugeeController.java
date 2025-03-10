package com.shireen.refugeeservicesproject.controller;


import com.shireen.refugeeservicesproject.model.Refugee;
import com.shireen.refugeeservicesproject.service.RefugeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
//@RequestMapping("/needhelp")
public class RefugeeController {
    @Autowired
    private RefugeeService refugeeService;

//    @GetMapping("/refugee-list")
//    public String getAllRefugees(Model model) {
//            List<Refugee> refugeeList = refugeeService.getAllRefugees(); // Fetch from service
//            model.addAttribute("refugees", refugeeList); // Ensure "refugees" matches Thymeleaf
//            return "refugee-list"; // Ensure this matches the template name
//    }



    @GetMapping("/needhelp/newRefugee")
    public String createRefugee(Model model) {
        Refugee refugee = new Refugee();
        model.addAttribute("refugee", refugee);
        return "needhelp";
    }

    @PostMapping("/saveRefugee")
    public String saveRefugee(@ModelAttribute("refugee") Refugee refugee) {
        refugeeService.createRefugee(refugee);
        return "redirect:/home";
    }


}
