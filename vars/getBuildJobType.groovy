/*
 *==========================================================
 * Extracts the build type (CI / INC / IB / RC) from the passed string.
 *
 * Syntax:
 *      getBuildJobType([:])
 *
 * Params:
 *      buildPath: a string to look for the path of the current build in Jenkins
 *                 when this is null; the JOB_NAME environment value is used.
 *
 * Return:
 *      a string for the build type; one of the following: CI / INC / IB / RC
 *
 * Remarks:
 *      If none of the above strings exist in the string, 'CI' is assumed
  * Example of using in Jenkinsfile for deploying for non CI build:
 *
 *      stage('Deploy to Nexus') {
 *          when { expression { 'CI' != getBuildJobType() } }
 *          steps{
 *              sh 'mvn deploy'
 *          }
 *      }
 *
*==========================================================
 */

def call(Map parameters = [:]) {
    echo "job name is: ${env.JOB_NAME}"
    parameters.buildPath = parameters.buildPath ?: env.JOB_NAME

    try {
        println "Extracting buildType from '${parameters.buildPath}'"
        return  (parameters.buildPath =~ /\/(CI|AUT|INC|IB|RC)\//)[ 0 ] [ 1 ]
    }
    catch (ex)
    {
        return 'CI'
    }
}
