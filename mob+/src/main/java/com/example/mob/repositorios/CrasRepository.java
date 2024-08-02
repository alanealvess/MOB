package com.example.mob.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mob.entidades.Cras;

public interface CrasRepository extends JpaRepository<Cras, Long> {
<<<<<<< HEAD
    Cras findByEmail(String email);
=======
>>>>>>> 45232dac7c716d6fe8d2ed401437d775e8cd0b2f
}
