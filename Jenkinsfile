pipeline {
    agent any

    environment {
        // Le nom EXACT que tu as défini dans Jenkins > Configure System > SonarQube servers
        SONARQUBE_ENV = 'SQ1'
    }

    stages {
        stage('Checkout') {
           steps {
                checkout scm
                }
        }

       stage('Compile Java') {
            steps {
                bat 'javac Calculator.java'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${SONARQUBE_ENV}") {
                    bat 'sonar-scanner'
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}
