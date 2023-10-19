package com.nhom8.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chi_tiet_san_pham")
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idchitietsanpham")
    private Long idChiTietSanPham;

    @Column(name = "machitietsanpham")
    private String maChiTietSanPham;

    @Column(name = "tensanpham")
    private String tenSanPham;

    @ManyToOne
    @JoinColumn(name = "idsanpham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "idchatlieu")
    private ChatLieu chatLieu;

    @ManyToOne
    @JoinColumn(name = "idsize")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "idthuonghieu")
    private ThuongHieu thuongHieu;

    @ManyToOne
    @JoinColumn(name = "idxuatxu")
    private XuatXu xuatXu;

    @ManyToOne
    @JoinColumn(name = "idmausac")
    private MauSac mauSac;

    @Column(name = "soluong")
    private Integer soLuong;

    @Column(name = "mota", length = 4000)
    private String moTa;

    @Column(name = "trangthai")
    private Boolean trangThai;

}
