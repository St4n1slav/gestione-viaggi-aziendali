package it.epicode.gestione_viaggi_aziendali.repositories;


import it.epicode.gestione_viaggi_aziendali.data.model.Dipendente;
import it.epicode.gestione_viaggi_aziendali.data.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByDipendenteAndViaggio_DataViaggio(Dipendente dipendente, LocalDate dataViaggio);
    List<Prenotazione> findAllByDipendente(Dipendente dipendente);
}