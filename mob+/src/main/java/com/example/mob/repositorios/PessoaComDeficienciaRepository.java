package com.example.mob.repositorios;

import com.example.mob.entidades.Cras;
import com.example.mob.entidades.Ong;
import com.example.mob.entidades.PessoaComDeficiencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaComDeficienciaRepository extends JpaRepository<PessoaComDeficiencia, Long> {

    List<PessoaComDeficiencia> findByOng(Ong ong);
    List<PessoaComDeficiencia> findByCras(Cras cras);
    PessoaComDeficiencia findByEmail(String email);
}
