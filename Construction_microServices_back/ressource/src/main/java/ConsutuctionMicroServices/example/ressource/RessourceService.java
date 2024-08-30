package ConsutuctionMicroServices.example.ressource;

import java.util.List;

public interface RessourceService {
    Ressource create (Ressource ressource);
    void delete (int id);
    List<Ressource> getAll();
    Ressource getRessourceById(int id );
    Ressource update(int id,Ressource ressource);

}
