package com.ayaz.ayazpetclinic.controllers;

import com.ayaz.ayazpetclinic.model.Owner;
import com.ayaz.ayazpetclinic.model.Pet;
import com.ayaz.ayazpetclinic.model.PetType;
import com.ayaz.ayazpetclinic.services.OwnerService;
import com.ayaz.ayazpetclinic.services.PetService;
import com.ayaz.ayazpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RequestMapping("owners/{ownerId}/")
@Controller
public class PetController {
    private final static String CREATE_UPDATE_PET_FORM = "pets/createOrUpdatePetForm";


    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public PetController(OwnerService ownerService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetType() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("pets/new")
    public String initPetCreateForm(Owner owner, Model model) {
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return CREATE_UPDATE_PET_FORM;
    }

    @PostMapping("pets/new")
    public String processPetSaveForm(Owner owner, @Valid Pet pet, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet);
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return CREATE_UPDATE_PET_FORM;
        } else {
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }

    }


    @GetMapping("pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model) {
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        return CREATE_UPDATE_PET_FORM;
    }

    @PostMapping(("pets/{petId}/edit"))
    public String processUpdateCreateForm(@Valid Pet pet, BindingResult result, Owner owner, Model model) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return CREATE_UPDATE_PET_FORM;
        } else {
            owner.getPets().add(pet);
//            pet.setId(petId);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }
}
