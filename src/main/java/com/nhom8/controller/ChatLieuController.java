package com.nhom8.controller;

import com.nhom8.entity.ChatLieu;
import com.nhom8.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chatlieu")
public class ChatLieuController {
    @Autowired
    private ChatLieuService chatLieuService;

    @GetMapping()
    public String getAll(Model model) {
        List<ChatLieu> dsChatLieu = chatLieuService.getAll();
        model.addAttribute("dsChatLieu", dsChatLieu);
        model.addAttribute("cl", new ChatLieu());
        return "ChatLieu/Index";
    }

    @PostMapping("/add")
    public String addChatLieu(@ModelAttribute ChatLieu chatLieu, Model model) {
        chatLieu.setTrangThai(true);
        chatLieuService.addChatLieu(chatLieu);
        List<ChatLieu> dsChatLieu = chatLieuService.getAll();
        model.addAttribute("dsChatLieu", dsChatLieu);
        return "redirect:/chatlieu";
    }

    @GetMapping("/detail/{id}")
    public String editChatLieuForm(@PathVariable("id") Long Id, Model model) {
        ChatLieu chatLieu = chatLieuService.getById(Id);
        model.addAttribute("chatLieu", chatLieu);
        return "ChatLieu/Detail";
    }

    @PostMapping("/update/{id}")
    public String updateChatLieu(@PathVariable("id") Long id, @ModelAttribute ChatLieu chatLieu) {
        chatLieuService.updateChatLieu(id,chatLieu);
        return "redirect:/chatlieu";
    }


    @GetMapping("/delete/{id}")
    public String deleteChatLieu(@PathVariable("id") Long id) {
        chatLieuService.deleteChatLieu(id);
        return "redirect:/chatlieu";
    }
}
