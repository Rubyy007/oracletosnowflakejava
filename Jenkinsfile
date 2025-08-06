pipeline {
    agent any

    tools {
        maven 'MAVEN_3' // Use the correct name from Jenkins tool config (all caps)
        jdk 'JDK_21'    // Updated to match your installed version
    }

    environment {
        // Optional: set environment variables if needed
        // Example: JAVA_HOME = "${tool 'JDK_21'}"
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
