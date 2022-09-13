package org.acme.externalconfig;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = { "spring.cloud.kubernetes.config.enabled=false" })
class SpringJkubeExternalConfigApplicationTests {

	@Test
	void contextLoads() {
	}

}
