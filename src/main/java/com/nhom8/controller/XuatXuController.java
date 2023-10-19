package com.nhom8.controller;


import com.nhom8.entity.XuatXu;
import com.nhom8.service.XuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/xuatxu")
public class XuatXuController {
    @Autowired
    private XuatXuService XuatXuService;

    @GetMapping()
    public String getAll(Model model) {
        List<XuatXu> dsXuatXu = XuatXuService.getAll();
        model.addAttribute("dsXuatXu", dsXuatXu);
        model.addAttribute("cl", new XuatXu());
        return "XuatXu/Index";
    }

    @PostMapping("/add")
    public String addXuatXu(@ModelAttribute XuatXu XuatXu, Model model) {
        XuatXu.setTrangThai(true);
        XuatXuService.addXuatXu(XuatXu);
        List<XuatXu> dsXuatXu = XuatXuService.getAll();
        model.addAttribute("dsXuatXu", dsXuatXu);
        return "redirect:/xuatxu";
    }

    @GetMapping("/detail/{id}")
    public String editXuatXuForm(@PathVariable("id") Long Id, Model model) {
        XuatXu XuatXu = XuatXuService.getById(Id);
        model.addAttribute("XuatXu", XuatXu);
        return "XuatXu/Detail";
    }

    @PostMapping("/update/{id}")
    public String updateXuatXu(@PathVariable("id") Long id, @ModelAttribute XuatXu XuatXu) {
        XuatXuService.updateXuatXu(id,XuatXu);
        return "redirect:/xuatxu";
    }


    @GetMapping("/delete/{id}")
    public String deleteXuatXu(@PathVariable("id") Long id) {
        XuatXuService.deleteXuatXu(id);
        return "redirect:/xuatxu";
    }
}
