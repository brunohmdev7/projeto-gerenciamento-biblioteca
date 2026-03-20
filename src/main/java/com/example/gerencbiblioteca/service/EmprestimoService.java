package com.example.gerencbiblioteca.service;

import com.example.gerencbiblioteca.model.Emprestimo;
import com.example.gerencbiblioteca.repository.EmprestimoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;

    public Emprestimo adicionarEmprestimoNoBanco(Emprestimo emprestimo) { return emprestimoRepository.save(emprestimo); }
}

