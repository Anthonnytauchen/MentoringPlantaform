package project.mentoringplantaform.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="tb_mentoring_areas")
public class MentoringArea {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

}
