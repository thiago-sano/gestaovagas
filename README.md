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
- Swagger

## Swagger
`http://localhost:8080/swagger-ui/index.html`  
Auxilia na documentação a mapeamento de rotas da API. Também pode ser utilizado para testar requisições HTTP, substituindo o uso do Postman.

## API Requests

### Candidate

#### Create
`localhost:8080/candidate`  
Modelo de json passado no body da requisição
```json
{
    "username": "josedesouza",
    "name": "Jose de Souza",
    "email": "jose@gmail.com",
    "password": "1234567890",
    "description": "Desenvolvedor Java Pleno com 3 anos de experiência."
}
```

#### Authentication
`localhost:8080/candidate/auth`  
Modelo de json passado no body da requisição
```json
{
    "username": "mariadesouza",
    "password": "maria@1234"
}
```

#### Get candidate
`localhost:8080/candidate/`  
Bearer Token gerado na autenticação deve ser passado em Authorization


### Company

#### Create
`localhost:8080/company`  
Modelo de json passado no body da requisição
```json
{
    "username": "java_company",
    "password": "1234567890",
    "email": "java@company.com",
    "name": "Java Jobs",
    "website": "https://javajobs.com.br",
    "description": "Empresa responsável por vagas de Java"
}
```

#### Authentication
`localhost:8080/company/auth`  
Modelo de json passado no body da requisição
```json
{
    "username": "java_company",
    "password": "1234567890"
}
```

#### Create job
`localhost:8080/company/job`  
Bearer Token gerado na autenticação deve ser passado em Authorization  
Modelo de json passado no body da requisição
````json
{
    "companyId": "35d55a35-f11c-4337-b8ec-afe52602b63a",
    "benefits": "GymPass, Plano de Saúde, Day off no aniversário, Vale Alimentação e Refeição",
    "description": "Vaga para pessoa desenvolvedora Java, que deseja trabalhar com Spring Boot 3.0",
    "level": "JUNIOR"
}
````

# Autor
Thiago Sano

https://www.linkedin.com/in/thiago-sano