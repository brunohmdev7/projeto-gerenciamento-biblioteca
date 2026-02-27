# 📚 Sistema de Gerenciamento de Biblioteca

Aplicação desenvolvida em **Java (console)** com **JPA e Hibernate** para persistência de dados. O projeto simula o funcionamento básico de uma biblioteca, permitindo o gerenciamento de autores, livros e empréstimos.

Este projeto tem como objetivo consolidar conceitos fundamentais de backend, como mapeamento de entidades, relacionamentos entre tabelas, consultas com JPQL e aplicação de regras de negócio.

---

## 🚀 Tecnologias Utilizadas

* Java (Spring Boot)
* JPA
* Hibernate
* PostgreSQL

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
* Buscar autor por nome

## 📖 Livro

* Cadastrar livro
* Listar livros
* Buscar livros por autor
* Buscar livros por faixa de ano
* Listar apenas livros disponíveis

## 🔄 Empréstimo

* Emprestar livro
* Devolver livro
* Listar livros emprestados
* Listar empréstimos por usuário

---

# 🧱 Modelagem das Entidades

## 🖊️ Autor

* id (Long)
* nome (String)
* nacionalidade (String)
* livros (List<Livro>)

> Um autor pode possuir vários livros.

---

## 📘 Livro

* id (Long)
* titulo (String)
* anoPublicacao (Integer)
* disponivel (Boolean)
* autor (Autor)

> Muitos livros pertencem a um único autor.

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
7 - Devolver livro
8 - Listar empréstimos
0 - Sair
```

---

# 🧠 Regras de Negócio

* Não permitir empréstimo de livro indisponível
* Ao emprestar livro → marcar como indisponível
* Ao devolver livro → marcar como disponível
* Não permitir cadastrar livro sem autor existente

---

# 🔍 Consultas JPQL Sugeridas

* Buscar livros por nome do autor
* Buscar livros entre dois anos
* Contar quantidade de livros por autor
* Buscar autores com mais de X livros
* Listar livros mais emprestados

---

# 🗂️ Estrutura de Pacotes

```
br.com.seuprojeto
 ├── model
 ├── repository
 └── service
```

---

# 📈 Possíveis Evoluções

* Paginação de resultados
* Ordenação dinâmica
* Uso de DTOs
* Tratamento global de exceções
* Migração para Spring Boot
* Transformação em API REST

---

## 🧩 Resultado Esperado

Ao concluir o projeto, espera-se domínio sobre:

* Relacionamentos em JPA
* Escrita de consultas JPQL
* Controle de transações
* Estruturação em camadas
* Separação entre regra de negócio e acesso a dados

Este projeto serve como base para evoluir posteriormente para uma aplicação web ou API REST.
