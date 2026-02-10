package project.mentoringplantaform.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.mentoringplantaform.dto.AgendaDTO;
import project.mentoringplantaform.model.Agenda;

@Mapper
public interface AgendaMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "studentId", ignore = true)
    @Mapping(target = "availability", ignore = true)
    @Mapping(target = "status", ignore = true)
    Agenda toAgenda(AgendaDTO.AgendaCreateDTO agendaCreateDTO);

    @Mapping(target = "availabilityId", source = "availability.id")
    @Mapping(target = "startTime", source = "availability.startTime")
    @Mapping(target = "endTime", source = "availability.endTime")
    AgendaDTO.AgendaResponseDTO toDTO(Agenda entity);


}
