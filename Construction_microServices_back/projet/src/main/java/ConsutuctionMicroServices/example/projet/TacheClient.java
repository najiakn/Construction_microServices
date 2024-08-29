package ConsutuctionMicroServices.example.projet;

import lombok.Builder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "tache-service", url = "${application.config.taches-url}")
public interface TacheClient {
    @GetMapping("/projet/{id}")
    List<Tache> findAllTachesByProjet(@PathVariable int id);
}
