# Projeto Gestão de Vagas com Spring Boot
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/thiago-sano/gestaovagas/blob/main/LICENSE)

## Sobre o projeto
O projeto trata-se de uma aplicação backend desenvolvida na [Formação Java da Rocketseat](https://app.rocketseat.com.br/journey/java/overview).

A aplicação básica consiste em uma API que utiliza Spring Boot, Spring Security e JWT para realizar autenticação de usuário e permitir que seja realizada alguma ação específica, baseada em uma _role_.

A aplicação faz apenas o **_create_** (_company_, _candidate_ e _job_) e o **_read_** (_candidate_).

Para que seja criado o _job_, é necessário que um usuário com a _role_ **_company_** esteja autenticado.
Para que seja retornada as informações do _candidate_, é necessário que um usuário com a _role_ **_candidate_** esteja autenticado.

## Objetivos:
- Criação de API REST
- Utilização de _Docker_ para criação de um container com a imagem do _PostgreSQL_
- Implementar autenticação via JWT
- Definição de _roles_ para usuários

## Tecnologias utilizadas:
- Java
- Spring Boot
- Spring Data
- Spring Security
- JWT
- Docker
- Maven
- Apace Tomcat
- Postman

# Autor
Thiago Sano

https://www.linkedin.com/in/thiago-sano