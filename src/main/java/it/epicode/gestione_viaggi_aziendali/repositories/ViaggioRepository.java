package it.epicode.gestione_viaggi_aziendali.repositories;



import it.epicode.gestione_viaggi_aziendali.data.model.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
}