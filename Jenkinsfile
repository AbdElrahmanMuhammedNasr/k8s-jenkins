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

     stage('clean') {
         steps {
           sh "./mvnw  clean"
        }
     }
      stage('install') {
              steps {
                sh "./mvnw  install"
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
}
