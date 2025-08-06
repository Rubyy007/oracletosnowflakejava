pipeline {
    agent any

    tools {
        maven 'MAVEN_3'
        jdk 'JDK_21'
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'your-git-cred-id', url: 'https://github.com/Rubyy007/oracletosnowflakejava.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Run Transfer') {
            steps {
                bat 'java -cp target\\oracle-to-snowflake-1.0-SNAPSHOT.jar com.example.TransferData'
            }
        }
    }
}
