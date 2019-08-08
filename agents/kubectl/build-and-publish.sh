#!/bin/bash -x

image="741273514153.dkr.ecr.eu-central-1.amazonaws.com/jenkins-jnlp-slave-kubectl:1.0.1"

$(aws ecr get-login --no-include-email --region eu-central-1)

docker build -t $image . && docker push $image
