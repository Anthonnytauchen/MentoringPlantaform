package project.mentoringplantaform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.mentoringplantaform.model.Availability;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, UUID> {

    // 1. Busca Avançada por Área (Aquele que já estava certo)
    @Query("""
        SELECT a FROM Availability a
        WHERE a.active = true
        AND a.endTime > :now
        AND a.mentoringAreaId IN (
            SELECT ma.id FROM MentoringArea ma 
            WHERE ma.name = :areaName
        )
    """)
    List<Availability> findByMentoringArea(
            @Param("areaName") String areaName,
            @Param("now") LocalDateTime now
    );

    // 2. Agenda do Mentor (Futuro): "Traga as aulas DESTE mentor, DEPOIS de agora"
    List<Availability> findByMentorIdAndStartTimeAfter(UUID mentorId, LocalDateTime now);

    // 3. Intervalo de Datas: "Traga aulas que começam ENTRE segunda e sexta"
    List<Availability> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);

    // 4. Vagas Abertas (Query Especial): "Onde participantes < maximo"
    @Query("SELECT a FROM Availability a WHERE a.currentParticipants < a.maxParticipants AND a.active = true")
    List<Availability> findAvailableSlots();
}