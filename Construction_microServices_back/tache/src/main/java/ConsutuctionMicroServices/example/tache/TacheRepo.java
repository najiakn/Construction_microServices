package ConsutuctionMicroServices.example.tache;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepo extends JpaRepository<Tache, Integer> {
}
