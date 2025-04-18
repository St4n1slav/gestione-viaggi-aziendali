package it.epicode.gestione_viaggi_aziendali.controllers;


import it.epicode.gestione_viaggi_aziendali.data.model.Prenotazione;
import it.epicode.gestione_viaggi_aziendali.repositories.DipendenteRepository;
import it.epicode.gestione_viaggi_aziendali.repositories.PrenotazioneRepository;
import it.epicode.gestione_viaggi_aziendali.repositories.ViaggioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/prenotazione")
public class PrenotazioneController {
    private final PrenotazioneRepository prenotazioneRepository;
    private final ViaggioRepository viaggioRepository;
    private final DipendenteRepository dipendenteRepository;

    @PostMapping("")
    public ResponseEntity<Boolean> createPrenotazione(@RequestBody Prenotazione prenotazione) {

        prenotazioneRepository.save(prenotazione);

        return ResponseEntity.ok(true);
    }

    @PutMapping("")
    public ResponseEntity<Boolean> updatePrenotazione(@RequestBody Prenotazione prenotazione) {

        prenotazioneRepository.save(prenotazione);

        return ResponseEntity.ok(true);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prenotazione> getPrenotazione(@PathVariable("id") Long id) {

        Prenotazione prenotazione = prenotazioneRepository.findById(id).orElse(null);

        return ResponseEntity.ok(prenotazione);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Boolean> deletePrenotazione(@PathVariable("id") Long id) {

        prenotazioneRepository.deleteById(id);

        return ResponseEntity.ok(true);
    }


}
