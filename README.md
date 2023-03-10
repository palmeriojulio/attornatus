# Avaliação Desenvolvedor Back-end Attornatus

O objetivo deste documento é identificar seus conhecimentos quanto às tecnologias utilizadas no cotidiano de desenvolvimento da equipe de Back-end na Attornatus Procuradoria Digital.

Esta análise propõe avaliar os seguintes temas: 

- Qualidade de código
- Java, Spring boot
- API REST
- Testes

A entrega deverá ser feita da seguinte forma:
- O prazo para entrega da avaliação será de até 7 dias após envio da mesma
- Encaminhar este documento com as perguntas respondidas e com o link do código público em sua conta do GitHub
- Opcionalmente, caso você consiga fazer o build da aplicação, poderá também informar o link de acesso


### Qualidade de código

- Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

	Funcionalidade, Usabilidade, Manutenibilidade, Confiabilidade e segurança.

- Em qual etapa da implementação você considera a qualidade de software?

	A garantir para a qualidade de um software é a utilização de um conjunto de métodos e técnicas
	usados durante todo o processo de seu desenvolvimento,

	
### Desafio Java

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:  

 - [x] Criar uma pessoa
 - [x] Editar uma pessoa
 - [x] Consultar uma pessoa
 - [x] Listar pessoas
 - [x] Criar endereço para pessoa
 - [x] Listar endereços da pessoa
 - [x] Poder informar qual endereço é o principal da pessoa  

Uma Pessoa deve ter os seguintes campos:  
- Nome
- Data de nascimento
- Endereço:
    - Logradouro 
    - CEP
    - Número
    - Cidade

### Requisitos  
	Todas as respostas da API devem ser JSON.  
	Banco de dados H2.

### Diferencial
	Testes.
	Clean Code.
 
### Será levado em avaliação 
	Estrutura, arquitetura e organização do projeto. 
	Boas práticas de programação.
	Alcance dos objetivos propostos.


### Build da aplicação em nuvem

 O projeto está na plataforma de serviço <http://railway.app> baseado em nuvem, com o banco de dados Mysql.
 
Endpoints:
	
- POST - Cadastrar pessoa - https://attornatus-production.up.railway.app/gerenciar/pessoa
- PUT  - Editar pessoa    - https://attornatus-production.up.railway.app/gerenciar/pessoa
- GET  - Litas pessoas    - https://attornatus-production.up.railway.app/gerenciar/pessoas
- GET  - Consultar pessoa - https://attornatus-production.up.railway.app/gerenciar/pessoa/{id}
- POST - Criar endereço   - https://attornatus-production.up.railway.app/gerenciar/pessoa/endereco
- GET  - Listar endereços - https://attornatus-production.up.railway.app/gerenciar/pessoa/endereco/{id}


	
