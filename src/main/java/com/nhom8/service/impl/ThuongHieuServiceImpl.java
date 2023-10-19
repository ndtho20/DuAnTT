package com.nhom8.service.impl;

import com.nhom8.entity.ThuongHieu;
import com.nhom8.repository.ThuongHieuRepository;
import com.nhom8.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {
    @Autowired
    private ThuongHieuRepository thuongHieuRepository;

    @Override
    public List<ThuongHieu> getAll() {
        return thuongHieuRepository.findAll();
    }

    ;
    @Override
    public ThuongHieu addThuongHieu(ThuongHieu thuongHieu) {
        return thuongHieuRepository.save(thuongHieu);
    }

    @Override
    public ThuongHieu getById(Long id) {
        return thuongHieuRepository.findById(id).orElse(null);
    }

    @Override
    public void updateThuongHieu(Long Id, ThuongHieu thuongHieu) {
        Optional<ThuongHieu> existingThuongHieu = thuongHieuRepository.findById(Id);

        if (existingThuongHieu.isPresent()) {
            ThuongHieu updatedThuongHieu = existingThuongHieu.get();
            updatedThuongHieu.setMaThuongHieu(thuongHieu.getMaThuongHieu());
            updatedThuongHieu.setTenThuongHieu(thuongHieu.getTenThuongHieu());
            updatedThuongHieu.setTrangThai(thuongHieu.isTrangThai());
            thuongHieuRepository.save(updatedThuongHieu);
        }
    }

    @Override
    public void deleteThuongHieu(Long id) {
        thuongHieuRepository.deleteById(id);
    }
}
