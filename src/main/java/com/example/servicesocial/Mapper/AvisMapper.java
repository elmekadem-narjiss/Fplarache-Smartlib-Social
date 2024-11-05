package com.example.servicesocial.Mapper;

import com.example.servicesocial.DTO.AvisDTO;
import com.example.servicesocial.Entities.Avis;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AvisMapper {
  AvisDTO toDTO(Avis avis);
  Avis toEntity(AvisDTO avisDTO);
}

