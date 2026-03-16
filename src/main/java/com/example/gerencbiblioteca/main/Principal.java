package com.example.gerencbiblioteca.main;

import com.example.gerencbiblioteca.model.Autor;
import com.example.gerencbiblioteca.repository.EmprestimoRepository;
import com.example.gerencbiblioteca.service.AutorService;
import com.example.gerencbiblioteca.service.EmprestimoService;
import com.example.gerencbiblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class Principal {
    Scanner teclado = new Scanner(System.in);

    private final LivroService livroService;
    private final AutorService autorService;
    private final EmprestimoService emprestimoService;

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
                1 - Cadastrar autor
                2 - Listar autores
                3 - Cadastrar livro
                4 - Listar livros
                5 - Buscar livros por autor
                6 - Emprestar livro
                7 - Devolver livro
                8 - Listar empréstimos
                0 - Sair
                """);

            switch (opcao) {
                case 1:
                    cadastrarAutor();
            }
        }
    }

    private void cadastrarAutor() {
        System.out.println("Digite aqui o nome do autor que você deseja cadastrar: ");
        String nome = teclado.nextLine();
        System.out.println("Digite aqui qual país ele nasceu: ");
        String nacionalidade = teclado.nextLine();

        Autor autor = new Autor(nome, nacionalidade);
        autorService.adicionaAutorNoBanco(autor);
    }
}
