package it.epicode.gestione_viaggi_aziendali.prenotazioni;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
}