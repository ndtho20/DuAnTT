package com.nhom8.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "thuong_hieu")
public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idthuonghieu")
    private Long idThuongHieu;

    @Column(name = "mathuonghieu")
    private String maThuongHieu;

    @Column(name = "tenthuonghieu")
    private String tenThuongHieu;

    @Column(name = "trangthai")
    private boolean trangThai;
}
