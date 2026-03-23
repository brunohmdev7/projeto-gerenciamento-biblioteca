# 📚 Sistema de Gerenciamento de Biblioteca

Aplicação desenvolvida em **Java (console)** com **JPA e Hibernate** para persistência de dados. O projeto simula o funcionamento básico de uma biblioteca, permitindo o gerenciamento de autores, livros e empréstimos.

Neste exato momento, o projeto está em evoulação para Web (Spring Web)

---

## 🚀 Tecnologias Utilizadas

* Java (Spring Boot)
* JPA
* Hibernate
* PostgreSQL com Docker

---

## 🎯 Objetivos do Projeto

* Praticar mapeamento de entidades
* Trabalhar com relacionamentos (@OneToMany e @ManyToOne)
* Escrever consultas utilizando JPQL
* Aplicar regras de negócio
* Compreender Lazy vs Eager loading
* Organizar o projeto em camadas (model, repository, service)

---

# 🏗️ Funcionalidades

## 👤 Autor

* Cadastrar autor
* Listar autores

## 📖 Livro

* Cadastrar livro
* Listar livros
* Buscar livros por autor

## 🔄 Empréstimo

* Emprestar livro
* Listar livros emprestados

---

# 🧱 Modelagem das Entidades

## 🖊️ Autor

* id (Long)
* nome (String)
* nacionalidade (String)
* livros (List<Livro>)

> Muitos autores podem possuir vários livros.

---

## 📘 Livro

* id (Long)
* titulo (String)
* anoPublicacao (Integer)
* disponivel (Boolean)
* autores (List<Autor>)

> Muitos livros pertencem a um ou vários autores.

---

## 📅 Emprestimo

* id (Long)
* nomeUsuario (String)
* dataEmprestimo (LocalDate)
* dataDevolucao (LocalDate)
* livro (Livro)

> Um empréstimo está ligado a um único livro, e um livro pode possuir vários empréstimos ao longo do tempo.

---

# 🖥️ Exemplo de Menu

```
1 - Cadastrar autor
2 - Listar autores
3 - Cadastrar livro
4 - Listar livros
5 - Buscar livros por autor
6 - Emprestar livro 
7 - Listar empréstimos
               
0 - Sair
```

---

# 🧠 Regras de Negócio

* Não permitir empréstimo de livro indisponível
* Ao emprestar livro → marcar como indisponível
* Não permitir cadastrar livro sem autor existente

---

# 🗂️ Estrutura de Pacotes

```
br.com.projgerbiblioteca
 ├── dto
 ├── main
 ├── model
 ├── repository
 └── service
```

---
