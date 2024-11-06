package com.example.servicesocial.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReactionDTO {
  private Long id;
  private Long bookId;
  private Long userId;
  private boolean liked; // true pour "like", false pour "dislike"
  private LocalDateTime creationDate;

  // Constructeurs, getters et setters
}

