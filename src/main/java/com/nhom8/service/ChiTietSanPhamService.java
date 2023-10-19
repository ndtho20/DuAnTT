package com.nhom8.service;

import com.nhom8.entity.ChiTietSanPham;

import java.util.List;

public interface ChiTietSanPhamService {
    List<ChiTietSanPham> getAll();

    ChiTietSanPham addChiTietSanPham(ChiTietSanPham ChiTietSanPham);

    ChiTietSanPham getById(Long id);

    void updateChiTietSanPham(Long id, ChiTietSanPham ChiTietSanPham, Long sizeId, Long sanPhamId, Long chatLieuId,
                              Long thuongHieuId, Long mauSacId, Long xuatXuId);

    void deleteChiTietSanPham(Long id);

}
