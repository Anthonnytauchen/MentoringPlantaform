package project.mentoringplantaform.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;



import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_availabilities")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(nullable = false, name = "mentor_id")
    private UUID mentorId;

    @Column(nullable = false, name = "mentoring_area_id")
    private UUID mentoringAreaId;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private boolean active = true;

    @Version
    private Long version;

    @Column(nullable = false)
    private Integer maxParticipants = 1;

    @Column(nullable = false)
    private Integer currentParticipants = 0;

    public boolean isFull(){
        return currentParticipants >= maxParticipants;
    }

}
