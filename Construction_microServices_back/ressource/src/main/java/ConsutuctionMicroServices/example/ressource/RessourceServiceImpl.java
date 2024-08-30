package ConsutuctionMicroServices.example.ressource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class RessourceServiceImpl implements  RessourceService {
    @Autowired
    private RessourceRepo ressourceRepo;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Ressource create(Ressource ressource) {
       return ressourceRepo.save(ressource);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Ressource> getAll() {
        List<Ressource>ressources=ressourceRepo.findAll();
        return  ressources;
    }

    @Override
    public Ressource getRessourceById(int id) {
        return null;
    }

    @Override
    public Ressource update(int id, Ressource ressource) {
        return null;
    }
}
