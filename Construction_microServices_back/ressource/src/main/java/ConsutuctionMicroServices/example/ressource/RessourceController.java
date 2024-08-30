package ConsutuctionMicroServices.example.ressource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ressources")
public class RessourceController {

    @Autowired
    private RessourceService ressourceService;


    @PostMapping("/create_ressource/{idTache}")
    public ResponseEntity<?> createRessource(@RequestBody Ressource ressource, @PathVariable int idTache) {
        try {
            var ressource1 = ressourceService.create(ressource, idTache);
            return ResponseEntity.status(HttpStatus.CREATED).body(ressource1);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRessource(@PathVariable("id") int id) {
        ressourceService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Ressource>update(@PathVariable("id") int id , @RequestBody Ressource ressource){
        Ressource updateRessource=ressourceService.update(id,ressource);
        if(updateRessource!=null){
            return ResponseEntity.ok(updateRessource);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ressource> getRessourceById(@PathVariable("id") int id) {
        Ressource ressource = ressourceService.getRessourceById(id);
        if (ressource != null) {
            return ResponseEntity.ok(ressource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public ResponseEntity<List<Ressource>> getAll() {
        List<Ressource> ressources = ressourceService.getAll();
        return ResponseEntity.ok(ressources);

    }

    @GetMapping("/tache/{idTache}")
    public ResponseEntity<List<Ressource>> getTachesByProjet(@PathVariable("idTache") int idTache) {
        List<Ressource> ressources= ressourceService.getRessourceByIdTache(idTache);
        return ResponseEntity.ok(ressources);


    }


    @DeleteMapping("/tache/{idTache}")
    public void deleteRessourcesByIdTache(@PathVariable int idTache) {
        // Appel du service pour supprimer les tâches
        ressourceService.deleteRessourceByidTache(idTache);
    }
}



