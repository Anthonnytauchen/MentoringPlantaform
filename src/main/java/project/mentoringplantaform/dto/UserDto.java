package project.mentoringplantaform.dto;

import project.mentoringplantaform.model.enums.UserRole;

import java.util.Set;

public record UserDto() {
    public record  UserCreateDTO(
            String name,
            String email,
            String password,
            UserRole role,
            Set<String> mentoringAreas
    ){}

    public record  UserResponseDTO(
            String name,
            String email,
            UserRole role,
            Set<String> mentoringAreas
    ){}
}
