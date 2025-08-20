
# CPM API

API REST desenvolvida com Spring Boot para gerenciamento de produtos e categorias.

## Sumário
- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Endpoints Principais](#endpoints-principais)
- [Como Executar](#como-executar)
- [Testes](#testes)

## Sobre o Projeto
Este projeto tem como objetivo fornecer uma API para cadastro, consulta, atualização e remoção de produtos e categorias. Ele segue boas práticas de arquitetura, utilizando camadas bem definidas (Controller, Service, Repository, Model e DTO).

## Tecnologias Utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- Lombok
- Maven
- H2, MySQL ou outro banco relacional (configurável)

## Estrutura do Projeto
```
src/
	main/
		java/
			br/com/cpm/api/
				CpmApiApplication.java
				controller/
					CategoriaController.java
					ProdutoController.java
				dto/
					ProdutoDTO.java
				model/
					Categoria.java
					Produto.java
				repository/
					CategoriaRepository.java
					ProdutoRepository.java
				service/
					CategoriaService.java
					ProdutoService.java
		resources/
			application.properties
	test/
		java/
			br/com/cpm/api/
				CpmApiApplicationTests.java
```

## Endpoints Principais

### Categorias
- `GET /categorias` — Lista todas as categorias
- `GET /categorias/{id}` — Busca categoria por ID
- `POST /categorias` — Cria uma nova categoria
- `PUT /categorias/{id}` — Atualiza uma categoria existente
- `DELETE /categorias/{id}` — Remove uma categoria

### Produtos
- `GET /produtos` — Lista todos os produtos (retorna DTO)
- `GET /produtos/{id}` — Busca produto por ID (retorna DTO)
- `POST /produtos` — Cria um novo produto
- `PUT /produtos/{id}` — Atualiza um produto existente
- `DELETE /produtos/{id}` — Remove um produto

## Como Executar
1. Clone o repositório
2. Configure o banco de dados em `src/main/resources/application.properties`
3. Execute o comando:
	 ```
	 ./mvn spring-boot:run
	 ```
	 ou
	 ```
	 mvn.cmd spring-boot:run
	 ```
4. Acesse os endpoints via Postman, Insomnia ou outro cliente HTTP

## Testes
O projeto possui teste de inicialização em `CpmApiApplicationTests.java`. Para rodar os testes:
```
./mvn test
```

## Autor
Projeto desenvolvido por [Cleyton Melo](https://github.com/CleytonW).

---
Sinta-se à vontade para contribuir ou sugerir melhorias!
