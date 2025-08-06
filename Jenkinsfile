pipeline {
    agent any

    tools {
        maven 'Maven_3' // Configure this in Jenkins: Global Tools → Maven
        jdk 'JDK_17'    // Or your Java version
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'your-git-cred-id', url: 'https://github.com/your_user/oracle-to-snowflake-java.git'
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
