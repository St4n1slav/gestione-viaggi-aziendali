package it.epicode.gestione_viaggi_aziendali.data.request;

import it.epicode.gestione_viaggi_aziendali.data.model.Stato;
import lombok.Data;

@Data
public class UpdateStatoRequest {
    private Long idViaggio;
    private Stato stato;
}
