package ConsutuctionMicroServices.example.tache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taches")
public class TacheController {
    @Autowired
    private TacheService tacheService;


    @PostMapping("/create_tache/{id_projet}")
    public ResponseEntity<?> createTache(@RequestBody Tache tache, @PathVariable int id_projet) {
        try {
            var tache1 = tacheService.create(tache, id_projet);
            return ResponseEntity.status(HttpStatus.CREATED).body(tache1);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTache(@PathVariable("id") int id) {
        tacheService.delete(id);
        return ResponseEntity.noContent().build();

    }


//    @GetMapping("/projet/{id}")
//    public List<Tache> tachesByProjet(@PathVariable int id){
//        return tacheService.tachesByIdProjet(id);
//
//}

@PutMapping("/{id}")
    public ResponseEntity<Tache>update(@PathVariable("id") int id , @RequestBody Tache tache){
    Tache updateTache=tacheService.update(id,tache);
    if(updateTache!=null){
        return ResponseEntity.ok(updateTache);
    }else {
        return ResponseEntity.notFound().build();
    }
}


    @GetMapping("/{id}")
    public ResponseEntity<Tache> getTacheById(@PathVariable("id") int id) {
        Tache tache = tacheService.getTacheById(id);
        if (tache != null) {
            return ResponseEntity.ok(tache);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public ResponseEntity<List<Tache>> getAllTaches() {
        List<Tache> taches = tacheService.getAll();
        return ResponseEntity.ok(taches);

    }

    @GetMapping("/projet/{idProjet}")
    public ResponseEntity<List<Tache>> getTachesByProjet(@PathVariable("idProjet") int idProjet) {
       List<Tache> taches= tacheService.getTachesByIdProjet(idProjet);
        return ResponseEntity.ok(taches);


        }


    @DeleteMapping("/projet/{id_projet}")
    public void deleteTachesByProjetId(@PathVariable int id_projet) {
        // Appel du service pour supprimer les tâches
        tacheService.deleteTachesByProjetId(id_projet);
    }
}
