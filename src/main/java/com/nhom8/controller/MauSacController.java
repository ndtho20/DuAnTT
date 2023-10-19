package com.nhom8.controller;


import com.nhom8.entity.MauSac;
import com.nhom8.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mausac")
public class MauSacController {
    @Autowired
    private MauSacService MauSacService;

    @GetMapping()
    public String getAll(Model model) {
        List<MauSac> dsMauSac = MauSacService.getAll();
        model.addAttribute("dsMauSac", dsMauSac);
        model.addAttribute("cl", new MauSac());
        return "MauSac/Index";
    }

    @PostMapping("/add")
    public String addMauSac(@ModelAttribute MauSac MauSac, Model model) {
        MauSac.setTrangThai(true);
        MauSacService.addMauSac(MauSac);
        List<MauSac> dsMauSac = MauSacService.getAll();
        model.addAttribute("dsMauSac", dsMauSac);
        return "redirect:/mausac";
    }

    @GetMapping("/detail/{id}")
    public String editMauSacForm(@PathVariable("id") Long Id, Model model) {
        MauSac MauSac = MauSacService.getById(Id);
        model.addAttribute("MauSac", MauSac);
        return "MauSac/Detail";
    }

    @PostMapping("/update/{id}")
    public String updateMauSac(@PathVariable("id") Long id, @ModelAttribute MauSac MauSac) {
        MauSacService.updateMauSac(id,MauSac);
        return "redirect:/mausac";
    }


    @GetMapping("/delete/{id}")
    public String deleteMauSac(@PathVariable("id") Long id) {
        MauSacService.deleteMauSac(id);
        return "redirect:/mausac";
    }
}
