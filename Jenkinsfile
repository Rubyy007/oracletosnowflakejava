pipeline {
    agent any

    tools {
        maven 'Maven_3'   // ✅ Update to your Maven installation name
        jdk 'JDK_17'      // ✅ Update to your JDK installation name
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Rubyy007/oracletosnowflakejava.git',
                    credentialsId: 'e527d38d-3d26-456e-a6d5-e4c02352390b'  // ✅ Use your real Jenkins credential ID
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Run Transfer') {
            steps {
                bat 'java -cp target/oracle-to-snowflake-1.0-SNAPSHOT.jar com.example.TransferData'
            }
        }
    }
}
