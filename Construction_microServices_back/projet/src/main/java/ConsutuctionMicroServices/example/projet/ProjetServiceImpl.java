package ConsutuctionMicroServices.example.projet;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetServiceImpl implements ProjetService {
    @Autowired
    private ProjetRepo projetRepo;


    @Override
    public Projet create (Projet projet){
      return   projetRepo.save(projet);

    }
    @Override
  public  void delete (int id ){
        projetRepo.deleteById(id);
    }



    @Override
    public List<Projet> getAll(){
        List<Projet>projets=projetRepo.findAll();
        return projets;
    }


    @Override
    public  Projet getprojetById(int id){
     Optional<Projet> projet = projetRepo.findById(id);
     return projet.get();
    }


    @Override
    public Projet update( int id , Projet projet) {
        Optional<Projet> projetOptional = projetRepo.findById(id);
        if (projetOptional.isPresent()) {

            Projet projet1 = projetOptional.get();
            projet1.setNom_projet(projet1.getNom_projet());
            projet1.setDescription_projet(projet1.getDescription_projet());
            projet1.setBudget(projet1.getBudget());
            projet1.setDate_fin(projet1.getDate_fin());
            projet1.setDate_debut(projet1.getDate_debut());
            Projet updateProjet = projetRepo.save(projet);

            return updateProjet;
        }
       else  {

            throw new EntityNotFoundException("Projet not found with id: " + id);
        }
    }
}
