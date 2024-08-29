package ConsutuctionMicroServices.example.projet;

import lombok.Builder;

import java.util.Date;
import java.util.List;
@Builder
public class fullProjetResponse {
    private String nom_projet;
    private String description_projet;
    private Date date_debut;
    private Date date_fin;
    private float budget;
    List<Tache> taches;
}
