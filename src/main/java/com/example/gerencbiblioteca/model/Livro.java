package com.example.gerencbiblioteca.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private Integer anoPublicado;
    private boolean disponivel;

    public Livro() {}

    public Livro(String titulo, Integer anoPublicado) {
        this.titulo = titulo;
        this.anoPublicado = anoPublicado;
        this.disponivel = true;
    }

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;

    @ManyToMany
    @JoinTable(
            name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;

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

    public String getSimeNaoDisponivel() {
        if (this.disponivel == true) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    @Override
    public String toString() {
        return "Titulo: " + this.getTitulo() + " | Ano de publicação: " + this.getAnoPublicado() + " | Disponível? " + this.getSimeNaoDisponivel();
    }
}
