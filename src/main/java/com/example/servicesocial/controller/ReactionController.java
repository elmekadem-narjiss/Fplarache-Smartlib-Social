package com.example.servicesocial.controller;

import com.example.servicesocial.DTO.ReactionDTO;
import com.example.servicesocial.Service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reactions")
public class ReactionController {
  @Autowired
  private ReactionService reactionService;

  @PostMapping
  public ReactionDTO ajouterReaction(@RequestBody ReactionDTO reactionDTO) {
    return reactionService.ajouterReaction(reactionDTO);
  }

  @GetMapping("/livre/{bookId}")
  public List<ReactionDTO> obtenirReactionsParLivre(@PathVariable String bookId) {
    return reactionService.obtenirReactionsParLivre(bookId);
  }
}
