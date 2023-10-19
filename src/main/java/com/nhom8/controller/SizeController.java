package com.nhom8.controller;


import com.nhom8.entity.Size;
import com.nhom8.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/size")
public class SizeController {
    @Autowired
    private SizeService SizeService;

    @GetMapping()
    public String getAll(Model model) {
        List<Size> dsSize = SizeService.getAll();
        model.addAttribute("dsSize", dsSize);
        model.addAttribute("cl", new Size());
        return "Size/Index";
    }

    @PostMapping("/add")
    public String addSize(@ModelAttribute Size Size, Model model) {
        Size.setTrangThai(true);
        SizeService.addSize(Size);
        List<Size> dsSize = SizeService.getAll();
        model.addAttribute("dsSize", dsSize);
        return "redirect:/size";
    }

    @GetMapping("/detail/{id}")
    public String editSizeForm(@PathVariable("id") Long Id, Model model) {
        Size Size = SizeService.getById(Id);
        model.addAttribute("Size", Size);
        return "Size/Detail";
    }

    @PostMapping("/update/{id}")
    public String updateSize(@PathVariable("id") Long id, @ModelAttribute Size Size) {
        SizeService.updateSize(id,Size);
        return "redirect:/size";
    }


    @GetMapping("/delete/{id}")
    public String deleteSize(@PathVariable("id") Long id) {
        SizeService.deleteSize(id);
        return "redirect:/size";
    }
}
