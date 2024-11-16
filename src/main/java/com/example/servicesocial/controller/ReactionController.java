package com.example.servicesocial.controller;

import com.example.servicesocial.DTO.ReactionDTO;
import com.example.servicesocial.Service.ReactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reactions")
@Tag(name = "Réactions", description = "Gestion des réactions des utilisateurs sur les livres")  // Remplacement de @Api
public class ReactionController {

  private final ReactionService reactionService;

  @Autowired
  public ReactionController(ReactionService reactionService) {
    this.reactionService = reactionService;
  }

  @PostMapping
  @Operation(summary = "Ajouter une réaction", description = "Permet d'ajouter une réaction (like/dislike) sur un livre")  // Remplacement de @ApiOperation
  public ReactionDTO ajouterReaction(@RequestBody ReactionDTO reactionDTO) {
    return reactionService.ajouterReaction(reactionDTO);
  }

  @GetMapping("/livre/{bookId}")
  @Operation(summary = "Obtenir les réactions d'un livre", description = "Retourne toutes les réactions associées à un livre spécifique")  // Remplacement de @ApiOperation
  public List<ReactionDTO> obtenirReactionsParLivre(@Parameter(description = "ID du livre", required = true) @PathVariable Long bookId) {  // Remplacement de @ApiParam
    return reactionService.obtenirReactionsParLivre(bookId);
  }

  @DeleteMapping("/{reactionId}")
  @Operation(summary = "Supprimer une réaction", description = "Permet de supprimer une réaction en fonction de l'ID")  // Remplacement de @ApiOperation
  public void supprimerReaction(@Parameter(description = "ID de la réaction", required = true) @PathVariable Long reactionId) {  // Remplacement de @ApiParam
    reactionService.supprimerReaction(reactionId);
  }
}
