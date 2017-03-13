package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PactProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PactProducerApplication.class, args);
	}
	
    @RequestMapping(value = "/foos", method = RequestMethod.GET)
    public ResponseEntity<List<Foo>> foos() {
        return new ResponseEntity<>(Arrays.asList(new Foo(42), new Foo(100)), HttpStatus.OK);
    }
}
