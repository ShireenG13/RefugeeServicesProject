package com.shireen.refugeeservicesproject.controller;

import com.shireen.refugeeservicesproject.model.Refugee;
import com.shireen.refugeeservicesproject.service.RefugeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/refugee-list")
public class RefugeeHubController {

    @Autowired
    private RefugeeService refugeeService;


    @GetMapping
    public String getAllRefugees(Model model) {
        List<Refugee> refugees = refugeeService.getAllRefugees();
        model.addAttribute("refugees", refugees);
        return "refugee-list"; // This corresponds to the second HTML file
    }

    @GetMapping("/delete/{id}")
    public String deleteRefugee(@PathVariable("id") Long id) {
        refugeeService.deleteRefugee(id);
        return "redirect:/refugee-list";
    }


    @GetMapping("/update/{id}")
    public String editRefugeeForm(@PathVariable("id") Long id, Model model) {
        Optional<Refugee> refugeeOptional = refugeeService.getRefugeeById(id);
        if (refugeeOptional.isPresent()) {
            model.addAttribute("refugee", refugeeOptional.get());
            return "update-refugee"; // Add this view for the update form
        }
        return "redirect:/refugee-list";

    }
//    @GetMapping("/update/{id}")
//    public String editRefugeeForm(@PathVariable("id") Long id, Model model) {
//        Refugee refugee = refugeeService.getRefugeeById(id);
//        model.addAttribute("refugee", "refugee");
//        return "update-refugee"; // Add this view for the update form
//        return "redirect:/refugee-list";
//
//    }
//    @PostMapping("/save")
//    public String saveRefugee(@ModelAttribute("refugee") Refugee refugee) {
//        refugeeService.saveRefugee(refugee);
//        return "redirect:/refugee-list";  // Redirect back to employee list
//    }

        @PostMapping("/update/{id}")
        public String updateRefugee (@PathVariable("id") Long id, @ModelAttribute("refugee") Refugee refugee){
            refugee.setRefugeeId(id);
            refugeeService.saveRefugee(refugee);
            return "redirect:/refugee-list";
        }
    }