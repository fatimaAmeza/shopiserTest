pipeline {
    agent any
    tools {
        maven 'localMaven'
    } 
    stages {
        stage('Checkout Selenium') {
            steps {
                echo "-=- Checkout project -=-"
                git url: 'https://github.com/fatimaAmeza/shopiserTest.git'
            }
        }
        
        stage('Selenium Test Job') {
            steps {
                 sh 'chmod +x driver/chromedriver.exe'
                 sh 'JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/jre mvn clean verify surefire-report:report-only'
                
                publishHTML target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'target/site',
            reportFiles: 'surefire-report.html',
            reportName: 'Automation Tests Report'
          ]
                }
             }
    }
}
