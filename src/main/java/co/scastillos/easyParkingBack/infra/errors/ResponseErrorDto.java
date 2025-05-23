package co.scastillos.easyParkingBack.infra.errors;

import lombok.Builder;

@Builder
public record ResponseErrorDto(String field, String error) {
}
