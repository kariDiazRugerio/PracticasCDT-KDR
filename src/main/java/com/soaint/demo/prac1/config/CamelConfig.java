package com.soaint.demo.prac1.config;


import com.soaint.demo.prac1.model.Param;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;



@Component
public class CamelConfig extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        //        from("timer:foo")
//                .to("log:com.demo.camel.demo_camel?level=INFO")
//                .to("file:data/inbox?noop=true");

//        from("file:/tmp/data/inbox")
//                .to("log:com.baeldung.apachecamellogging?level=INFO")
//                .process(process -> {
//                    System.out.println( ">>>> msg=" +process.getMessage() );
//                })
//                .bean(FileProcessor.class)
//                .to("file:/tmp/data/outbox");

       //rest("/test2").get().to("direct:my-api-route")

        from("direct:my-api-route")
                //.to("https://regres.in/api/users/1?bridgeEndpoint=true")
                //                .to("log:DEBUG?showBody=true&showHeaders=
                .to("https://pocbamoe.free.beeceptor.com/cameltest/api2")
                .process( e -> {
                    var msg = e.getIn().getBody(String.class).toUpperCase();


                    var param = new Param();
                    param.setValue(msg);
                    //ObjectMapper mapper = new ObjectMapper();
                    //String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(param);
                    //e.getIn().setBody(json);
                   e.getIn().setBody(param);

                })
                .marshal().json()
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                //                .to("log:DEBUG?showBody=true&showHeaders=true")
                .to("http://localhost:8080/api2?bridgeEndpoint=true");

    }
}
