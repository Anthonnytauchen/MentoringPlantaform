package project.mentoringplantaform.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named; // <--- TEM QUE SER ESSE AQUI!

import project.mentoringplantaform.dto.UserDto;
import project.mentoringplantaform.model.MentoringArea;
import project.mentoringplantaform.model.User;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Entrada
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "mentoringAreas", ignore = true)
    User toEntity(UserDto.UserCreateDTO dto);

    // Saída
    @Mapping(target = "mentoringAreas", source = "mentoringAreas", qualifiedByName = "mapAreasToNames")
    UserDto.UserResponseDTO toResponseDTO(User user);

    // O Tradutor (Com a anotação certa)
    @Named("mapAreasToNames")
    default Set<String> mapAreasToNames(Set<MentoringArea> areas) {
        if (areas == null) {
            return Collections.emptySet();
        }
        return areas.stream()
                .map(MentoringArea::getName)
                .collect(Collectors.toSet());
    }
}
