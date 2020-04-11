package com.ayaz.ayazpetclinic.controllers;

import com.ayaz.ayazpetclinic.model.Owner;
import com.ayaz.ayazpetclinic.model.Pet;
import com.ayaz.ayazpetclinic.model.PetType;
import com.ayaz.ayazpetclinic.model.Visit;
import com.ayaz.ayazpetclinic.services.PetService;
import com.ayaz.ayazpetclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {
    private static final String PET_CREATE_OR_UPDATE_FORM = "pets/createOrUpdateVisitForm";
    private static final String REDIRECTS_OWNERS = "redirect:/owners/{ownerId}";
    private static final String YET_ANOTHER_VISIT_DESCRIPTION = "yet another visit";


    @Mock
    VisitService visitService;

    @Mock
    PetService petService;

    @InjectMocks
    VisitController visitController;

    private Visit visit;

    private MockMvc mockMvc;

    private final UriTemplate visitsUriTemplate = new UriTemplate("/owners/{ownerId}/pets/{petId}/visits/new");
    private final Map<String, String> uriVariables = new HashMap<>();
    private URI visitsUri;

    @BeforeEach
    void setUp() {
        Long ownerId = 1L;
        Long petId = 1L;
        when(petService.findById(anyLong())).thenReturn(Pet.builder().Id(petId)
                .birthDate(LocalDate.of(2018, 1, 2))
                .name("Cutie")
                .visits(new HashSet<>())
                .owner(Owner.builder()
                        .Id(ownerId)
                        .lastName("Doe")
                        .firstName("Joe")
                        .build())
                .petType(PetType.builder().name("Dog").build())
                .build())
        ;

        uriVariables.put("ownerId", ownerId.toString());
        uriVariables.put("petId", petId.toString());
        visitsUri = visitsUriTemplate.expand(uriVariables);
        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();

    }

    @Test
    void initNewForm() throws Exception {
        mockMvc.perform(get(visitsUri))
                .andExpect(status().isOk())
                .andExpect(view().name(PET_CREATE_OR_UPDATE_FORM))
                .andExpect(model().attributeExists("visit"));
    }

    @Test
    void processCreateForm() throws Exception {
        mockMvc.perform(post(visitsUri).contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("date", "2020-04-18")
                .param("description", YET_ANOTHER_VISIT_DESCRIPTION))
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name(REDIRECTS_OWNERS))
        .andExpect(model().attributeExists("visit"));
    }
}