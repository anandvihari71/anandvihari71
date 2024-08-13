- 👋 Hi, I’m @anandvihari71
- 👀 I’m interested in ... Java, Devops, AWS, Python, Linux
- 🌱 I’m currently learning ... all
- 💞️ I’m looking to collaborate on ...
- 📫 How to reach me ...
- 😄 Pronouns: ...
- ⚡ Fun fact: ... remember (1.01)^365=37.7

<!---
anandvihari71/anandvihari71 is a ✨ special ✨ repository because its `README.md` (this file) appears on your GitHub profile.
You can click the Preview link to take a look at your changes.
--->

Java
========
**SonarQube** Configuration(you can do it by local install(jar,war file),local Docker image(its just container or you can call it as server),AWS EC2, AWS EKS Cluster, AWS ECS Managed kubernatis), add sonarlint plugin in IDEA Intellij for code smells and code quality

**Pre-requisites**
**a)** add jacoco and sonar-maven plugins in pom.xml
<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			<plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.11</version>
				<executions>
					<execution>
						<id>prepare-agent</id>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
					<execution>
						<id>report</id>
						<goals>
							<goal>report</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<groupId>org.sonarsource.scanner.maven</groupId>
				<artifactId>sonar-maven-plugin</artifactId>
				<version>3.9.1.2184</version>
			</plugin>
		</plugins>
	</build>
 use maven clean and maven install command(IDE) to generate reports
access sonar sever localhost:9000 and generate project key for each project and pass it as program arguments
1. Each env have different SonarQube,if project demands
2. https://0xnehru.medium.com/comprehensive-guide-installing-and-configuring-sonarqube-on-windows-9870ae80b8e6

3.** For IDE** you can pass 
    i) program arguments EX : 
    clean verify sonar:sonar -Dsonar.projectKey=project-token -Dsonar.host.url=http://localhost:9000 -        
    Dsonar.token=squ_691fb98476afea71fce3476943fbe69fac683ce6 -Dsonar.coverage.jacoco.xmlReportPaths=project-directory-location/target/site/jacoco/jacoco.xml -Dsonar.java.binaries=./target/classes

    ii) and Env properties(KEY=VALUE;KEY:VALUE)

4. In some projects raise a ticket to add your project to sonar server, platform team will take care
5. For gitlab pipeline you just add .gitlab-ci.yml file and sonar-project.properties file along with Dockerfile

**Dockerfile**

FROM openjdk:17.0-jdk-oraclelinux8

WORKDIR /app

COPY target/project-artifactory-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]


Multi module Project Structure
Parent project
 child project svc
	src
	target
	pom.xml
 child bdd componet test
	src
	target
	pom.xml
in root directory
.gitlab-ci.yml
pom.xml
sonar-project.properteis
Dockerfile
Jenkinsfile
DeploymentFile


parent pom.xml
<profiles>
    <profile>
      <id>app</id>
      <activation>
        <activeByDefault>false</activeByDefault>
      </activation>
      <modules>
        <module>child-svc</module>
      </modules>
    </profile>
    <profile>
      <id>component-test</id>
      <activation>
        <activeByDefault>false</activeByDefault>
      </activation>
      <modules>
        <module>child-component-test</module>
      </modules>
    </profile>
    <profile>
      <id>all</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <modules>
        <module>child-svc</module>
        <module>child-component-test</module>
      </modules>
    </profile>
  </profiles>
**How to install helmcharts in aws eks cluster**

helm install application-svc application-svc-chart-0.1.0.tgz -n application-svc

Detailed Explanation:
helm install: This is the Helm command to install or deploy a Helm chart, which is a package containing all the Kubernetes resources needed for an application.

application-svc: This is the name you are assigning to the Helm release. By naming the release application-svc, you can manage this deployment later with Helm commands (e.g., upgrade, rollback).

application-svc-chart-0.1.0.tgz: This is the path to the Helm chart package for application-svc. The .tgz file contains all the necessary templates and configuration for deploying the application. The version 0.1.0 in the file name indicates that this is the first version of the chart.

-n application-svc: This flag specifies that the Helm release should be installed in the application-svc namespace in your Kubernetes cluster. Namespaces help organize and isolate resources within the cluster.

What Happens When You Run This Command?
Helm reads the application-svc-chart-0.1.0.tgz chart package and deploys the resources defined within it to the application-svc namespace in your Kubernetes cluster.
The deployment is registered as a Helm release named application-svc, allowing you to manage this deployment with Helm commands in the future.
Example Use Cases:
Deployment: Deploy the application-svc microservice in your Kubernetes cluster.
Version Control: Deploy version 0.1.0 of the application-svc Helm chart, allowing you to easily track and manage application versions.
Namespace Management: The application-svc namespace isolates the resources of this service from others, improving organization and preventing conflicts.
Make sure that the application-svc namespace exists in your cluster, or create it using kubectl create namespace application-svc before running the Helm install command.




@RestController for controllers @ControllerAdvice for (service, repo's)
Option 2: Use a Global Exception Handler with @ControllerAdvice
If you still want to use a global exception handler, even without controllers, you can do so by creating a @ControllerAdvice class that handles exceptions. This is more common in web applications where exceptions need to be translated into HTTP responses.

However, if you’re working in a non-web application or just handling services, you might want to handle exceptions locally or use a custom exception handler that doesn’t rely on Spring’s MVC infrastructure.
