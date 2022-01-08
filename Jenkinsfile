pipeline {

    agent any
    tools {
        gradle 'gradle-7-3-3'
    }
    stages {

        stage("build") {
            steps {
                script {
                    echo "Building the JAR file..."
                    sh "./gradlew assemble "
                }
            }
        }

        stage("test") {
            when {
                expression {
                    env.BRANCH_NAME != 'master'
                }
            }
            steps {
                script {
                    echo "Setting up test environment..."
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    echo "Deploying the file..."
                }
            }
        }

    }
}