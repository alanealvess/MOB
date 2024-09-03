package com.example.mob.servicos;

import com.example.mob.entidades.Cras;
import com.example.mob.entidades.Ong;
import com.example.mob.entidades.PessoaComDeficiencia;
import com.example.mob.repositorios.PessoaComDeficienciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaComDeficienciaService {

    private PessoaComDeficienciaRepository pessoaComDeficienciaRepository;

    public void savePessoa(PessoaComDeficiencia pessoaComDeficiencia) {
        pessoaComDeficienciaRepository.save(pessoaComDeficiencia);
    }

    public List<PessoaComDeficiencia> findByOng(Ong ong) {
        return pessoaComDeficienciaRepository.findByOng(ong);
    }

    public List<PessoaComDeficiencia> findByCras(Cras cras) {
        return pessoaComDeficienciaRepository.findByCras(cras);
    }
}
