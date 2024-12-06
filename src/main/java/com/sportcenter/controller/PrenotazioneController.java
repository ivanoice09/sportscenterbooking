package com.sportcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportcenter.dto.PrenotazioneRequest;
import com.sportcenter.dto.PrenotazioneResponse;
import com.sportcenter.model.Prenotazione;
import com.sportcenter.repository.PrenotazioneRepository;
import com.sportcenter.service.PrenotazioneService;

@RequestMapping("api/prenotazione")
@RestController
public class PrenotazioneController {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping()
    public List<Prenotazione> getAllPrenotazione() {
        return prenotazioneRepository.findAll();
    }

    @PostMapping
    public PrenotazioneResponse create(@RequestBody PrenotazioneRequest prenotazioneRequest) {
        // logica necessaria per
        // 1. recuperare l'utente dal repository UtenteRepository
        // 2. recuperare il campoSportivo dal repository CampoSportivoRepository
        // 3. settare i valori in un oggetto Prenotazione
        // 4. salvare

        Prenotazione prenotazione = prenotazioneService.create(prenotazioneRequest);
        // 5. trasforma la prenotazione in prenotazioneReponse e ritorno
        // 6. restituisco l'oggetto appena creato
        PrenotazioneResponse response = mapToReponse(prenotazione);

        return response;
    }

    private PrenotazioneResponse mapToReponse(Prenotazione prenotazione) {
        PrenotazioneResponse response = new PrenotazioneResponse();

        response.setId(prenotazione.getId());
        response.setCampoSportivoId(prenotazione.getCampoSportivo().getId());
        response.setStato(prenotazione.getStato());
        response.setUtenteId(prenotazione.getUtente().getId());
        response.setDataOra(prenotazione.getDataOra());

        return response;

    }

    

}
