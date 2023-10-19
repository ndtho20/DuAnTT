package com.nhom8.service;

import com.nhom8.entity.XuatXu;

import java.util.List;

public interface XuatXuService {
    List<XuatXu> getAll();

    XuatXu addXuatXu(XuatXu XuatXu);

    XuatXu getById(Long id);

    void updateXuatXu(Long id, XuatXu XuatXu);

    void deleteXuatXu(Long id);
}

