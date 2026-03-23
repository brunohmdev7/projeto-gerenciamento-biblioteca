package com.example.gerencbiblioteca.repository;

import com.example.gerencbiblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    // por enquanto, acabamos usando derived queries que já vem escritas com o JpaRepository
}
