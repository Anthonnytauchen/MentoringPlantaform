package project.mentoringplantaform.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record AvailabilityDTO() {
    public record AvailabilityCreateDTO(
            String areaName, // "Java"
            LocalDateTime startTime,
            LocalDateTime endTime,
            Integer maxParticipants
    ) {
    }

    // Para mostrar na tela de busca
    public record AvailabilityResponseDTO(
            UUID id,
            UUID mentorId,
            String mentorName,
            String areaName,
            LocalDateTime startTime,
            LocalDateTime endTime,
            boolean isFull
    ) {
    }
}
