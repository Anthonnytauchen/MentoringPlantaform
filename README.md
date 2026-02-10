# 🚀 Mentoring Platform API

> **Status do Projeto:** 🚧 Em construção (MVP - Back-end Focus)

## 📋 Sobre o Projeto
API REST desenvolvida para gerenciar uma plataforma de mentorias online. O objetivo é conectar **Mentores** (que oferecem disponibilidade de horário e expertise) com **Alunos** (que buscam agendar sessões de aprendizado).

O projeto foca em boas práticas de desenvolvimento Java moderno, utilizando arquitetura em camadas, DTOs para tráfego de dados e mapeamento eficiente de objetos.

## 🛠️ Tecnologias Utilizadas

O projeto foi construído com a stack moderna do ecossistema Spring:

* **Java 17/21** - Linguagem base.
* **Spring Boot 3** - Framework principal.
* **Spring Data JPA** - Persistência de dados e Repositories.
* **Spring Security** - Criptografia de senhas (BCrypt).
* **H2 Database** - Banco de dados em memória para desenvolvimento rápido.
* **Lombok** - Redução de boilerplate (Getters/Setters/Constructors).
* **MapStruct** - Conversão de alta performance entre Entity <-> DTO.
* **Bean Validation** - Validação de dados de entrada (@NotBlank, @Email).
* **Maven** - Gerenciamento de dependências.

## 🏗️ Arquitetura e Design

O projeto segue uma **Arquitetura em Camadas (Layered Architecture)** bem definida para garantir desacoplamento e facilidade de manutenção:

1.  **Controller Layer:** Recebe as requisições HTTP e valida os dados de entrada.
2.  **Service Layer:** Contém toda a regra de negócio (ex: verificar duplicidade de e-mail, lógica de agendamento).
3.  **Repository Layer:** Interface com o
