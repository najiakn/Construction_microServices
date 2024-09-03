package ConsutuctionMicroServices.example.ressource;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RessourceRepo extends JpaRepository<Ressource,Integer> {
    List<Ressource> findRessourcesByIdTache(int idTache);
}
