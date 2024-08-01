pipeline {
    agent any

    triggers {
        githubPush()
    }

    tools {
        maven 'Maven' // Ensure Maven is configured in Jenkins global tool configuration
        jdk 'JAVA17'  // Ensure JDK is configured in Jenkins global tool configuration
    }

    scm {
        git {
            url 'https://github.com/Uwaisnagarro/Assignment5-6.git'
            branch 'main'
            credentialsId '3eb0db10-6140-428f-ab00-adabc3d05a47' // Replace with your credentials ID
        }
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

        stage('Run') {
            steps {
                script {
                  bat 'java -jar target/Assignment5-0.0.1-SNAPSHOT.jar'
                  }
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