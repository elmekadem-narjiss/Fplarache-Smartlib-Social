package com.example.servicesocial.controller;

import com.example.servicesocial.DTO.ReactionDTO;
import com.example.servicesocial.Service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reactions")
public class ReactionController {

  private final ReactionService reactionService;

  @Autowired
  public ReactionController(ReactionService reactionService) {
    this.reactionService = reactionService;
  }

  @PostMapping
  public ReactionDTO ajouterReaction(@RequestBody ReactionDTO reactionDTO) {
    // Ajout de la réaction et envoi de la notification WebSocket
    ReactionDTO reaction = reactionService.ajouterReaction(reactionDTO);
    // Message WebSocket envoyé par le service
    return reaction;
  }

  @GetMapping("/livre/{bookId}")
  public List<ReactionDTO> obtenirReactionsParLivre(@PathVariable Long bookId) {
    return reactionService.obtenirReactionsParLivre(bookId);
  }

  @DeleteMapping("/{reactionId}")
  public void supprimerReaction(@PathVariable Long reactionId) {
    reactionService.supprimerReaction(reactionId);
  }
}

