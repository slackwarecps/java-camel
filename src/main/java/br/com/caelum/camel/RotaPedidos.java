package br.com.caelum.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class RotaPedidos {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		
		//Adicionar uma Rota
		context.addRoutes(new RouteBuilder() { //cuidado, não é RoutesBuilder

		    @Override
		    public void configure() throws Exception {
		    	//Aqui que configuramos a rota..
		    	
		    	
		    	System.out.println("roudou!!");
		    	//busca de 5 em cinco segundos na pasta
		    	//noop=true nao apaga os arquivos na origem
		    	//marshal() transforma mensagem
		    	
		    	from("file:pedidos?delay=5s&noop=true").
			    	split().
			    		xpath("/pedido/itens/item").
			    		log("${body}").
			    	filter().
			    		xpath("/item/formato[text()='EBOOK']").
				    	//  log("${exchange.pattern}"). 
				    	//  log("${id} - ${body}").
				    	log("${body}").
			    	marshal().xmljson().
			    	setHeader("CamelFileName",simple("${file:name.noext}.json")).
		    	to("file:saida");
		    	
		    	
		    }
		});
		System.out.println("iniciando...");
	    context.start();
	    System.out.println("aguardando...");
	    Thread.sleep(5000);
	    System.out.println("Finalizando...");
	    context.stop();
	    
	}
}