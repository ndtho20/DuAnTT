package com.nhom8.service.impl;

import com.nhom8.entity.SanPham;
import com.nhom8.repository.SanPhamRepository;
import com.nhom8.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    public List<SanPham> getAll(){
        return sanPhamRepository.findAll();
    };

    public SanPham addSanPham(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    public SanPham getById(Long id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    public void updateSanPham(Long Id, SanPham sanPham) {
        Optional<SanPham> existingSanPham = sanPhamRepository.findById(Id);

        if (existingSanPham.isPresent()) {
            SanPham updatedSanPham = existingSanPham.get();
            updatedSanPham.setMaSanPham(sanPham.getMaSanPham());
            updatedSanPham.setTenSanPham(sanPham.getTenSanPham());
            updatedSanPham.setTrangThai(sanPham.isTrangThai());
            sanPhamRepository.save(updatedSanPham);
        }
    }

    public void deleteSanPham(Long id) {
        sanPhamRepository.deleteById(id);
    }
}
