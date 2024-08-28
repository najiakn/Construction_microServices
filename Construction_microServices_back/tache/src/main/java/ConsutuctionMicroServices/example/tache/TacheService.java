package ConsutuctionMicroServices.example.tache;

import java.util.List;

public interface TacheService {
    Tache create (Tache tache);
    void delete (int id );
    List<Tache> getAll();
    Tache getTacheById(int id);
    Tache update (int id,Tache tache);
}
