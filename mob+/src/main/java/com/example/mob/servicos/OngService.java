package com.example.mob.servicos;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mob.entidades.Ong;
import com.example.mob.repositorios.OngRepository;

@Service
public class OngService {

    @Autowired
    private OngRepository ongRepository;

    public void saveOng(Ong ong) {
        ongRepository.save(ong);
    }

    public Iterable<Ong> getAllOngs() {
        return ongRepository.findAll();
    }

    public Ong findByEmail(String email) {
        return ongRepository.findByEmail(email);
    }
=======

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
>>>>>>> 45232dac7c716d6fe8d2ed401437d775e8cd0b2f
}
