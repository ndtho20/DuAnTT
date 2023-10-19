package com.nhom8.service.impl;

import com.nhom8.entity.XuatXu;
import com.nhom8.repository.XuatXuRepository;
import com.nhom8.service.XuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class XuatXuServiceImpl implements XuatXuService {
    @Autowired
    private XuatXuRepository xuatXuRepository;

    @Override
    public List<XuatXu> getAll(){
        return xuatXuRepository.findAll();
    };
    @Override
    public XuatXu addXuatXu(XuatXu xuatXu) {
        return xuatXuRepository.save(xuatXu);
    }
    @Override
    public XuatXu getById(Long id) {
        return xuatXuRepository.findById(id).orElse(null);
    }
    @Override
    public void updateXuatXu(Long Id, XuatXu xuatXu) {
        Optional<XuatXu> existingXuatXu = xuatXuRepository.findById(Id);

        if (existingXuatXu.isPresent()) {
            XuatXu updatedXuatXu = existingXuatXu.get();
            updatedXuatXu.setMaXuatXu(xuatXu.getMaXuatXu());
            updatedXuatXu.setTenXuatXu(xuatXu.getTenXuatXu());
            updatedXuatXu.setTrangThai(xuatXu.isTrangThai());
            xuatXuRepository.save(updatedXuatXu);
        }
    }
    @Override
    public void deleteXuatXu(Long id) {
        xuatXuRepository.deleteById(id);
    }
}
