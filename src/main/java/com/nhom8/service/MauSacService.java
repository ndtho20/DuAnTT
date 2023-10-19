package com.nhom8.service;

import com.nhom8.entity.MauSac;

import java.util.List;

public interface MauSacService {
    List<MauSac> getAll();

    MauSac addMauSac(MauSac mauSac);

    MauSac getById(Long id);

    void updateMauSac(Long id, MauSac mauSac);

    void deleteMauSac(Long id);
}
