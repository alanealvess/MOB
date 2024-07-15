package com.example.mob.servicos;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mob.entidades.*;
import com.example.mob.repositorios.*;

@Service
public class OngService {
    @Autowired
    private OngRepository ongRepository;

    public Ong saveOng(Ong ong) {
        return ongRepository.save(ong);
    }

    public List<Ong> getAllOngs() {
        return ongRepository.findAll();
    }
}
