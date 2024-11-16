package com.example.servicesocial.controller;

import com.example.servicesocial.DTO.CommentaireDTO;
import com.example.servicesocial.Service.CommentaireService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentaires")
@Tag(name = "Commentaires", description = "Gestion des commentaires des livres")  // Remplacement de @Api
public class CommentaireController {

  private final CommentaireService commentaireService;

  @Autowired
  public CommentaireController(CommentaireService commentaireService) {
    this.commentaireService = commentaireService;
  }

  @PostMapping
  @Operation(summary = "Ajouter un commentaire", description = "Permet d'ajouter un commentaire à un livre")  // Remplacement de @ApiOperation
  public CommentaireDTO ajouterCommentaire(@RequestBody CommentaireDTO commentaireDTO) {
    return commentaireService.ajouterCommentaire(commentaireDTO);
  }

  @GetMapping("/livre/{bookId}")
  @Operation(summary = "Obtenir les commentaires d'un livre", description = "Retourne tous les commentaires associés à un livre spécifique")  // Remplacement de @ApiOperation
  public List<CommentaireDTO> obtenirCommentairesParLivre(@Parameter(description = "ID du livre", required = true) @PathVariable Long bookId) {  // Remplacement de @ApiParam
    return commentaireService.obtenirCommentairesParLivre(bookId);
  }

  @DeleteMapping("/{commentaireId}")
  @Operation(summary = "Supprimer un commentaire", description = "Permet de supprimer un commentaire en fonction de l'ID")  // Remplacement de @ApiOperation
  public void supprimerCommentaire(@Parameter(description = "ID du commentaire", required = true) @PathVariable Long commentaireId) {  // Remplacement de @ApiParam
    commentaireService.supprimerCommentaire(commentaireId);
  }

  @PutMapping("/{commentaireId}")
  @Operation(summary = "Modifier un commentaire", description = "Permet de modifier le contenu d'un commentaire existant")  // Remplacement de @ApiOperation
  public CommentaireDTO modifierCommentaire(@Parameter(description = "ID du commentaire", required = true) @PathVariable Long commentaireId,  // Remplacement de @ApiParam
                                            @Parameter(description = "Nouveau contenu du commentaire", required = true) @RequestBody String newContent) {  // Remplacement de @ApiParam
    return commentaireService.modifierCommentaire(commentaireId, newContent);
  }
}
