package com.shireen.refugeeservicesproject.controller;


import com.shireen.refugeeservicesproject.model.Refugee;
import com.shireen.refugeeservicesproject.model.Volunteer;
import com.shireen.refugeeservicesproject.service.AideService;
import com.shireen.refugeeservicesproject.service.ItemService;
import com.shireen.refugeeservicesproject.service.RefugeeService;
import com.shireen.refugeeservicesproject.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class    MainController {

    private RefugeeService refugeeService;
    private VolunteerService volunteerService;
    private AideService aideService;
    private ItemService itemService;


    @Autowired
    public MainController(RefugeeService refugeeService, VolunteerService volunteerService, AideService aideService, ItemService itemService) {
        this.refugeeService = refugeeService;
        this.volunteerService = volunteerService;
        this.aideService = aideService;
        this.itemService = itemService;
    }


    // Show the home page
    @GetMapping("/home")
    public String getHome() {
        return "home";

    }

    // Show the login form
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }

    @GetMapping("/needhelp")
    public String getNeedhelp(Model model) {
        model.addAttribute("refugee", new Refugee());
        return "needhelp";
    }

    @GetMapping("/wanttohelp")
    public String getWanttohelp(Model model) {
        model.addAttribute("volunteer", new Volunteer());
        return "wanttohelp";
    }

    @GetMapping("/aides")
    public String getAides() {
        return "aides";
    }

//    @GetMapping("/refugee-list")
//    public String getRefugeeList() {
//        return "refugee-list";
//    }
    public String getAllRefugees(Model model) {
            List<Refugee> refugeeList = refugeeService.getAllRefugees(); // Fetch from service
            model.addAttribute("refugees", refugeeList); // Ensure "refugees" matches Thymeleaf
            return "refugee-list";
    }
}


