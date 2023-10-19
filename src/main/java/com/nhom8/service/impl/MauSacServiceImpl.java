package com.nhom8.service.impl;

import com.nhom8.entity.MauSac;
import com.nhom8.repository.MauSacRepository;
import com.nhom8.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;

    public List<MauSac> getAll(){
        return mauSacRepository.findAll();
    };

    public MauSac addMauSac(MauSac mauSac) {
        return mauSacRepository.save(mauSac);
    }

    public MauSac getById(Long id) {
        return mauSacRepository.findById(id).orElse(null);
    }

    public void updateMauSac(Long Id, MauSac mauSac) {
        Optional<MauSac> existingMauSac = mauSacRepository.findById(Id);

        if (existingMauSac.isPresent()) {
            MauSac updatedMauSac = existingMauSac.get();
            updatedMauSac.setMaMauSac(mauSac.getMaMauSac());
            updatedMauSac.setTenMauSac(mauSac.getTenMauSac());
            updatedMauSac.setTrangThai(mauSac.isTrangThai());
            mauSacRepository.save(updatedMauSac);
        }
    }

    public void deleteMauSac(Long id) {
        mauSacRepository.deleteById(id);
    }
}
