package com.nhom8.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mau_sac")
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmausac")
    private Long idMauSac;

    @Column(name = "mamausac")
    private String maMauSac;

    @Column(name = "tenmausac")
    private String tenMauSac;

    @Column(name = "trangthai")
    private boolean trangThai;
}
