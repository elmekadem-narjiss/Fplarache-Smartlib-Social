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
  private Long id;
  private Long bookId;
  private Long userId;
  private String content;
  private LocalDateTime creationDate;

  // Constructeurs, getters et setters
}
