package ConsutuctionMicroServices.example.projet.repository;

import ConsutuctionMicroServices.example.projet.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepo extends JpaRepository<Projet, Integer> {
}
