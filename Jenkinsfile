pipeline {
    agent any

    environment {
         
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
                withSonarQubeEnv('SONARQUBE_ENV') {
                    withCredentials([string(credentialsId: 'Sonar-token2', variable: 'SONAR_TOKEN')]) {
                        bat "sonar-scanner -Dsonar.login=%SONAR_TOKEN%"
                    }
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
