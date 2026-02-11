# Étape 1 : build avec Maven
FROM maven:3.9.3-eclipse-temurin-17 AS build
WORKDIR /app

# Copier le pom.xml et le code source
COPY pom.xml .
COPY src ./src

# Compiler le projet
RUN mvn clean package -DskipTests

# Étape 2 : runtime
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copier le jar compilé
COPY --from=build /app/target/*.jar app.jar

# Configuration serveur
ENV SERVER_PORT=8080
ENV SERVER_ADDRESS=0.0.0.0
EXPOSE 8080

# Lancer l’application
ENTRYPOINT ["java", "-jar", "app.jar"]
