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
  private String id;
  private String bookId;
  private String userId;
  private int etoiles; // Nombre d'étoiles pour la note
  private LocalDateTime timestamp;

  // Constructeurs, getters et setters
}
