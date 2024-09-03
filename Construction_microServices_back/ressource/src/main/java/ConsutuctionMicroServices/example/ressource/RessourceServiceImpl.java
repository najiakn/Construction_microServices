package ConsutuctionMicroServices.example.ressource;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class RessourceServiceImpl implements  RessourceService {
    @Autowired
    private RessourceRepo ressourceRepo;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Ressource create(Ressource ressource , int idTache) {
        try {
            restTemplate.getForObject("http://localhost:8070/api/taches/" +idTache, Object.class);
        }catch (Exception e){
            throw  new IllegalArgumentException("tache non trouve :" +e);
        }
        ressource.setIdTache(idTache);
        return   ressourceRepo.save(ressource);
    }

    @Override
    public void delete(int id) {
ressourceRepo.deleteById(id);
    }

    @Override
    public List<Ressource> getAll() {
        List<Ressource>ressources=ressourceRepo.findAll();
        return  ressources;
    }

    @Override
    public Ressource getRessourceById(int id) {
        Optional<Ressource> ressource = ressourceRepo.findById(id);
        return ressource.get();
    }

    @Override
    public Ressource update(int id, Ressource ressource) {
        Optional<Ressource>ressourceOptional = ressourceRepo.findById(id);
        if (ressourceOptional.isPresent()) {

            Ressource ressource1 = ressourceOptional.get();
            ressource1.setNom(ressource1.getNom());
            ressource1.setQuantite(ressource1.getQuantite());
            ressource1.setType(ressource1.getType());
            ressource1.setIdTache(ressource1.getIdTache());
            Ressource updateRessource= ressourceRepo.save(ressource);

            return updateRessource;
        }
        else  {

            throw new EntityNotFoundException("Projet not found with id: " + id);
        }
    }

    @Override
    public void deleteRessourceByidTache(int idTache) {
        List<Ressource> ressources = ressourceRepo.findRessourcesByIdTache(idTache);

        // Si la liste n'est pas vide, supprimer toutes les tâches
        if (ressources != null && !ressources.isEmpty()) {
            ressourceRepo.deleteAll(ressources);
        }
    }

    @Override
    public List<Ressource> getRessourceByIdTache(int idTache) {
        List<Ressource>resources= ressourceRepo.findRessourcesByIdTache(idTache);


        return resources;
    }
}
