package com.sportcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportcenter.dto.PrenotazioneRequest;
import com.sportcenter.model.Prenotazione;
import com.sportcenter.repository.PrenotazioneRepository;
import com.sportcenter.service.PrenotazioneService;

@RequestMapping
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
    
    

//    @PostMapping
//    public Prenotazione create(@RequestBody PrenotazioneRequest prenotazioneRequest) {
        // logica necessaria per
        // 1. recuperare l'utente dal repository UtenteRepository
        // 2. recuperare il campoSportivo dal repository CampoSportivoRepository
        // 3. settare i valori in un oggetto Prenotazione
        // 4. salvare
//        return prenotazioneService.create(prenotazioneRequest);
//    }

}
