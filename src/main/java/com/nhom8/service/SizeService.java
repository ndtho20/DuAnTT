package com.nhom8.service;

import com.nhom8.entity.Size;

import java.util.List;

public interface SizeService {
    List<Size> getAll();

    Size addSize(Size Size);

    Size getById(Long id);

    void updateSize(Long id, Size Size);

    void deleteSize(Long id);
}
