package com.nhom8.service.impl;

import com.nhom8.entity.Size;
import com.nhom8.repository.SizeRepository;
import com.nhom8.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceImpl implements SizeService {
    @Autowired
    private SizeRepository sizeRepository;

    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    public Size addSize(Size size) {
        return sizeRepository.save(size);
    }

    public Size getById(Long id) {
        return sizeRepository.findById(id).orElse(null);
    }

    public void updateSize(Long Id, Size size) {
        Optional<Size> existingSize = sizeRepository.findById(Id);

        if (existingSize.isPresent()) {
            Size updatedSize = existingSize.get();
            updatedSize.setTenSize(size.getTenSize());
            updatedSize.setTrangThai(size.isTrangThai());
            sizeRepository.save(updatedSize);
        }
    }

    public void deleteSize(Long id) {
        sizeRepository.deleteById(id);
    }
}
