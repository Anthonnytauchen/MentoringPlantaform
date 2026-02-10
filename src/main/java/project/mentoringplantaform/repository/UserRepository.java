package project.mentoringplantaform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.mentoringplantaform.model.User;
import project.mentoringplantaform.model.enums.UserRole;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

 // 1. Busca Complexa: Role + Nome da Área
 List<User> findByRoleAndMentoringAreas_Name(UserRole role, String name);

 // 2. Busca Exata (Login)
 Optional<User> findByEmail(String email);

 boolean existsByEmail(String email);

 // 3. Autocomplete (Busca parcial "Jo" -> "João")
 List<User> findByNameContainingIgnoreCase(String name);

 // 4. Dashboard (Contar quantos existem)
 long countByRole(UserRole role);

 // 5. Listar todos de um tipo
 List<User> findByRole(UserRole role);
}
