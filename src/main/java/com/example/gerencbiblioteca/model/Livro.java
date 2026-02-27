package com.example.gerencbiblioteca.model;

import jakarta.persistence.*;

import java.util.List;

public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private Integer anoPublicado;
    private boolean disponivel;

    @OneToMany(mappedBy = "livro")
    private List<Emprestimo> emprestimos;

    @ManyToOne
    private Autor autor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnoPublicado() {
        return anoPublicado;
    }

    public void setAnoPublicado(Integer anoPublicado) {
        this.anoPublicado = anoPublicado;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void cadastrarLivro() {}

    public void listarLivros() {}

    public void buscarLivroPorAno() {}

    public void listarLivrosDisponiveis() {}
}
