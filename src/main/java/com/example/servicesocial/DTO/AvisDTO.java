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
public class AvisDTO {
  private Long id;
  private Long bookId;
  private Long userId;
  private int etoiles; // Nombre d'étoiles pour la note
  private LocalDateTime creationDate;

  // Constructeurs, getters et setters
}
