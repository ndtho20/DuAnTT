package com.nhom8.controller;


import com.nhom8.entity.SanPham;
import com.nhom8.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping()
    public String getAll(Model model) {
        List<SanPham> dsSanPham = sanPhamService.getAll();
        model.addAttribute("dsSanPham", dsSanPham);
        model.addAttribute("sp", new SanPham());
        return "SanPham/Index";
    }

    @PostMapping("/add")
    public String addSanPham(@ModelAttribute SanPham sanPham, Model model) {
        sanPham.setTrangThai(true);
        sanPhamService.addSanPham(sanPham);
        List<SanPham> dsSanPham = sanPhamService.getAll();
        model.addAttribute("dsSanPham", dsSanPham);
        return "redirect:/sanpham";
    }

    @GetMapping("/detail/{id}")
    public String editSanPhamForm(@PathVariable("id") Long Id, Model model) {
        SanPham sanPham = sanPhamService.getById(Id);
        model.addAttribute("sanpham", sanPham);
        return "SanPham/Detail";
    }

    @PostMapping("/update/{id}")
    public String updateSanPham(@PathVariable("id") Long id, @ModelAttribute SanPham sanPham) {
        sanPhamService.updateSanPham(id,sanPham);
        return "redirect:/sanpham";
    }


    @GetMapping("/delete/{id}")
    public String deleteSanPham(@PathVariable("id") Long id) {
        sanPhamService.deleteSanPham(id);
        return "redirect:/sanpham";
    }
}
