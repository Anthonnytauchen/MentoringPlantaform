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
3.  **Repository Layer:** Interface com o banco de dados.
4.  **Domain/Model:** Entidades JPA que espelham o banco.
5.  **DTOs (Records):** Objetos imutáveis para transferência de dados, garantindo que a API não exponha suas entidades internas.

### 💡 Destaques de Implementação
* **Gestão de Áreas de Mentoria:** O sistema identifica automaticamente se uma área (ex: "Java") já existe no banco ao cadastrar um mentor. Se não existir, ela é criada dinamicamente.
* **Agendamento Inteligente:** O sistema de Agenda valida disponibilidade, evita conflitos de horários e gerencia status (AGENDADO, CANCELADO, CONCLUÍDO).
* **Segurança:** As senhas nunca são salvas em texto plano; utilizamos `BCryptPasswordEncoder` antes da persistência.

## ⚙️ Como Rodar o Projeto

### Pré-requisitos
* Java 17 ou superior instalado.
* Maven instalado.

### Passo a passo
1.  Clone o repositório:
    ```bash
    git clone [https://github.com/seu-usuario/mentoring-platform.git](https://github.com/seu-usuario/mentoring-platform.git)
    ```
2.  Entre na pasta:
    ```bash
    cd mentoring-platform
    ```
3.  Instale as dependências e compile (importante para o MapStruct gerar os códigos):
    ```bash
    mvn clean install -DskipTests
    ```
4.  Execute a aplicação:
    ```bash
    mvn spring-boot:run
    ```
5.  Acesse a documentação ou teste via Postman:
    * URL Base: `http://localhost:8080`
    * H2 Console: `http://localhost:8080/h2-console`

## 📝 Endpoints Principais (WIP)

* `POST /users` - Criação de novos mentores/alunos.
* `POST /agendas` - Agendamento de mentorias.
* `GET /availabilities` - Listagem de horários disponíveis.

## 🔮 Próximos Passos (Roadmap)

O projeto está em evolução constante. As próximas features planejadas são:

- [ ] Implementar Autenticação via **JWT (JSON Web Token)**.
- [ ] Criar testes unitários com **JUnit 5 e Mockito**.
- [ ] Migrar banco de dados para **PostgreSQL/Docker**.
- [ ] Adicionar envio de e-mail de confirmação de agendamento.
- [ ] Criar filtros avançados de busca (Specification Pattern).

---
Desenvolvido por **Anthonny** como parte do portfólio de Backend Developer.
