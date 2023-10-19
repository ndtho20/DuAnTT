package com.nhom8.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsanpham")
    private Long idSanPham;

    @Column(name = "masanpham")
    private String maSanPham;

    @Column(name = "tensanpham")
    private String tenSanPham;

    @Column(name = "trangthai")
    private boolean trangThai;

}
