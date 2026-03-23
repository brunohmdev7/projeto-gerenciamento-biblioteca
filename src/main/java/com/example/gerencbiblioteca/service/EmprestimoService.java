package com.example.gerencbiblioteca.service;

import com.example.gerencbiblioteca.model.Emprestimo;
import com.example.gerencbiblioteca.repository.EmprestimoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;

    public Emprestimo adicionarEmprestimoNoBanco(Emprestimo emprestimo) { return emprestimoRepository.save(emprestimo); }

    public List<Emprestimo> listarEmprestimosNoBanco() { return emprestimoRepository.findAll(); }

    public String formatarData(Emprestimo emprestimo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return emprestimo.getDataEmprestimo().format(formatter);
    }

    public String getDataFormatada(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatarData(emprestimo);
    }
}

