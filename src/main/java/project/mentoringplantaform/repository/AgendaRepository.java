package project.mentoringplantaform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.mentoringplantaform.model.Agenda;
import project.mentoringplantaform.model.enums.AppointmentStatus;

import java.util.List;
import java.util.UUID;
@Repository
public interface AgendaRepository extends JpaRepository<Agenda, UUID> {

    List<Agenda> findByStudentIdOrderByCreatedAtDesc(UUID studentId);

    boolean existsByStudentIdAndAvailabilityIdAndStatus(
            UUID studentId,
            UUID availabilityId,
            AppointmentStatus status
    );

}

