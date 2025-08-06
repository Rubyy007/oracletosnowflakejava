pipeline {
    agent any

    tools {
        maven 'MAVEN_3'
        jdk 'JDK_21'
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-token', url: 'https://github.com/Rubyy007/oracletosnowflakejava.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Run Transfer') {
            steps {
                sh 'java -cp target/oracle-to-snowflake-1.0-SNAPSHOT.jar com.example.TransferData'
            }
        }
    }
}
