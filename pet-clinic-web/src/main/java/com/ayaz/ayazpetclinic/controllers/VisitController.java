package com.ayaz.ayazpetclinic.controllers;

import com.ayaz.ayazpetclinic.model.Pet;
import com.ayaz.ayazpetclinic.model.Visit;
import com.ayaz.ayazpetclinic.services.PetService;
import com.ayaz.ayazpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

@Controller
@RequestMapping("owners/{ownerId}/pets/{petId}")
public class VisitController {
    private static final String CREATE_UPDATE_VISITS = "pets/createOrUpdateVisitForm";
    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException{
                setValue(LocalDate.parse(text));//sor
            }
        });

    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Model model) {
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    @GetMapping("/visits/new")
    public String initNewForm(@PathVariable("petId") Long petId) {
        return CREATE_UPDATE_VISITS;
    }

    @PostMapping("/visits/new")
    public String processCreateForm(@Valid Visit visit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return CREATE_UPDATE_VISITS;
        } else {
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }

}
