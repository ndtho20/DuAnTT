package com.nhom8.controller;


import com.nhom8.entity.*;
import com.nhom8.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chitietsp")
public class ChiTietSanPhamControlelr {
    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private ChatLieuService chatLieuService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private ThuongHieuService thuongHieuService;
    @Autowired
    private XuatXuService xuatXuService;
    @Autowired
    private MauSacService mauSacService;


    @GetMapping()
    public String getAll(Model model) {
        List<ChiTietSanPham> dsCTSP = chiTietSanPhamService.getAll();
        List<SanPham> dsSP = sanPhamService.getAll();
        List<ChatLieu> dsCL = chatLieuService.getAll();
        List<Size> dsSize = sizeService.getAll();
        List<ThuongHieu> dsThuongHieu = thuongHieuService.getAll();
        List<XuatXu> dsXuatXu = xuatXuService.getAll();
        List<MauSac> dsMauSac = mauSacService.getAll();
        model.addAttribute("dsCTSP", dsCTSP);
        model.addAttribute("dsSP", dsSP);
        model.addAttribute("dsCL", dsCL);
        model.addAttribute("dsSize", dsSize);
        model.addAttribute("dsThuongHieu", dsThuongHieu);
        model.addAttribute("dsXuatXu", dsXuatXu);
        model.addAttribute("dsMauSac", dsMauSac);
        model.addAttribute("ctsp", new ChiTietSanPham());
        return "ChiTietSanPham/Index";
    }

    @PostMapping("/add")
    public String addChiTietSanPham(@ModelAttribute ChiTietSanPham ctsp, Model model) {
        ctsp.setTrangThai(true);
        chiTietSanPhamService.addChiTietSanPham(ctsp);
        List<ChiTietSanPham> dsCTSP = chiTietSanPhamService.getAll();
        model.addAttribute("dsCTSP", dsCTSP);
        return "redirect:/chitietsp";
    }

    @GetMapping("/detail/{id}")
    public String editChiTietSanPhamForm(@PathVariable("id") Long Id, Model model) {
        ChiTietSanPham ctsp = chiTietSanPhamService.getById(Id);
        List<SanPham> dsSP = sanPhamService.getAll();
        List<ChatLieu> dsCL = chatLieuService.getAll();
        List<Size> dsSize = sizeService.getAll();
        List<ThuongHieu> dsThuongHieu = thuongHieuService.getAll();
        List<XuatXu> dsXuatXu = xuatXuService.getAll();
        List<MauSac> dsMauSac = mauSacService.getAll();
        model.addAttribute("ctsp", ctsp);
        model.addAttribute("dsSP", dsSP);
        model.addAttribute("dsCL", dsCL);
        model.addAttribute("dsSize", dsSize);
        model.addAttribute("dsThuongHieu", dsThuongHieu);
        model.addAttribute("dsXuatXu", dsXuatXu);
        model.addAttribute("dsMauSac", dsMauSac);
        return "ChiTietSanPham/Detail";
    }

    @PostMapping("/update/{id}")
    public String updateChiTietSanPham(@PathVariable("id") Long id, @ModelAttribute ChiTietSanPham ctsp,
                                       @RequestParam Long idSize,
                                       @RequestParam Long idSanPham,
                                       @RequestParam Long idChatLieu,
                                       @RequestParam Long idThuongHieu,
                                       @RequestParam Long idMauSac,
                                       @RequestParam Long idXuatXu) {
        chiTietSanPhamService.updateChiTietSanPham(id,ctsp,idSize,idSanPham,idChatLieu,idThuongHieu,idMauSac,idXuatXu);
        return "redirect:/chitietsp";
    }


    @GetMapping("/delete/{id}")
    public String deleteChiTietSanPham(@PathVariable("id") Long id) {
        chiTietSanPhamService.deleteChiTietSanPham(id);
        return "redirect:/chitietsp";
    }
}
