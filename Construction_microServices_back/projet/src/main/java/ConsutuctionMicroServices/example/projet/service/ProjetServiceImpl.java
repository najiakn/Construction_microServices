package ConsutuctionMicroServices.example.projet.service;


import ConsutuctionMicroServices.example.projet.repository.ProjetRepo;
import ConsutuctionMicroServices.example.projet.model.Projet;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetServiceImpl implements ProjetService {
    @Autowired
    private ProjetRepo projetRepo;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Projet create (Projet projet){
      return   projetRepo.save(projet);

    }
    @Override
  public  void delete (int id ){

        // URL du service Tache
        String url = "http://localhost:8070/api/taches/projet/" + id;

        try {
            // D'abord, supprimer les tâches liées à ce projet
            restTemplate.delete(url);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la suppression des tâches pour l'ID du projet : " + id, e);
        }

        // Ensuite, supprimer le projet
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




//    @Override
//
//    public fullProjetResponse projetWithTaches(int id) {
//        Projet projet = projetRepo.findById(id)
//                .orElse(
//                        Projet.builder()
//                                .nom_projet("NOT_FOUND")
//                                .build()
//                );
//        List<Tache> taches = tacheClient.findAllTachesByProjet(id);
//        return fullProjetResponse.builder()
//                .nom_projet(projet.getNom_projet())
//                .   date_debut(projet.getDate_debut())
//                .date_fin(projet.getDate_fin())
//                .description_projet(projet.getDescription_projet())
//                .budget(projet.getBudget())
//                .taches(taches)
//                .build();
//    }
}
