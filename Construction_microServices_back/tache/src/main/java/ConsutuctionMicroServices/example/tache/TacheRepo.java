package ConsutuctionMicroServices.example.tache;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheRepo extends JpaRepository<Tache, Integer> {


    List<Tache> findTachesByIdProjet(int id_projet);
}
