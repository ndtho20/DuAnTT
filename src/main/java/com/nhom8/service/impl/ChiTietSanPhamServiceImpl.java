package com.nhom8.service.impl;

import com.nhom8.entity.*;
import com.nhom8.repository.*;
import com.nhom8.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private ChatLieuRepository chatLieuRepository;
    @Autowired
    private ThuongHieuRepository thuongHieuRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private XuatXuRepository xuatXuRepository;
    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<ChiTietSanPham> getAll(){
        return chiTietSanPhamRepository.findAll();
    };

    @Override
    public ChiTietSanPham addChiTietSanPham(ChiTietSanPham ctsp) {
        return chiTietSanPhamRepository.save(ctsp);
    }

    @Override
    public ChiTietSanPham getById(Long id) {
        return chiTietSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public void updateChiTietSanPham(Long chiTietSanPhamId, ChiTietSanPham ctsp, Long sizeId, Long sanPhamId,
                                     Long chatLieuId, Long thuongHieuId, Long mauSacId, Long xuatXuId) {
        Optional<ChiTietSanPham> existingCTSP = chiTietSanPhamRepository.findById(chiTietSanPhamId);

        if (existingCTSP.isPresent()) {
            ChiTietSanPham updatedCTSP = existingCTSP.get();

            // Cập nhật thông tin sản phẩm
            updatedCTSP.setMaChiTietSanPham(ctsp.getMaChiTietSanPham());
            updatedCTSP.setTenSanPham(ctsp.getTenSanPham());
            updatedCTSP.setSoLuong(ctsp.getSoLuong());
            updatedCTSP.setMoTa(ctsp.getMoTa());
            updatedCTSP.setTrangThai(ctsp.getTrangThai());

            // Lấy và cập nhật thông tin sản phẩm
            Optional<SanPham> sanPhamOptional = sanPhamRepository.findById(sanPhamId);
            sanPhamOptional.ifPresent(updatedCTSP::setSanPham);

            // Lấy và cập nhật thông tin chất liệu
            Optional<ChatLieu> chatLieuOptional = chatLieuRepository.findById(chatLieuId);
            chatLieuOptional.ifPresent(updatedCTSP::setChatLieu);

            // Lấy và cập nhật thông tin thương hiệu
            Optional<ThuongHieu> thuongHieuOptional = thuongHieuRepository.findById(thuongHieuId);
            thuongHieuOptional.ifPresent(updatedCTSP::setThuongHieu);

            // Lấy và cập nhật thông tin màu sắc
            Optional<MauSac> mauSacOptional = mauSacRepository.findById(mauSacId);
            mauSacOptional.ifPresent(updatedCTSP::setMauSac);

            // Lấy và cập nhật thông tin xuất xứ
            Optional<XuatXu> xuatXuOptional = xuatXuRepository.findById(xuatXuId);
            xuatXuOptional.ifPresent(updatedCTSP::setXuatXu);

            // Lấy và cập nhật thông tin kích thước
            Optional<Size> sizeOptional = sizeRepository.findById(sizeId);
            sizeOptional.ifPresent(updatedCTSP::setSize);

            chiTietSanPhamRepository.save(updatedCTSP);
        }
    }

    @Override
    public void deleteChiTietSanPham(Long id) {
        chiTietSanPhamRepository.deleteById(id);
    }
}
