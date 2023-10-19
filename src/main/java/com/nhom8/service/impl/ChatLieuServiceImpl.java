package com.nhom8.service.impl;

import com.nhom8.entity.ChatLieu;
import com.nhom8.repository.ChatLieuRepository;
import com.nhom8.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {
    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @Override
    public List<ChatLieu> getAll(){
        return chatLieuRepository.findAll();
    };

    @Override
    public ChatLieu addChatLieu(ChatLieu chatLieu) {
        return chatLieuRepository.save(chatLieu);
    }

    @Override
    public ChatLieu getById(Long id) {
        return chatLieuRepository.findById(id).orElse(null);
    }

    @Override
    public void updateChatLieu(Long Id, ChatLieu chatLieu) {
        Optional<ChatLieu> existingChatLieu = chatLieuRepository.findById(Id);

        if (existingChatLieu.isPresent()) {
            ChatLieu updatedChatLieu = existingChatLieu.get();
            updatedChatLieu.setMaChatLieu(chatLieu.getMaChatLieu());
            updatedChatLieu.setTenChatLieu(chatLieu.getTenChatLieu());
            updatedChatLieu.setTrangThai(chatLieu.isTrangThai());
            chatLieuRepository.save(updatedChatLieu);
        }
    }

    @Override
    public void deleteChatLieu(Long id) {
        chatLieuRepository.deleteById(id);
    }
}
