# java-camel
Exemplo de Java Camel

Criamos uma rota usando os componentes file, http4, jms, validator, xslt, marshal, split, filter, direct, xpath, transform, mock, processor e errorHandler e deadLetterChannel, tudo configurado pela poderosa Camel DSL. Usamos cabeçalhos e propriedades, rotas e sub-rotas, vimos o objeto Exchange, ExchangePattern e multicast.
 Com o Camel conseguimos integrar vários endpoints quase naturalmente além da utilização dos padrões de integração, sempre do alto nível com a Camel DSL.


## desafio do mysql

No último exercício do desafio, vamos gravar as negociações no banco de dados. Nós usaremos o MySQL que você precisa já ter instalado, caso esteja com dúvidas, temos treinamentos que focam exclusivamente no MySQL na Alura. Nosso objetivo é executar um comando SQL insert para cada negociação na rota.

1) Conecte-se com o MySQL pelo terminal (ou outro cliente) para criar o banco e a tabela das negociações. Um vez conectado execute os seguintes comandos:

create database camel;
create table negociacao (id BIGINT NOT NULL AUTO_INCREMENT, preco DECIMAL(5,2), quantidade MEDIUMINT, data DATETIME, primary key (id));


