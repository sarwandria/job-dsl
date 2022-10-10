String app = "Java"

folder("${app}") {
    description "Service java spring"
}

pipelineJob("${app}/Deploy") {
    description "Deploy To Development-Staging"
    definition {
        cpsScm {
            scm {
                git {
                    branch('$BRANCH_NAME')
                    remote {
                        url('https://github.com/sarwandria/spring-boot.git')
                    }
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
    parameters {
        stringParam('BRANCH_NAME', 'master', 'What is the branch name for build the App?')
    }
}