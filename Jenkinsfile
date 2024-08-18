pipeline{
    agent any
    stages{
        stage('git checkout'){
            steps{
            git branch: 'main', credentialsId: 'github_id', url: 'https://github.com/anandvihari71/realistic-goals.git'
            sh 'mvn clean install'
            }
        }
        stage('docker build'){
            steps{
                script{
                sh 'docker build -t anandvihari1/my-docker-hub-repo .'
                }
            }
        }
        stage('docker push'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhubid', variable: 'dockerhubpwd')]) {
                     // some block
                     sh 'docker login -u anandvihari1 -p ${dockerhubpwd}'
                    }
                    sh 'docker push anandvihari1/my-docker-hub-repo'
                }
            }
        }
    }
}