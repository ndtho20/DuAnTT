package com.nhom8.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chat_lieu")
public class ChatLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idchatlieu")
    private Long idChatLieu;

    @Column(name = "machatlieu")
    private String maChatLieu;

    @Column(name = "tenchatlieu")
    private String tenChatLieu;

    @Column(name = "trangthai")
    private boolean trangThai;

}
