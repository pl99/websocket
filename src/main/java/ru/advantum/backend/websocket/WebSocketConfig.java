package ru.advantum.backend.websocket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Bean
    public WebSocketHandler myMessageHandler() {
        return new WsHandler();
    }

    @Value("${ws.endpoint:/ws}")
    private String[] wsEndpoint;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        https://stackoverflow.com/a/30776269
        registry.addHandler(myMessageHandler(), wsEndpoint).setAllowedOrigins("*");
    }

}