package com.example.gerencbiblioteca;

import com.example.gerencbiblioteca.main.Principal;
import com.example.gerencbiblioteca.service.LivroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final LivroService livroService;

    public Application(LivroService livroService) {
        this.livroService = livroService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(livroService);
        principal.exibirMenu();
    }
}
