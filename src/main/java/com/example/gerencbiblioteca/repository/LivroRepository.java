package com.example.gerencbiblioteca.repository;

import com.example.gerencbiblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Autor, Long> {

}
