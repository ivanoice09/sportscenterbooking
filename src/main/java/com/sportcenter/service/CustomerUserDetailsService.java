package com.sportcenter.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sportcenter.model.Ruolo;
import com.sportcenter.model.Utente;
import com.sportcenter.repository.UtenteRepository;

public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente user = utenteRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Set<GrantedAuthority> authorities = new HashSet<>();

        for(Ruolo ruolo : user.getRuoli()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + ruolo.getRuolo()));
        }

        return new User(user.getUsername(), 
                        user.getPassword(), 
                        true, 
                        true, 
                        true, 
                        true, 
                        authorities);
    }
}
