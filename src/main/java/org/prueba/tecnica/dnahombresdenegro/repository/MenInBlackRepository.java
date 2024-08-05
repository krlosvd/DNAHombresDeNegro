package org.prueba.tecnica.dnahombresdenegro.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface MenInBlackRepository {
    boolean isAlien(String[] dna);
}
