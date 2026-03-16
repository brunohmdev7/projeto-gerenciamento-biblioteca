package com.example.gerencbiblioteca.service;

import com.example.gerencbiblioteca.model.Autor;
import com.example.gerencbiblioteca.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutorService {
    private final AutorRepository autorRepository;

    public void adicionaAutorNoBanco(Autor autor) {
        autorRepository.save(autor);
    }
}
