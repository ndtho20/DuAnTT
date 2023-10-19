package com.nhom8.service;

import com.nhom8.entity.ThuongHieu;

import java.util.List;

public interface ThuongHieuService {
    List<ThuongHieu> getAll();

    ThuongHieu addThuongHieu(ThuongHieu ThuongHieu);

    ThuongHieu getById(Long id);

    void updateThuongHieu(Long id, ThuongHieu ThuongHieu);

    void deleteThuongHieu(Long id);
}
