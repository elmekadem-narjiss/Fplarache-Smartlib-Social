package com.example.servicesocial.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReactionDTO {
  private String id;
  private String bookId;
  private String userId;
  private boolean like; // true pour "like", false pour "dislike"

  // Constructeurs, getters et setters
}

