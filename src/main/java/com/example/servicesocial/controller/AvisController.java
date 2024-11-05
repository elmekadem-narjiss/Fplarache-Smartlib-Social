package com.example.servicesocial.controller;

import com.example.servicesocial.DTO.AvisDTO;
import com.example.servicesocial.Service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/avis")
public class AvisController {
  @Autowired
  private AvisService avisService;

  @PostMapping
  public AvisDTO ajouterAvis(@RequestBody AvisDTO avisDTO) {
    return avisService.ajouterAvis(avisDTO);
  }

  @GetMapping("/livre/{bookId}")
  public List<AvisDTO> obtenirAvisParLivre(@PathVariable String bookId) {
    return avisService.obtenirAvisParLivre(bookId);
  }
}
