package it.epicode.gestione_viaggi_aziendali.data.request;


import lombok.Data;

@Data
public class AsegnaViaggioRequest {
    private long idViaggio;
    private long idDipendente;
}
