package org.acme.externalconfig.rest;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTests {
  @Autowired
	MockMvc mockMvc;

	@Test
	public void helloNoSubPath() throws Exception {
		this.mockMvc.perform(get("/hello").accept(TEXT_PLAIN))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(TEXT_PLAIN))
			.andExpect(content().string("Hello World"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "Yoda", "Darth Vader" })
	public void helloSubPath(String subpath) throws Exception {
		this.mockMvc.perform(get("/hello/{name}", subpath).accept(TEXT_PLAIN))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(TEXT_PLAIN))
			.andExpect(content().string("Hello " + subpath));
	}
}