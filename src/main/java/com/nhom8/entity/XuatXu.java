package com.nhom8.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "xuat_xu")
public class XuatXu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idxuatxu")
    private Long idXuatXu;

    @Column(name = "maxuatxu")
    private String maXuatXu;

    @Column(name = "tenxuatxu")
    private String tenXuatXu;

    @Column(name = "trangthai")
    private boolean trangThai;
}
