package com.example.servicesocial.controller;

import com.example.servicesocial.DTO.CommentaireDTO;
import com.example.servicesocial.Service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {
  @Autowired
  private CommentaireService commentaireService;

  @PostMapping
  public CommentaireDTO ajouterCommentaire(@RequestBody CommentaireDTO commentaireDTO) {
    return commentaireService.ajouterCommentaire(commentaireDTO);
  }

  @GetMapping("/livre/{bookId}")
  public List<CommentaireDTO> obtenirCommentairesParLivre(@PathVariable Long bookId) {
    return commentaireService.obtenirCommentairesParLivre(bookId);
  }


  @DeleteMapping("/{commentaireId}")
  public ResponseEntity supprimerCommentaire(@PathVariable Long commentaireId) {
      commentaireService.supprimerCommentaire(commentaireId);
    return ResponseEntity.ok().build();
  }


  @PutMapping("/{commentaireId}")
  public CommentaireDTO modifierCommentaire(@PathVariable Long commentaireId,
          @RequestBody String newContent) {
      return commentaireService.modifierCommentaire(commentaireId, newContent);
  }

}
