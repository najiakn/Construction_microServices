package ConsutuctionMicroServices.example.ressource;

import java.util.List;

public interface RessourceService {
    Ressource create (Ressource ressource , int idTache);
    void delete (int id);
    List<Ressource> getAll();
    Ressource getRessourceById(int id );
    Ressource update(int id,Ressource ressource);
    void deleteRessourceByidTache(int idTache);
    //   List<Tache> tachesByIdProjet(int id);
    List<Ressource>  getRessourceByIdTache(int idTache);

}
