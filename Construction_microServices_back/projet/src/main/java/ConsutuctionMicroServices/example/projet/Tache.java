package ConsutuctionMicroServices.example.projet;

import jakarta.ws.rs.GET;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Tache {
    private String description;
    private Date date_debut;
    private Date date_fin;
    private String status;

}
