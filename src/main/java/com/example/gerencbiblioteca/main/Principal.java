package com.example.gerencbiblioteca.main;

import java.util.Scanner;

public class Principal {
    public void exibirMenu() {
        Scanner teclado = new Scanner(System.in);
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
            }
        }
    }
}
