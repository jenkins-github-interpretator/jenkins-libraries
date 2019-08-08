/*
 call docker build in dind agent
 */
def call(Map parameters = [:]) {
    def image = parameters.image
    def tag = parameters.tag
    def tagged_image = image + ":" + tag

    sh """
          \$(aws ecr get-login --no-include-email --region eu-central-1)
          docker build . -t ${tagged_image}
          docker push ${tagged_image}
       """

  return "${IMAGE}:${BUILD_ID}"
}
