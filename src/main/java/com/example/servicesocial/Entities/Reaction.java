package com.example.servicesocial.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reaction {
  @Id
  private String id;
  private String bookId;
  private String userId;
  private boolean like; // true pour "like", false pour "dislike"

  // Constructeurs, getters et setters
}
