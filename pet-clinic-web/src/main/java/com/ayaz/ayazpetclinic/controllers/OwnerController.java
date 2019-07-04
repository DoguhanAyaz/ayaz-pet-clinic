package com.ayaz.ayazpetclinic.controllers;

import com.ayaz.ayazpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners","owners/index","owners/index.html"})
    public String ListOfOwner(Model model)
    {
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }
}
