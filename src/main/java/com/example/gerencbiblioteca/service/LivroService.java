package com.example.gerencbiblioteca.service;

import com.example.gerencbiblioteca.model.Livro;
import com.example.gerencbiblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;

    public void adicionaLivroNoBanco(Livro livro) {
        livroRepository.save(livro);
    }

    public List<Livro> listarLivrosNoBanco() { return livroRepository.findAllByOrderByTituloAsc(); }
}
