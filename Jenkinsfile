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
	    
	    
	stage ('SonarQube Analysis') {

            steps {
                withSonarQubeEnv('sonarQube') {
                    bat 'mvn clean verify sonar:sonar -Dsonar.projectKey=wheelmanager'
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
	
	stage('Delivery Stage') {
            steps {
                withMaven(maven : 'MAVEN_3_6_3') {
                    bat 'mvn clean install'
                }
            }
        }
	    
	    
	stage('Deploy to Tomcat') {
            steps {
                bat 'copy "target\\wheelManager-1.0.war" "D:\\apache-tomcat-9.0.54\\webapps"'
            }
        }

		/*stage('Deploy Tomcat') {
            steps {
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL} direction ${env.WORKSPACE}"
                withMaven(maven : 'MAVEN_3_6_3') {
					bat '"C:\\Program Files\\Git\\mingw64\\bin\\curl.exe" -T ".\\target\\wheelManager-1.0.war" "http://deployer:deployer@localhost:9090/manager/text/deploy?path=/wheelManager-1.0&update=true"'
                }
            }
        }*/

    }
}
