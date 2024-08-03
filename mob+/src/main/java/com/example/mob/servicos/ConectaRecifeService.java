package com.example.mob.servicos;

import com.example.mob.entidades.ConectaRecife;
import com.example.mob.repositorios.ConectaRecifeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConectaRecifeService {

    @Autowired
    private ConectaRecifeRepository conectaRecifeRepository;

    public boolean validateUser(String email, String senha) {
        ConectaRecife user = conectaRecifeRepository.findByEmail(email);
        return user != null && user.getSenha().equals(senha);
    }
}
