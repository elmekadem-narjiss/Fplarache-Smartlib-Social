package com.example.servicesocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class ServiceSocialApplication {

  public static void main(String[] args) {
    // Démarrer l'application et obtenir le contexte de l'application
    ApplicationContext context = SpringApplication.run(ServiceSocialApplication.class, args);

    // Récupérer le MongoTemplate pour tester la connexion
    MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);

    // Afficher un message de connexion à la base de données
    if (mongoTemplate != null) {
      System.out.println("Connexion à la base de données MongoDB réussie !");
    } else {
      System.out.println("Échec de la connexion à la base de données MongoDB.");
    }
  }


  }

