package com.nhom8.service;

import com.nhom8.entity.ChatLieu;

import java.util.List;

public interface ChatLieuService {
    List<ChatLieu> getAll();

    ChatLieu addChatLieu(ChatLieu chatLieu);

    ChatLieu getById(Long id);

    void updateChatLieu(Long id, ChatLieu chatLieu);

    void deleteChatLieu(Long id);
}
