package com.shireen.refugeeservicesproject.controller;


import com.shireen.refugeeservicesproject.model.Refugee;
import com.shireen.refugeeservicesproject.model.Volunteer;
import com.shireen.refugeeservicesproject.service.RefugeeService;
import com.shireen.refugeeservicesproject.service.VolunteerService;
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
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;

//    @GetMapping("/refugee-list")
//    public String getAllRefugees(Model model) {
//            List<Refugee> refugeeList = refugeeService.getAllRefugees(); // Fetch from service
//            model.addAttribute("refugees", refugeeList); // Ensure "refugees" matches Thymeleaf
//            return "refugee-list"; // Ensure this matches the template name
//    }



    @GetMapping("/wanttohelp/newVolunteer")
    public String createVolunteer(Model model) {
        Volunteer volunteer = new Volunteer();
        model.addAttribute("volunteer", volunteer);
        return "wanttohelp";
    }

    @PostMapping("/saveVolunteer")
    public String saveVolunteer(@ModelAttribute("volunteer") Volunteer volunteer) {
        volunteerService.createVolunteer(volunteer);
        return "redirect:/home";
    }


}

