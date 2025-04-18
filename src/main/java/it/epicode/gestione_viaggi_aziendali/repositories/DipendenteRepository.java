package it.epicode.gestione_viaggi_aziendali.repositories;


import it.epicode.gestione_viaggi_aziendali.data.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}