package it.epicode.gestione_viaggi_aziendali.dipendenti;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dipendente")
public class DipendenteController {
    private final DipendenteRepository dipendenteRepository;

    @PostMapping("")
    public ResponseEntity<Boolean> createDipendente(@RequestBody Dipendente dipendente) {

        dipendenteRepository.save(dipendente);

        return ResponseEntity.ok(true);
    }

    @PutMapping("")
    public ResponseEntity<Boolean> updateDipendente(@RequestBody Dipendente dipendente) {

        dipendenteRepository.save(dipendente);

        return ResponseEntity.ok(true);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendente(@PathVariable("id") Long id) {

        Dipendente dipendente = dipendenteRepository.findById(id).orElse(null);

        return ResponseEntity.ok(dipendente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> deleteDipendente(@PathVariable("id") Long id) {

        dipendenteRepository.deleteById(id);

        return ResponseEntity.ok(true);
    }

}
