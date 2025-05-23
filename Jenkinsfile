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
                // Compiler le fichier Calculator.java
                bat 'javac Calculator.java'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${SONARQUBE_ENV}") {
                    // Lance l’analyse avec le fichier sonar-project.properties du repo
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
