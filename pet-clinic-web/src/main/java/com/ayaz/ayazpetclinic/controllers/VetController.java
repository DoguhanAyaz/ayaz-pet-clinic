package com.ayaz.ayazpetclinic.controllers;

import com.ayaz.ayazpetclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @InitBinder
    public void setAllowedField(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"/vets","vets/index","/vets/index.html","vets.html"})
    public String listVets(Model model){

        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }
}
