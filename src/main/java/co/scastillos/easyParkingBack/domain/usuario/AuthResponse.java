package co.scastillos.easyParkingBack.domain.usuario;

public record AuthResponse(String username, String message, String jwt, boolean status) {
}
