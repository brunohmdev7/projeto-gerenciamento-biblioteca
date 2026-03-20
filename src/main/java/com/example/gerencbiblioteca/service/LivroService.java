package com.example.gerencbiblioteca.service;

import com.example.gerencbiblioteca.dto.LivroDTO;
import com.example.gerencbiblioteca.model.Autor;
import com.example.gerencbiblioteca.model.Livro;
import com.example.gerencbiblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;

    public void adicionaLivroNoBanco(Livro livro) {
        livroRepository.save(livro);
    }

    @Transactional(readOnly = true)
    public List<LivroDTO> listarLivrosFormatados() {
        return livroRepository.findAllByOrderByTituloAsc()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<LivroDTO> listarLivrosFormatadosFiltrados(String palavra) {
        return livroRepository.filterByPalavra(palavra)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private LivroDTO toDTO(Livro livro) {
        String autores = livro.getAutores()
                .stream()
                .map(Autor::getNome)
                .collect(Collectors.joining(", "));

        return new LivroDTO(livro.getTitulo(), autores, livro.getAnoPublicado(), livro.getSimeNaoDisponivel());
    }

    public List<Livro> buscarLivrosPorAutor(String nomeAutor) { return livroRepository.findByNomeAutor(nomeAutor); }

    public List<Livro> filtrarLivroPorPalavra(String palavra) { return livroRepository.filterByPalavra(palavra); }

    public Optional<Livro> buscarLivroPeloNomeExato(String nomeExato) { return livroRepository.buscarPorTituloExato(nomeExato); }
}
