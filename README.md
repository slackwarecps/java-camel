# java-camel
Exemplo de Java Camel


## desafio do mysql

No �ltimo exerc�cio do desafio, vamos gravar as negocia��es no banco de dados. N�s usaremos o MySQL que voc� precisa j� ter instalado, caso esteja com d�vidas, temos treinamentos que focam exclusivamente no MySQL na Alura. Nosso objetivo � executar um comando SQL insert para cada negocia��o na rota.

1) Conecte-se com o MySQL pelo terminal (ou outro cliente) para criar o banco e a tabela das negocia��es. Um vez conectado execute os seguintes comandos:

create database camel;
create table negociacao (id BIGINT NOT NULL AUTO_INCREMENT, preco DECIMAL(5,2), quantidade MEDIUMINT, data DATETIME, primary key (id));


