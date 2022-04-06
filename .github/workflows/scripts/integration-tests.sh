#!/bin/bash -ex

SERVICE_URL=$(minikube service -n spring-jkube-external-config spring-jkube-external-config --url)

helloUrl=${SERVICE_URL}/hello
helloActual=$(curl -s $helloUrl)
helloExpected="Hello (from Kubernetes ConfigMap) World"
echo "Got curl $helloUrl = $helloActual"
[ "$helloActual" != "$helloExpected" ] && echo "curl $helloUrl should equal \"$helloExpected\", yet it was \"$helloActual\"" && exit -1

helloYodaUrl=${SERVICE_URL}/hello/Yoda
helloYodaActual=$(curl -s $helloYodaUrl)
helloYodaExpected="Hello (from Kubernetes ConfigMap) Yoda"
echo "Got curl $helloYodaUrl = $helloYodaActual"
[ "$helloYodaActual" != "$helloYodaExpected" ] && echo "curl $helloYodaUrl should equal \"$helloYodaExpected\", yet it was \"$helloYodaActual\"" && exit -1

exit 0