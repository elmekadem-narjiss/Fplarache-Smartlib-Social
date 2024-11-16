package com.example.servicesocial.controller;

import com.example.servicesocial.DTO.AvisDTO;
import com.example.servicesocial.Service.AvisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avis")
@Tag(name = "Avis", description = "Gestion des avis des livres")  // Remplacement de @Api
public class AvisController {

  private final AvisService avisService;

  @Autowired
  public AvisController(AvisService avisService) {
    this.avisService = avisService;
  }

  // Ajouter un avis
  @PostMapping
  @Operation(summary = "Ajouter un avis", description = "Permet d'ajouter un avis pour un livre")  // Remplacement de @ApiOperation
  public AvisDTO ajouterAvis(@RequestBody AvisDTO avisDTO) {
    return avisService.ajouterAvis(avisDTO);
  }

  // Obtenir les avis par livre
  @GetMapping("/livre/{bookId}")
  @Operation(summary = "Obtenir les avis d'un livre", description = "Retourne tous les avis associés à un livre spécifique")  // Remplacement de @ApiOperation
  public List<AvisDTO> obtenirAvisParLivre(@Parameter(description = "ID du livre", required = true) @PathVariable Long bookId) {  // Remplacement de @ApiParam
    return avisService.obtenirAvisParLivre(bookId);
  }

  // Supprimer un avis
  @DeleteMapping("/{avisId}")
  @Operation(summary = "Supprimer un avis", description = "Permet de supprimer un avis en fonction de l'ID")  // Remplacement de @ApiOperation
  public void supprimerAvis(@Parameter(description = "ID de l'avis", required = true) @PathVariable Long avisId) {  // Remplacement de @ApiParam
    avisService.supprimerAvis(avisId);
  }

  // Modifier un avis
  @PutMapping("/{avisId}")
  @Operation(summary = "Modifier un avis", description = "Permet de modifier le contenu d'un avis existant")  // Remplacement de @ApiOperation
  public AvisDTO modifierAvis(@Parameter(description = "ID de l'avis", required = true) @PathVariable Long avisId,  // Remplacement de @ApiParam
                              @Parameter(description = "Nouveau contenu de l'avis", required = true) @RequestBody String newContent) {  // Remplacement de @ApiParam
    return avisService.modifierAvis(avisId, newContent);
  }
}
