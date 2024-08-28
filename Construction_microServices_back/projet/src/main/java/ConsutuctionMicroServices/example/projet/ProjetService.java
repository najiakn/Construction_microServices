package ConsutuctionMicroServices.example.projet;

import java.util.List;

public interface ProjetService {
    Projet create (Projet projet);
    void delete (int id );
    List<Projet> getAll();
    Projet getprojetById(int id);
    Projet update (int id,Projet projet);
}
