package project.mentoringplantaform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.mentoringplantaform.model.MentoringArea;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface MentoringAreaRepository extends JpaRepository<MentoringArea,UUID> {

    public Optional<MentoringArea> findByName(String name);
    List<MentoringArea> findByNameIn(Set<String> names);

}
