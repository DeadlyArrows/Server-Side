pipeline {
    agent any
    tools { 
        maven 'MAVEN_3_6_3' 
        jdk 'JDK_1_11' 
    }
	
    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'MAVEN_3_6_3') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'MAVEN_3_6_3') {
                    bat 'mvn test'
                }
            }
        }


        stage ('Package Stage') {
            steps {
                withMaven(maven : 'MAVEN_3_6_3') {
                    bat 'mvn package'
                }
            }
        }
     
		      stage('Deploy tomcat') {
             steps {
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL} direcion ${env.WORKSPACE}"	
                withMaven(maven : 'MAVEN_3_6_3') {
                 bat '"C:\\Program Files\\Git\\mingw64\\bin\\curl.exe" -T ".\\target\\wheel-manager.war" "http://tomcat:tomcat@localhost:9090/manager/text/deploy?path=/wheel-manager&update=true"'
                } 
            }
        }

    }
}
