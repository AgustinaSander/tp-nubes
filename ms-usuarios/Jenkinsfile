pipeline{
agent any
    stages{
        stage('clean'){
            steps{
                sh "chmod +x mvnw"
                sh "java -version"
                sh "./mvnw clean"
            }
        }
        stage('backendtests'){
            steps{
                //sh "./mvnw test"
                sh "echo'configurar para ejecutar los tests'"
            }
        }
        stage('Install'){
            steps{
                sh "./mvnw clean install site-DskipTests"
                //sh "./mvnw pmd:pmd"
                archiveArtifacts artifacts:'**/target/*.jar',fingerprint:true
                archiveArtifacts artifacts:'**/target/site/**'
            }
        }
        // stage('reportes'){
        //     publishHTML([allowMissing:false,
        //     alwaysLinkToLastBuild:true,
        //     keepAll:true,
        //     reportDir:'target/site',
        //     reportFiles:'index.html',
        //     reportName:'Site'
        //     ])
        // }
    }
    options{
        buildDiscarder(logRotator(numToKeepStr:'5',artifactNumToKeepStr:'5'))
    }
}
