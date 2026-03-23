package com.example.gerencbiblioteca.main;

import com.example.gerencbiblioteca.dto.LivroDTO;
import com.example.gerencbiblioteca.model.Autor;
import com.example.gerencbiblioteca.model.Emprestimo;
import com.example.gerencbiblioteca.model.Livro;
import com.example.gerencbiblioteca.service.AutorService;
import com.example.gerencbiblioteca.service.EmprestimoService;
import com.example.gerencbiblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
               6 - Emprestar livro 
               7 - Listar empréstimos
               
               0 - Sair
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
                case 6:
                    emprestarLivro();
                    break;
                case 7:
                    listarEmprestimos();
                    break;
                case 0:
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
        List<LivroDTO> livros = livroService.listarLivrosFormatados();
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

    private void emprestarLivro() {
        System.out.println("Digite o livro que deseja emprestar: ");
        String filtroLivro = teclado.nextLine();
        List<LivroDTO> livrosFiltrados = livroService.listarLivrosFormatadosFiltrados(filtroLivro);
        livrosFiltrados.forEach(System.out::println);

        System.out.println("Agora escolha qual exatamente você deseja: ");
        String nomeLivroExato = teclado.nextLine();
        Optional<Livro> livroExato = livroService.buscarLivroPeloNomeExato(nomeLivroExato);

        if (livroExato.isPresent() && livroExato.get().isDisponivel()) {
            LivroDTO livroExatoDTO = new LivroDTO(livroExato.get().getTitulo(),
                    livroExato.get().getAutores().toString(), livroExato.get().getAnoPublicado(), livroExato.get().getSimeNaoDisponivel());
            System.out.println(livroExatoDTO);

            System.out.println("Quantos dias você pretende ficar com o livro? (máx. 30 dias)");
            int diasEmprestimo = teclado.nextInt();
            teclado.nextLine();

            if (diasEmprestimo > 1 && diasEmprestimo < 30) {
                LocalDate dataEmprestimo = LocalDate.now();
                LocalDate dataDevolucao = dataEmprestimo.plusDays(diasEmprestimo);

                Emprestimo emprestimo = new Emprestimo(dataEmprestimo, dataDevolucao, livroExato.get());
                System.out.println("Empréstimo realizado com sucesso!");
                emprestimoService.adicionarEmprestimoNoBanco(emprestimo);
            } else {
                System.out.println("Prazo inválido! Informe um valor entre 1 e 30 dias.");
            }
        }
    }

    private void listarEmprestimos() {
        System.out.println("Aqui vão todos os empréstimos listados: ");
        List<Emprestimo> emprestimosListados = emprestimoService.listarEmprestimosNoBanco();
        emprestimosListados.forEach(e -> {
            String dataFormatada = emprestimoService.getDataFormatada(e.getId());
            System.out.println(e);
        });
    }
}
