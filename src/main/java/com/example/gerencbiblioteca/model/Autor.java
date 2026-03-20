package com.example.gerencbiblioteca.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String nacionalidade;

    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros;

    public Autor() {}

    public Autor(String nome) {
        this.nome = nome;
    }

    public Autor(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public void cadastrarAutor() {}

    public void listarAutores() {}

    public void buscarAutorPorNome() {}

    @Override
    public String toString() {
        return this.getNome() + " | " + this.getNacionalidade();
    }
}
