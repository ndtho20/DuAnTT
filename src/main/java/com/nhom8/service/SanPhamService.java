package com.nhom8.service;

import com.nhom8.entity.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> getAll();

    SanPham addSanPham(SanPham SanPham);

    SanPham getById(Long id);

    void updateSanPham(Long id, SanPham SanPham);

    void deleteSanPham(Long id);
}
