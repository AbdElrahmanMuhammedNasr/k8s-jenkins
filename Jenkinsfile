pipeline{
    agent any
    environment {
        dockerImage = ''
    }
    stages{
      stage('checkout') {
       steps {
        checkout scm
       }
      }

    stage('change') {
     steps {
       sh "chmod +x mvnw"
      }
    }

     stage('clean&install') {
         steps {
           sh "mvn -U clean install"
        }
     }

    stage('Build') {
       steps {
        sh "docker build -t wizard98/k8sapp:1.0.5 ."
       }
    }

    stage('run dockerImage') {
        steps {
                sh 'docker-compose -f app.yml up -d'
            }
     }

}
