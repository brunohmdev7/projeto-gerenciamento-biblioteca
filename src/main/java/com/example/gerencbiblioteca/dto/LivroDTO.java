package com.example.gerencbiblioteca.dto;

public record LivroDTO(String titulo, String autores, Integer ano, String disponivel) {
    @Override
    public String toString() {
        return "Titulo: " + titulo +
                " | Autor(es): " + autores +
                " | Ano: " + ano +
                " | Disponível? " + disponivel;
    }
}
