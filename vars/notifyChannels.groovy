def call(Map parameters = [:]) {

    parameters.emailAddress = parameters.emailAddress ?: 'smsmm-cicd@aurea.com'
    parameters.notifyEmail = parameters.notifyEmail ?: true
    parameters.notifySlack = parameters.notifySlack ?: true

    // Default values
    def subject = "${currentBuild.currentResult}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    def message = """SMS Masterminds *( ${env.JOB_NAME} )*
Build URL:   ${env.BUILD_URL}
```
Job Name:    ${env.JOB_NAME}
Build ID:    ${env.BUILD_DISPLAY_NAME}
Status:      ${currentBuild.currentResult}
Build Agent: ${env.NODE_NAME}```
"""
    def colorMap = [
        'ABORTED': 'warning',
        'FAILURE': 'danger',
        'NOT_BUILT': 'warning',
        'SUCCESS': 'good',
        'UNSTABLE': 'warning',
    ]

    if (parameters.notifySlack) {
        echo "this is the notifySlack"
        echo "1JvRUYt4FgKcFHtM8tjNznB5"
        /*
        slackSend(
            color: colorMap[currentBuild.currentResult],
            message: message,
            channel: 'smsmasterminds',
            token: '1JvRUYt4FgKcFHtM8tjNznB5',
            baseUrl: 'https://devfactorydev.slack.com/services/hooks/jenkins-ci/',
            teamDomain: 'devfactorydev'
        )
        */
    }

    if (parameters.notifyEmail) {
        /*
        emailext(
            to: parameters.emailAddress,
            subject: subject,
            body: message,
            attachLog: (currentBuild.currentResult == 'FAILURE'),
            recipientProviders: [[$class: 'CulpritsRecipientProvider'], [$class: 'RequesterRecipientProvider']]
        )
        */
    }
}
