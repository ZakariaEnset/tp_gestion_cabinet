package ma.enset.tp_gestion_cabinet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    @Column(length = 20)
    private String tel;
    @Column(length = 50)
    private String email;
    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultations;

}
