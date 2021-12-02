package br.com.gavriel.v1.matrix.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class MainRestRouteBuilder extends RouteBuilder{

    @Override
    public void configure() throws Exception {

        restConfiguration()
            .apiContextRouteId("teste")
            .apiProperty("host", "localhost")
            .apiProperty("port", "8080")
            .apiProperty("api.contact.name", "Gabriel Casanova Silva")
            .apiProperty("api.contact.email", "gabrielcasanova328@gmail.com")
            .apiProperty("schemes", "http");

        rest("/test")
        .post()
            .id("/test")
            .description("test rout")
            .bindingMode(RestBindingMode.auto)
            .skipBindingOnErrorCode(true)
        .to("direct:TO_rest-/test-rest");

    }
    
}
