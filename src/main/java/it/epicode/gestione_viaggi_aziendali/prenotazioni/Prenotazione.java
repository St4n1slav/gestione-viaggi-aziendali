package it.epicode.gestione_viaggi_aziendali.prenotazioni;


import it.epicode.gestione_viaggi_aziendali.viaggi.Viaggio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Prenotazioni")

public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate dataRichiesta;
    @Column(columnDefinition = "TEXT")
    private String noteDipendente;
    @OneToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;
}