package com.example.mob.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mob.entidades.Cras;
import com.example.mob.repositorios.CrasRepository;

@Service
public class CrasService {
<<<<<<< HEAD

=======
>>>>>>> 45232dac7c716d6fe8d2ed401437d775e8cd0b2f
    @Autowired
    private CrasRepository crasRepository;

    public Cras saveCras(Cras cras) {
        return crasRepository.save(cras);
    }

    public List<Cras> getAllCras() {
        return crasRepository.findAll();
    }
<<<<<<< HEAD

    public Cras findByEmail(String email) {
        return crasRepository.findByEmail(email);
    }
=======
>>>>>>> 45232dac7c716d6fe8d2ed401437d775e8cd0b2f
}
