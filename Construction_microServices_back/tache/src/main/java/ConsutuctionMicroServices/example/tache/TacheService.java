package ConsutuctionMicroServices.example.tache;

import java.util.List;

public interface TacheService {
    Tache create (Tache tache,int id_projet);
    void delete (int id );
    List<Tache> getAll();
    Tache getTacheById(int id);
    Tache update (int id,Tache tache);
     void deleteTachesByProjetId(int id_projet);
 //   List<Tache> tachesByIdProjet(int id);
   List<Tache>  getTachesByIdProjet(int idProjet);



}
