package it.epicode.gestione_viaggi_aziendali.controllers;


import it.epicode.gestione_viaggi_aziendali.data.model.Viaggio;
import it.epicode.gestione_viaggi_aziendali.data.request.UpdateStatoRequest;
import it.epicode.gestione_viaggi_aziendali.repositories.ViaggioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/viaggio")
public class ViaggioController {
    private final ViaggioRepository viaggioRepository;

    @PostMapping("")
    public ResponseEntity<Boolean> createViaggio(@RequestBody Viaggio viaggio) {

        viaggioRepository.save(viaggio);

        return ResponseEntity.ok(true);
    }

    @PutMapping("")
    public ResponseEntity<Boolean> updateViaggio(@RequestBody Viaggio viaggio) {

        viaggioRepository.save(viaggio);

        return ResponseEntity.ok(true);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viaggio> getViaggio(@PathVariable("id") Long id) {

        Viaggio viaggio = viaggioRepository.findById(id).orElse(null);

        return ResponseEntity.ok(viaggio);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Boolean> deleteViaggio(@PathVariable("id") Long id) {

        viaggioRepository.deleteById(id);

        return ResponseEntity.ok(true);
    }

    @PutMapping("/update-stato")
    public ResponseEntity<Boolean> updateStato(@RequestBody UpdateStatoRequest updateStatoRequest) {
        Viaggio viaggio = viaggioRepository.findById(updateStatoRequest.getIdViaggio()).orElse(null);

        if (viaggio == null) {
            return ResponseEntity.badRequest().build();
        }
        viaggio.setStato(updateStatoRequest.getStato());
        viaggioRepository.save(viaggio);

        return ResponseEntity.ok(true);
    }

}
