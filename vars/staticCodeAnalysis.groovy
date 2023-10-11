def call(credentialsId){
    withSonarQubeEnv(credentialsId: 'sonarcred') {
        sh 'mvn clean package sonar:sonar'
    }
}