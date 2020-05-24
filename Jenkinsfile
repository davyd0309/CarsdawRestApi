pipeline {
    agent any
    tools {
        gradle "Gradle"
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/davyd0309/CarsdawRestApi.git'
            }
        }
        stage('Build'){
            steps {
                sh 'gradle build'
            }
        }
    }
}