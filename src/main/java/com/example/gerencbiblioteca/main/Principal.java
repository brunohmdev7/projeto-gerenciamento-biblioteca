package com.example.gerencbiblioteca.main;

import com.example.gerencbiblioteca.model.Autor;
import com.example.gerencbiblioteca.model.Livro;
import com.example.gerencbiblioteca.service.AutorService;
import com.example.gerencbiblioteca.service.EmprestimoService;
import com.example.gerencbiblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
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
               6 - Emprestar livro [ <-- EM DESENVOLVIMENTO ] 
               7 - Devolver livro [ <-- EM DESENVOLVIMENTO ]
               8 - Listar empréstimos [ <-- EM DESENVOLVIMENTO ]
            """);

            System.out.println("Digite a opção que você deseja:");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAutor();
                    break;
                case 2:
                    listarAutores();
                    break;
                case 3:
                    cadastrarLivro();
                    break;
                case 4:
                    buscarLivros();
                    break;
                case 5:
                    buscarLivrosPorAutor();
                    break;
            }
        }
    }

    private void listarAutores() {
        List<Autor> autores = autorService.listarAutoresDoBanco();
        System.out.println("Aqui vão todos os autores cadastrados: ");
        autores.forEach(System.out::println);
    }

    private void cadastrarAutor() {
        System.out.println("Digite aqui o nome do autor que você deseja cadastrar: ");
        String nome = teclado.nextLine();
        System.out.println("Digite aqui qual país ele nasceu: ");
        String nacionalidade = teclado.nextLine();

        Autor autor = new Autor(nome, nacionalidade);
        autorService.adicionaAutorNoBanco(autor);
        System.out.println("Autor adicionado com sucesso!");
    }

    private void cadastrarLivro() {
            System.out.println("Digite o nome do livro: ");
            String titulo = teclado.nextLine();
            System.out.println("Ano de publicação: ");
            Integer ano = teclado.nextInt();
            teclado.nextLine();

            System.out.println("Digite o nome do autor: ");
            String nomeAutor = teclado.nextLine();

            Autor autor = autorService.buscarPorNome(nomeAutor);

            if (autor == null) {
                System.out.println("Autor não encontrado. Cadastre-o primeiro.");
                return;
            }

            Livro livro = new Livro(titulo, ano);
            livro.setAutores(List.of(autor));
            livroService.adicionaLivroNoBanco(livro);

            System.out.println("Livro cadastrado com sucesso!");
    }

    private void buscarLivros() {
        List<Livro> livros = livroService.listarLivrosNoBanco();
        System.out.println("Aqui estão os livros cadastrados: ");
        livros.forEach(System.out::println);
    }

    private void buscarLivrosPorAutor() {
        System.out.println("Digite o nome do autor que deseja consultar os livros cadastrados: ");
        String nomeAutor = teclado.nextLine();
        List<Livro> livrosBuscados = livroService.buscarLivrosPorAutor(nomeAutor);

        if (livrosBuscados.isEmpty()) {
            System.out.println("Nenhum livro de " + nomeAutor + " encontrado");
        } else {
            livrosBuscados.forEach(System.out::println);
        }
    }
}
