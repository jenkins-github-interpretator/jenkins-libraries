import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*

def call(def jobrun) {
    def x = []
    StringBuffer log = new StringBuffer();
    Jenkins.instance.pluginManager.plugins.each {
        plugin ->
            x.add("${plugin.getShortName()}:${plugin.getVersion()}")
    }
    x.sort().each { log << "$it\n" }
    jobrun.echo log.toString()
}
