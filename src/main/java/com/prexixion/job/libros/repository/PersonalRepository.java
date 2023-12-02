package com.prexixion.job.libros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prexixion.job.libros.model.Personal;

public interface PersonalRepository extends JpaRepository<Personal, String> {
    // Puedes agregar consultas personalizadas si es necesario
}
