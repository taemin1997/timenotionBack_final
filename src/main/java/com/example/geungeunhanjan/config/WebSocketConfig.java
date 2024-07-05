package com.example.geungeunhanjan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker // STOMP 메시징을 사용하기 위한 설정
@EnableWebSocket // 순수 WebSocket 핸들러를 사용하기 위한 설정
public class WebSocketConfig implements WebSocketConfigurer, WebSocketMessageBrokerConfigurer {

    // STOMP 구성: 메시지 브로커 설정
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // 구독 주제 설정
        config.setApplicationDestinationPrefixes("/app"); // 발행 주제 설정
    }

    // STOMP 엔드포인트 설정
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-chat") // STOMP 연결을 위한 SockJS 엔드포인트
                .setAllowedOriginPatterns("*")
                .withSockJS();
        registry.addEndpoint("/ws-chat-handler") // 순수 WebSocket 핸들러를 위한 엔드포인트
                .setAllowedOriginPatterns("*");
    }

    // 순수 WebSocket 핸들러를 위한 핸들러 등록
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatWebSocketHandler(), "/ws-chat-handler")
                .setAllowedOriginPatterns("*")
                .addInterceptors(new HttpSessionHandshakeInterceptor());
    }

    // ChatWebSocketHandler 빈 등록
    @Bean
    public ChatWebSocketHandler chatWebSocketHandler() {
        return new ChatWebSocketHandler();
    }
}
