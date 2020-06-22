package br.com.caelum.camel;

import java.text.SimpleDateFormat;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.thoughtworks.xstream.XStream;

import entity.Negociacao;


public class RotaHttpPollingNegociacoes {
	
	
	private static MysqlConnectionPoolDataSource criaDataSource() {
	    MysqlConnectionPoolDataSource mysqlDs = new MysqlConnectionPoolDataSource();
	    mysqlDs.setDatabaseName("camel");
	    mysqlDs.setServerName("127.0.0.1");
	    mysqlDs.setPort(3306);
	    mysqlDs.setUser("root");
	    mysqlDs.setPassword("toor");
	    return mysqlDs;
	}

	public static void main(String[] args) throws Exception {
		
		final XStream xStream = new XStream();
		xStream.alias("negociacao", Negociacao.class);
		
		
		SimpleRegistry registro = new SimpleRegistry();
		registro.put("mysql", criaDataSource());
		System.out.println("chegou no driver...");
		

		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				
								
				from("timer://negociacoes?fixedRate=true&delay=3s&period=360s").
			    to("http4://argentumws.caelum.com.br/negociacoes").
			      convertBodyTo(String.class).
			      unmarshal(new XStreamDataFormat(xStream)).
			      split(body()).
			      process(new Processor() {
			        @Override
			        public void process(Exchange exchange) throws Exception {
			            Negociacao negociacao = exchange.getIn().getBody(Negociacao.class);
			            exchange.setProperty("preco", negociacao.getPreco());
			            exchange.setProperty("quantidade", negociacao.getQuantidade());
			            String data = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(negociacao.getData().getTime());
			            exchange.setProperty("data", data);
			        }
			      }).
			      //setBody(simple("insert into negociacao(preco, quantidade, data) values (${property.preco}, ${property.quantidade}, '${property.data}')")).
			      setBody(simple("insert into negociacao(preco, quantidade, data) values (123, 123, '2020-06-22')")).
			      log("${body}").
			      delay(1000).
			to("jdbc:mysql");
				
				
			    	
			}
			
		});

		context.start();
		Thread.sleep(20000);
		context.stop();
	}	
	
	

	
}
