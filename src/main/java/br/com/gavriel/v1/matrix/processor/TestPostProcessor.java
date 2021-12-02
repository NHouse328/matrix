package br.com.gavriel.v1.matrix.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class TestPostProcessor implements Processor {
    
    @Override
    public void process(Exchange exchange) throws Exception {

        exchange.getIn().setBody("body");
    }
}