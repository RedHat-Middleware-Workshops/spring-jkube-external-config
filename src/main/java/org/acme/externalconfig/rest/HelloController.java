package org.acme.externalconfig.rest;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


	@GetMapping(path = { "/hello", "/hello/{name}" }, produces = TEXT_PLAIN_VALUE)
	public String hello(@PathVariable(required = false) Optional<String> name) {
		return "Hello " + name.orElse("World");
	}
}
