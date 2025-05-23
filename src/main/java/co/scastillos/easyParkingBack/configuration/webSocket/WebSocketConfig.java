package co.scastillos.easyParkingBack.configuration.webSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // Canales de salida
        registry.setApplicationDestinationPrefixes("/app"); // Canales de entrada
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOriginPatterns("http://localhost:5500").withSockJS();
    }

//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        // Los clientes se conectarán a "/ws"
//        registry.addEndpoint("/ws")
//                .setAllowedOriginPatterns("*") // Permitir cualquier origen (ajustar para producción)
//                .withSockJS(); // Fallback a SockJS si no hay soporte nativo
//    }

}
