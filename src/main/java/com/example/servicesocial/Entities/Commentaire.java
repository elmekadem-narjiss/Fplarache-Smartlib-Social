package com.example.servicesocial.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "commentaires")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commentaire {
  @Id
  private String id;
  private String bookId;
  private String userId;
  private String texte;
  private LocalDateTime timestamp;

  // Constructeurs, getters et setters
}
