package com.example.gerencbiblioteca.repository;

import com.example.gerencbiblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findAllByOrderByTituloAsc();

    @Query("SELECT l FROM Livro l JOIN l.autores a WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :nomeAutor, '%'))")
    List<Livro> findByNomeAutor(@Param("nomeAutor") String nomeAutor);
}
