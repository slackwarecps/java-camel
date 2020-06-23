# java-camel
Exemplo de Java Camel

Criamos uma rota usando os componentes file, http4, jms, validator, xslt, marshal, split, filter, direct, xpath, transform, mock, processor e errorHandler e deadLetterChannel, tudo configurado pela poderosa Camel DSL. Usamos cabe�alhos e propriedades, rotas e sub-rotas, vimos o objeto Exchange, ExchangePattern e multicast.
 Com o Camel conseguimos integrar v�rios endpoints quase naturalmente al�m da utiliza��o dos padr�es de integra��o, sempre do alto n�vel com a Camel DSL.


## desafio do mysql

No �ltimo exerc�cio do desafio, vamos gravar as negocia��es no banco de dados. N�s usaremos o MySQL que voc� precisa j� ter instalado, caso esteja com d�vidas, temos treinamentos que focam exclusivamente no MySQL na Alura. Nosso objetivo � executar um comando SQL insert para cada negocia��o na rota.

1) Conecte-se com o MySQL pelo terminal (ou outro cliente) para criar o banco e a tabela das negocia��es. Um vez conectado execute os seguintes comandos:

create database camel;
create table negociacao (id BIGINT NOT NULL AUTO_INCREMENT, preco DECIMAL(5,2), quantidade MEDIUMINT, data DATETIME, primary key (id));


