package project.mentoringplantaform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.mentoringplantaform.dto.UserDto;
import project.mentoringplantaform.mapper.UserMapper;
import project.mentoringplantaform.model.MentoringArea;
import project.mentoringplantaform.repository.MentoringAreaRepository;
import project.mentoringplantaform.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MentoringAreaRepository mentoringAreaRepository;

    //@Autowired
    //private PasswordEnconder passwordEnconder;

    public UserDto.UserResponseDTO createdUser(UserDto.UserCreateDTO userCreateDTO){

        if(userRepository.existsByEmail(userCreateDTO.email()))throw new RuntimeException("Usuario ja esta cadatrado");

       var user = mapper.toEntity(userCreateDTO);

        Set<MentoringArea> areasUser = new HashSet<>();

        if (userCreateDTO.mentoringAreas()!= null){
            areasUser = userCreateDTO.mentoringAreas().stream()
                    .map(nameArea -> mentoringAreaRepository.findByName(nameArea)
                            .orElseGet(()->{
                             MentoringArea newArea = new MentoringArea();
                            newArea.setName(nameArea);
                            return mentoringAreaRepository.save(newArea);
            })).collect(Collectors.toSet());
            //.collect(Collectors.toSet()): Pega todos os objetos MentoringArea que saíram do fluxo e empacota num Set (Conjunto) para você salvar no Usuário.
        }
        user.setMentoringAreas(areasUser);

        var userSave = userRepository.save(user);

        return mapper.toResponseDTO(userSave);
    }


}
