package project.mentoringplantaform.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.mentoringplantaform.dto.AvailabilityDTO;
import project.mentoringplantaform.model.Availability;

@Mapper(componentModel = "spring")
public interface AvailabilityMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "currentParticipants", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "mentoringAreaId", ignore = true)
    @Mapping(target = "mentorId", ignore = true)
   Availability toEntity(AvailabilityDTO.AvailabilityCreateDTO availabilityCreateDTO);

    AvailabilityDTO.AvailabilityResponseDTO toDTO(Availability entity);
}
