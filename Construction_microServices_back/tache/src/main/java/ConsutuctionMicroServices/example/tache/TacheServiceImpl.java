package ConsutuctionMicroServices.example.tache;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TacheServiceImpl implements TacheService {
    @Autowired
    private TacheRepo tacheRepo;
    @Autowired
private RestTemplate restTemplate;

    @Override
    public Tache create (Tache tache , int id_projet){
        try {
            restTemplate.getForObject("http://localhost:8090/api/projets/projet/" +id_projet, Object.class);
        }catch (Exception e){
            throw  new IllegalArgumentException("projet non trouve :" +e);
        }
        tache.setId_projet(id_projet);
      return   tacheRepo.save(tache);


    }
    @Override
  public  void delete (int id ){
        tacheRepo.deleteById(id);
    }



    @Override
    public List<Tache> getAll(){
        List<Tache>taches= tacheRepo.findAll();
        return taches;
    }


    @Override
    public  Tache getTacheById(int id){
     Optional<Tache> tache = tacheRepo.findById(id);
     return tache.get();
    }


    @Override
    public Tache update( int id , Tache tache) {
        Optional<Tache> tacheOptional = tacheRepo.findById(id);
        if (tacheOptional.isPresent()) {

            Tache tache1 = tacheOptional.get();
            tache1.setDescription(tache1.getDescription());
            tache1.setStatus(tache1.getStatus());
            tache1.setDate_debut(tache1.getDate_debut());
            tache1.setDate_fin(tache1.getDate_fin());
            tache1.setId_projet(tache1.getId_projet());
            Tache updateTache= tacheRepo.save(tache);

            return updateTache;
        }
       else  {

            throw new EntityNotFoundException("Projet not found with id: " + id);
        }
    }

//    @Override
//    public List<Tache> tachesByIdProjet(int id) {
//        return tacheRepo.findById_projet(id);
//    }
}
