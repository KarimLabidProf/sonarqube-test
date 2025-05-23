pipeline {
    agent any

    environment {
        SONARQUBE_ENV = 'SQ1'
    }

    stages {
        stage('Checkout') {
            steps {
                // clone depuis ton dépôt ou utiliser un workspace local
                git 'https://ton-repo.git' // à adapter si besoin
            }
        }

        stage('Compile Java') {
            steps {
                bat 'javac HelloWorld.java'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${SONARQUBE_ENV}") {
                    bat 'sonar-scanner.bat'
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
