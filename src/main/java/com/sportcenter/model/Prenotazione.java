package com.sportcenter.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataOra;

    private String stato;

    @ManyToOne
    @JoinColumn(name = "campo_sportivo_id")
    private CampoSportivo campoSportivo;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @OneToOne
    @JoinColumn(name = "pagamento_prenotazione_id")
    private Pagamento pagamento;

    // Getters and Setters
    public CampoSportivo getCampoSportivo() {
        return campoSportivo;
    }

    public void setCampoSportivo(CampoSportivo campoSportivo) {
        this.campoSportivo = campoSportivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

}
