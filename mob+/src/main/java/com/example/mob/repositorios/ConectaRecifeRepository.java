package com.example.mob.repositorios;

import com.example.mob.entidades.ConectaRecife;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConectaRecifeRepository extends JpaRepository<ConectaRecife, Long> {
    ConectaRecife findByEmail(String email);
}