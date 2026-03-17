package com.example.gerencbiblioteca;

import com.example.gerencbiblioteca.main.Principal;
import com.example.gerencbiblioteca.service.AutorService;
import com.example.gerencbiblioteca.service.EmprestimoService;
import com.example.gerencbiblioteca.service.LivroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final LivroService livroService;
    private final AutorService autorService;
    private final EmprestimoService emprestimoService;

    public Application(LivroService livroService, AutorService autorService, EmprestimoService emprestimoService) {
        this.livroService = livroService;
        this.autorService = autorService;
        this.emprestimoService = emprestimoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(livroService, autorService, emprestimoService);
        principal.exibirMenu();
    }
}
