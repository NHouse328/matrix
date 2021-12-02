package br.com.gavriel.v1.matrix.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import br.com.gavriel.v1.matrix.processor.TestPostProcessor;

@Component
public class TestPostRouteBuilder extends RouteBuilder {
    
    @Override
    public void configure() throws Exception {

        from("direct:TO_rest-/test-rest")
            .routeId("rest-/test-rest")
            .log("rest-/test-rest")
            .to("direct:TO_rest-/test-rest-SERVICE");

        from("direct:TO_rest-/test-rest-SERVICE")
            .doTry()
                .routeId("rest-/test-rest-SERVICE")
                .log("rest-/test-rest-SERVICE")
                .process(new TestPostProcessor())
                .setHeader(Exchange.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON_VALUE))
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(HttpStatus.OK.value()))
            .doCatch(Exception.class)
                .log("Error")
                .stop()
            .end();
    }

}
