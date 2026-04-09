package ma.enset.tp_gestion_cabinet.entity;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.sql.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date date;

    @NotNull
    @NotBlank(message = "La description ne doit être pas vide !")
    @Size(min = 3, message = "La description doit être compris minimum 3 caractères")
    private String description;

    @NotNull
    @ManyToOne
    private Patient patient;
}
