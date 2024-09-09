package com.example.mob.servicos;

import com.example.mob.entidades.Cras;
import com.example.mob.entidades.Ong;
import com.example.mob.entidades.PessoaComDeficiencia;
import com.example.mob.repositorios.PCDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCDService {

    @Autowired
    private PCDRepository PCDRepository;

    public void savePessoa(PessoaComDeficiencia pessoaComDeficiencia) {
        PCDRepository.save(pessoaComDeficiencia);
    }

    public List<PessoaComDeficiencia> findByOng(Ong ong) {
        return PCDRepository.findByOng(ong);
    }

    public List<PessoaComDeficiencia> findByCras(Cras cras) {
        return PCDRepository.findByCras(cras);
    }

    public PessoaComDeficiencia findByEmail(String email){return PCDRepository.findByEmail(email);}
}
