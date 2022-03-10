This is the `solution` branch of this repo. It contains the end result of following the [Spring Boot externalized Configuration](https://kubebyexample.com/en/learning-paths/<<NEED_TO_FILL_THIS_IN>>) lesson for the [Developing with Spring Boot on Kubernetes](https://kubebyexample.com/en/learning-paths/developing-spring-boot-kubernetes) learning path on [kube by example](https://kubebyexample.com).

This project was generated using [start.spring.io](https://start.spring.io). The [`HelloController`](src/main/java/org/acme/externalconfig/rest/HelloController.java) and [`HelloControllerTests`](src/test/java/org/acme/externalconfig/rest/HelloControllerTests.java) classes were added as a starting point for the lesson.

You can deploy it to minikube:
1. Run `./mvnw clean k8s:deploy -Pk8s`
2. Run `minikube service list` to find the service:
 
   ```shell
   |------------------------------|------------------------------|--------------|-----------------------------|
   |          NAMESPACE           |             NAME             | TARGET PORT  |             URL             |
   |------------------------------|------------------------------|--------------|-----------------------------|
   | default                      | kubernetes                   | No node port |
   | kube-system                  | kube-dns                     | No node port |
   | spring-jkube-external-config | spring-jkube-external-config | http/8080    | http://<<SERVICE_IP>>:30526 |
   |------------------------------|------------------------------|--------------|-----------------------------|
   ```

3. Hit the endpoint (i.e. `curl http://<<SERVICE_IP>>:30526/hello`)