package com.example.ufo.controller;

import com.example.ufo.model.ShapeType;
import com.example.ufo.model.Sighting;
import com.example.ufo.service.SightingService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sightings")
public class SightingController {

    private final SightingService service;

    public SightingController(SightingService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("sightings", service.listAll());
        return "sightings/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("sighting", new Sighting());
        model.addAttribute("shapes", ShapeType.values());
        return "sightings/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("sighting") Sighting sighting,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes ra) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("shapes", ShapeType.values());
            return "sightings/form";
        }

        service.save(sighting);
        ra.addFlashAttribute("msg", "Sighting cadastrado com sucesso!");
        return "redirect:/sightings";
    }
}
