package project.mentoringplantaform.dto;

import project.mentoringplantaform.model.Availability;
import project.mentoringplantaform.model.enums.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendaDTO() {
    public record AgendaCreateDTO(
            UUID studentId,
            UUID availabilityId){ }
    public record AgendaResponseDTO(
            UUID studentId,
            UUID availabilityId,
            AppointmentStatus status,
            LocalDateTime startTime,
            LocalDateTime endTime
    ){ }
}
