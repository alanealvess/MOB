package com.example.mob.repositorios;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mob.entidades.Ong;

public interface OngRepository extends JpaRepository<Ong, Long> {
    Ong findByEmail(String email);
=======

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.mob.entidades.*;


public interface OngRepository extends JpaRepository<Ong, Long> {

>>>>>>> 45232dac7c716d6fe8d2ed401437d775e8cd0b2f
}
