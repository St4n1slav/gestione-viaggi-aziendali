package it.epicode.gestione_viaggi_aziendali.controllers;


import it.epicode.gestione_viaggi_aziendali.data.model.Dipendente;
import it.epicode.gestione_viaggi_aziendali.data.model.Prenotazione;
import it.epicode.gestione_viaggi_aziendali.data.model.Viaggio;
import it.epicode.gestione_viaggi_aziendali.data.request.AsegnaViaggioRequest;
import it.epicode.gestione_viaggi_aziendali.repositories.DipendenteRepository;
import it.epicode.gestione_viaggi_aziendali.repositories.PrenotazioneRepository;
import it.epicode.gestione_viaggi_aziendali.repositories.ViaggioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dipendente")
public class DipendenteController {
    private final DipendenteRepository dipendenteRepository;
    private final ViaggioRepository viaggioRepository;
    private final PrenotazioneRepository prenotazioneRepository;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDipendente(@PathVariable("id") Long id) {

        dipendenteRepository.deleteById(id);

        return ResponseEntity.ok(true);
    }

    @PostMapping("/assegna-viaggio")
    public ResponseEntity<String> createAssegnaViaggio(@RequestBody AsegnaViaggioRequest asegnaViaggioRequest) {
//
//        Dipendente dipendente = dipendenteRepository.findById(asegnaViaggioRequest.getIdDipendente()).orElse(null);
//        Viaggio viaggio = viaggioRepository.findById(asegnaViaggioRequest.getIdViaggio()).orElse(null);
//
//        if (dipendente == null || viaggio == null) {
//            return ResponseEntity.badRequest().build();
//        }
//        viaggio.setDipendente(dipendente);
//        viaggioRepository.save(viaggio);
//
        try {
            assegnaDipendenteAViaggio(asegnaViaggioRequest.getIdViaggio(), asegnaViaggioRequest.getIdDipendente());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Il Dipendente ha già un viaggio in questa data");
        }
        return ResponseEntity.ok("");
    }

    @PutMapping("/{id}/profile-img")
    public ResponseEntity<Boolean> getProfileImg(@PathVariable("id") Long id, @RequestBody byte[] bait) {
        Dipendente dipendente = dipendenteRepository.findById(id).orElse(null);

        if (dipendente == null) {
            return ResponseEntity.badRequest().build();
        }
        dipendente.setImg(bait);
        dipendenteRepository.save(dipendente);

        return ResponseEntity.ok(true);
    }

    public Prenotazione assegnaDipendenteAViaggio(Long idViaggio, Long idDipendente) {
        Viaggio viaggio = viaggioRepository.findById(idViaggio).orElse(null);
        Dipendente dipendente = dipendenteRepository.findById(idDipendente).orElse(null);

        if (prenotazioneRepository.existsByDipendenteAndViaggio_DataViaggio(dipendente, viaggio.getDataViaggio())) {
            throw new IllegalStateException("Il dipendente ha già una prenotazione per quella data.");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazione.setDataRichiesta(LocalDate.now());

        return prenotazioneRepository.save(prenotazione);
    }
}
