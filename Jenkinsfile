pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'jdk21'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main',
                   
                    url: 'https://github.com/bharathkumar172002/Wipro_CapstoneProject.git'
            }
        }

        stage('Build Project') {
            steps {
            
                bat 'mvn clean compile'
            }
        }

        stage('Execute Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Publish TestNG Results') {
            steps {
                junit 'test-output/junitreports/*.xml'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/screenshots/*.png', 
                             allowEmptyArchive: true
            archiveArtifacts artifacts: '**/ExtentReport.html',
                             allowEmptyArchive: true
        }
    }
}