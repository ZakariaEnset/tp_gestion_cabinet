package ma.enset.tp_gestion_cabinet.entity;


import jakarta.persistence.*;
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
    private String description;

    @ManyToOne
    private Patient patient;
}
