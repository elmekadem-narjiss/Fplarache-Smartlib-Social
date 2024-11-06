package com.example.servicesocial.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "avis")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Avis {
  @Id
  private Long id;
  private Long bookId;
  private Long userId;
  private int etoiles; // Note d'évaluation (1-5 étoiles, par exemple)
  private LocalDateTime creationDate;

  // Constructeurs, getters et setters
}
