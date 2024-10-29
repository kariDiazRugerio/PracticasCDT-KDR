package com.soaint.demo.prac1;

import jakarta.annotation.Resource;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import com.soaint.demo.prac1.model.Param;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Prac1Application {

	@Autowired
	ProducerTemplate producerTemplate;


	@GetMapping("test1")
	public String test1(){
		var e = producerTemplate.send("direct:my-api-route", p ->{
			System.out.println("body="+p.getIn().getBody());
		});
		return e.getIn().getBody().toString();
	}

	@PostMapping("api2")
	public Param api2(@RequestBody Param param){
		return param;
	}
	public static void main(String[] args) {
		SpringApplication.run(Prac1Application.class, args);
	}

}
