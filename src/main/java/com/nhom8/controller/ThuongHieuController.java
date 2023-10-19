package com.nhom8.controller;


import com.nhom8.entity.ThuongHieu;
import com.nhom8.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/thuonghieu")
public class ThuongHieuController {
    @Autowired
    private ThuongHieuService thuongHieuService;

    @GetMapping()
    public String getAll(Model model) {
        List<ThuongHieu> dsThuongHieu = thuongHieuService.getAll();
        model.addAttribute("dsThuongHieu", dsThuongHieu);
        model.addAttribute("cl", new ThuongHieu());
        return "ThuongHieu/Index";
    }

    @PostMapping("/add")
    public String addThuongHieu(@ModelAttribute ThuongHieu ThuongHieu, Model model) {
        ThuongHieu.setTrangThai(true);
        thuongHieuService.addThuongHieu(ThuongHieu);
        List<ThuongHieu> dsThuongHieu = thuongHieuService.getAll();
        model.addAttribute("dsThuongHieu", dsThuongHieu);
        return "redirect:/thuonghieu";
    }

    @GetMapping("/detail/{id}")
    public String editThuongHieuForm(@PathVariable("id") Long Id, Model model) {
        ThuongHieu ThuongHieu = thuongHieuService.getById(Id);
        model.addAttribute("ThuongHieu", ThuongHieu);
        return "ThuongHieu/Detail";
    }

    @PostMapping("/update/{id}")
    public String updateThuongHieu(@PathVariable("id") Long id, @ModelAttribute ThuongHieu ThuongHieu) {
        thuongHieuService.updateThuongHieu(id,ThuongHieu);
        return "redirect:/thuonghieu";
    }


    @GetMapping("/delete/{id}")
    public String deleteThuongHieu(@PathVariable("id") Long id) {
        thuongHieuService.deleteThuongHieu(id);
        return "redirect:/thuonghieu";
    }
}
