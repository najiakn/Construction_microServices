package ConsutuctionMicroServices.example.tache;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tache
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private  Date date_debut;
    private Date date_fin;
    private String status;
    private int idProjet;
}