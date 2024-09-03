package ConsutuctionMicroServices.example.ressource;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Ressource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idr;
    private String nom;
    private String type;
    private  String quantite;
    private  int idTache;
}
