package com.sportcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportcenter.dto.PrenotazioneRequest;
import com.sportcenter.model.Prenotazione;
import com.sportcenter.repository.CampoSportivoRepository;
import com.sportcenter.repository.PrenotazioneRepository;
import com.sportcenter.repository.UtenteRepository;

@Service
public class PrenotazioneService {

    @Autowired
    private CampoSportivoRepository campoSportivoRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione createPrenotazione(Long prenotazioneId, Long ) {
        
    }

}
