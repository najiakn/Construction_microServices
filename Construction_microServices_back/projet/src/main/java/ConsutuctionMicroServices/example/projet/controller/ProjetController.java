package ConsutuctionMicroServices.example.projet.controller;

import ConsutuctionMicroServices.example.projet.model.Projet;
import ConsutuctionMicroServices.example.projet.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projets")
public class ProjetController {
    @Autowired
    private ProjetService projetService;


    @PostMapping("/create_projet")
    public ResponseEntity<?> createProjet(@RequestBody Projet projet) {
        try {
            var projet1 = projetService.create(projet);
            return ResponseEntity.status(HttpStatus.CREATED).body(projet1);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProjet(@PathVariable("id") int id) {
//        projetService.delete(id);
//       return  ResponseEntity.noContent().build();
//
//}

    // Supprimer un projet existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        projetService.delete(id);
        return ResponseEntity.noContent().build();
    }

@GetMapping
    public  ResponseEntity<List<Projet>>getAllProjets(){
        List <Projet> projets =projetService.getAll();
        return  ResponseEntity.ok(projets);

}

@PutMapping("/{id}")
    public ResponseEntity<Projet>update(@PathVariable("id") int id , @RequestBody Projet projet){
    Projet updteProjet=projetService.update(id,projet);
    if(updteProjet!=null){
        return ResponseEntity.ok(updteProjet);
    }else {
        return ResponseEntity.notFound().build();
    }
}


    @GetMapping("/projet/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable("id") int id) {
        Projet projet = projetService.getprojetById(id);
        if (projet != null) {
            return ResponseEntity.ok(projet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//    @GetMapping("/{id}")
//    public fullProjetResponse projetWithTaches(@PathVariable int id){
//        return projetService.projetWithTaches(id);
//    }

}
