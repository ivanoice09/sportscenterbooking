
package com.sportcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sportcenter.dto.AuthRequest;
import com.sportcenter.dto.RegisterUserRequest;
import com.sportcenter.model.Ruolo;
import com.sportcenter.model.Utente;
import com.sportcenter.repository.RuoloRepository;
import com.sportcenter.repository.UtenteRepository;

@Service
public class AuthService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private RuoloRepository ruoloRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(RegisterUserRequest registerUserRequest) {
        registerUserRequest.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));

        // creazione utente con credenziali
        Utente utente = new Utente();

        utente.setUsername(registerUserRequest.getUsername());
        utente.setEmail(registerUserRequest.getEmail());
        utente.setPassword(registerUserRequest.getPassword());
        
        // assegnazione ruolo
        Ruolo ruoloObj = ruoloRepository.findByRuolo(registerUserRequest.getRuolo())
            .orElseThrow(() -> new RuntimeException("Ruolo non trovato"));

        if(utente.getRuoli().add(ruoloObj)) {
            utenteRepository.save(utente);
        }

    }

    public String login(AuthRequest authRequest) {
        // Validazione dell'utente e generazione del token JWT (da implementare)
        return "token_jwt";
    }
}
