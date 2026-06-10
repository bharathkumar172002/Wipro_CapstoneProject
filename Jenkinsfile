pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'jdk21'
    }

    stages {

        stage('Checkout Code') {

            steps {

                git branch: 'master',
                url: 'https://github.com/bharathkumar172002/Wipro_CapstoneProjectgit'
            }
        }

        stage('Build Project') {

            steps {

                dir('Guru99_Banking_Automation') {

                    bat 'mvn clean compile'
                }
            }
        }

        stage('Execute Tests') {

            steps {

                dir('Guru99_Banking_Automation') {

                    bat 'mvn test'
                }
            }
        }

        stage('Publish TestNG Results') {

            steps {

                dir('Guru99_Banking_Automation') {

                    junit 'test-output/junitreports/*.xml'
                }
            }
        }
    }

    post {

        always {

            archiveArtifacts artifacts: 'Guru99/screenshots/*.png',
                             allowEmptyArchive: true

            archiveArtifacts artifacts: 'Guru99/test-output/ExtentReport.html',
                             allowEmptyArchive: true
        }

        success {

            echo ' Automation Execution Successful'
        }

        failure {

            echo ' Automation Execution Failed'
        }
    }
}