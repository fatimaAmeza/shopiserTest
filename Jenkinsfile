pipeline {
    agent none
    tools {
        maven 'localMaven'
    } 
    stages {
        stage('Checkout Selenium') {
                agent {
                label 'Windows'
            }
            steps {
                echo "-=- Checkout project -=-"
                git url: 'https://github.com/fatimaAmeza/shopiserTest.git'
            }
        }
        
        stage('Selenium Test Job') {
               agent {
                label 'Windows'
            }
            steps {
                 bat 'mvn clean verify surefire-report:report-only'
                
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
