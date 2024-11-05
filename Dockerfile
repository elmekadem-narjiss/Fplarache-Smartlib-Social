# Utiliser une image Java de base
FROM openjdk:11-jre-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR construit dans le conteneur
COPY target/Service-Social-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
