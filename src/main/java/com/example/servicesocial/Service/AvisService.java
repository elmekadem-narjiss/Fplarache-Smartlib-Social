package com.example.servicesocial.Service;

import com.example.servicesocial.DTO.AvisDTO;
import com.example.servicesocial.Entities.Avis;
import com.example.servicesocial.Mapper.AvisMapper;
import com.example.servicesocial.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvisService {
  @Autowired
  private AvisRepository avisRepository;

  @Autowired
  private AvisMapper avisMapper;

  public AvisDTO ajouterAvis(AvisDTO avisDTO) {
    Avis avis = avisMapper.toEntity(avisDTO);
    avis.setCreationDate(LocalDateTime.now());
    return avisMapper.toDTO(avisRepository.save(avis));
  }

  public List<AvisDTO> obtenirAvisParLivre(Long bookId) {
    return avisRepository.findByBookId(bookId).stream()
      .map(avisMapper::toDTO)
      .collect(Collectors.toList());
  }
}
