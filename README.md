<h1>Stoom Store API</h1>

API desenvolvida para testar as habilidades de desenvolvimento backend do candidato à Stoom. Seguem as instruções para o funcionamento do projeto com o intuito de demonstrar suas funcionalidades conforme requeridas.

<h2>Tecnologias</h2>

Foram utilizadas as seguintes tecnologias:

- Java 17.0.10
- Spring Boot 2.3.0
- Apache Maven 3.9.6
- Postgresql 16.1-1

<h2>Instruções</h2>

É necessário para o funcionamento adequeado do projeto que haja uma base de dados nomeada como `stoom_store`.
Com as devidas tecnologias disponíveis, execute o comando `mvn spring-boot:run` no diretório raiz do mesmo.

<h2>Informações</h2>

- Na raiz do projeto foi adicionado o arquivo `api_collection.json`. Esta coleção facilitará as chamadas à API;
- A API está configurada para utilizar a `porta 8080` para sua execução;
- Para a criação de um produto, será necessário a criação de uma `marca` e uma `categoria`;
- Isso pode ser feito junto, utilizando o endpoint `POST` `/product` ou em seus respectivos endpoints `POST`;
- Ao retornar uma `marca` ou `categoria` serão retornados também seus produtos;
- O arquivo `application-dev.yml` foi inserido com objetivo de padronizar e facilitar a transição de futuros ambientes através de perfis.
