package ma.enset.tp_gestion_cabinet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Size(min=2, max=30, message = "Le nom doit être compris entre 2 et 30 caractères.")
    private String nom;

    @NonNull
    @Size(min=2, max=30, message = "Le prénom doit être compris entre 2 et 30 caractères.")
    private String prenom;


    @Size(min=10, max=20, message = "Le numéro de tél doit être compris entre 10 et 20 caractères.")
    @Column(length = 20)
    private String tel;

    @Email(message = "Veuillez fournir une adresse courriel valide")
    @Column(length = 50)
    private String email;

    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultations;

}
