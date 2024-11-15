package com.example.servicesocial.controller;

import com.example.servicesocial.DTO.AvisDTO;
import com.example.servicesocial.Service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/avis")
public class AvisController {

  private final AvisService avisService;

  @Autowired
  public AvisController(AvisService avisService) {
    this.avisService = avisService;
  }

  // Ajouter un avis
  @PostMapping
  public AvisDTO ajouterAvis(@RequestBody AvisDTO avisDTO) {
    // Ajouter l'avis et envoyer la notification WebSocket
    AvisDTO avis = avisService.ajouterAvis(avisDTO);
    // Message WebSocket envoyé par le service
    return avis;
  }

  // Obtenir les avis par livre
  @GetMapping("/livre/{bookId}")
  public List<AvisDTO> obtenirAvisParLivre(@PathVariable Long bookId) {
    return avisService.obtenirAvisParLivre(bookId);
  }

  // Supprimer un avis
  @DeleteMapping("/{avisId}")
  public void supprimerAvis(@PathVariable Long avisId) {
    avisService.supprimerAvis(avisId);
  }

  // Modifier un avis
  @PutMapping("/{avisId}")
  public AvisDTO modifierAvis(@PathVariable Long avisId, @RequestBody String newContent) {
    return avisService.modifierAvis(avisId, newContent);
  }
}

