package com.example.servicesocial.Service;

import com.example.servicesocial.DTO.AvisDTO;
import com.example.servicesocial.Entities.Avis;
import com.example.servicesocial.Mapper.AvisMapper;
import com.example.servicesocial.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.messaging.simp.SimpMessagingTemplate;

@Service
public class AvisService {

  private final AvisRepository avisRepository;
  private final AvisMapper avisMapper;
  private final SimpMessagingTemplate messagingTemplate;  // Pour l'envoi des messages WebSocket

  @Autowired
  public AvisService(AvisRepository avisRepository, AvisMapper avisMapper, SimpMessagingTemplate messagingTemplate) {
    this.avisRepository = avisRepository;
    this.avisMapper = avisMapper;
    this.messagingTemplate = messagingTemplate;
  }

  public AvisDTO ajouterAvis(AvisDTO avisDTO) {
    Avis avis = avisMapper.toEntity(avisDTO);
    avis = avisRepository.save(avis);

    // Envoi du message WebSocket
    messagingTemplate.convertAndSend("/topic/avis", avisDTO);  // Envoie de l'avis ajouté à tous les abonnés

    return avisMapper.toDTO(avis);
  }

  public List<AvisDTO> obtenirAvisParLivre(Long bookId) {
    return avisRepository.findByBookId(bookId).stream()
            .map(avisMapper::toDTO)
            .collect(Collectors.toList());
  }

  public void supprimerAvis(Long avisId) {
    if (avisRepository.existsById(avisId)) {
      avisRepository.deleteById(avisId);
      // Envoi d'un message WebSocket pour la suppression de l'avis
      messagingTemplate.convertAndSend("/topic/avis/supprime", avisId);
    } else {
      throw new IllegalArgumentException("Avis ID: " + avisId + " does not exist.");
    }
  }

  public AvisDTO modifierAvis(Long avisId, String newContent) {
    Avis avis = avisRepository.findById(avisId)
            .orElseThrow(() -> new IllegalArgumentException("Avis ID: " + avisId + " does not exist."));

    avis.setContent(newContent);
    avis = avisRepository.save(avis);

    // Envoi du message WebSocket après modification
    messagingTemplate.convertAndSend("/topic/avis", avisMapper.toDTO(avis));

    return avisMapper.toDTO(avis);
  }
}


