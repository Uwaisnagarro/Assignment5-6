pipeline {
    agent any

    tools {
        maven 'Maven' // Ensure Maven is configured in Jenkins global tool configuration
        jdk 'JAVA17'  // Ensure JDK is configured in Jenkins global tool configuration
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Uwaisnagarro/Assignment5-6.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
