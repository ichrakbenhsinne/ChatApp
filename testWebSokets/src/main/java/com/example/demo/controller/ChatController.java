package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.example.demo.model.ChatMessage;

@Controller
public class ChatController {
	
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatmess,SimpMessageHeaderAccessor headerAccessor	) {
		headerAccessor.getSessionAttributes().put("username", chatmess.getSender());
		return chatmess;
		
	}
	

	@MessageMapping("/chat.sent")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatmess)
	{
		return chatmess;
		
	}

}
