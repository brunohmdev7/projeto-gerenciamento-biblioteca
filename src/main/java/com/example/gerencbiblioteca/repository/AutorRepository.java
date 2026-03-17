package com.example.gerencbiblioteca.repository;

import com.example.gerencbiblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findAllByOrderByNomeAsc();

    Autor findFirstByNomeContaining(String nome);
}
