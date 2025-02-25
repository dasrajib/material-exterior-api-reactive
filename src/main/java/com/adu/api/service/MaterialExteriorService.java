package com.adu.api.service;

import com.adu.api.model.MaterialExterior;
import com.adu.api.repository.MaterialExteriorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MaterialExteriorService {

    private final MaterialExteriorRepository materialexteriorRepository;

    public Flux<MaterialExterior> getAllMaterialExterior() {
        return materialexteriorRepository.findAll();
    }

    public Mono<MaterialExterior> getMaterialExteriorById(Long material_exterior_id) {
        return materialexteriorRepository.findById(material_exterior_id);
    }

    public Mono<MaterialExterior> createMaterialExterior(MaterialExterior material_exterior) {
        return materialexteriorRepository.save(material_exterior);
    }

    public Mono<MaterialExterior> updateMaterialExterior(Long material_exterior_id, MaterialExterior material_exterior) {
        return materialexteriorRepository.findById(material_exterior_id)
                .flatMap(existingMaterialExterior -> {
                    existingMaterialExterior.setMaterial_type(material_exterior.getMaterial_type());
                    existingMaterialExterior.setDescription(material_exterior.getDescription());
                    existingMaterialExterior.setColor(material_exterior.getColor());
                    existingMaterialExterior.setPrice(material_exterior.getPrice());

                    existingMaterialExterior.setUpdated_at(LocalDateTime.now());
                
                    return materialexteriorRepository.save(existingMaterialExterior);
                });
    }

    public Mono<Void> deleteMaterialExterior(Long material_exterior_id) {
        return materialexteriorRepository.deleteById(material_exterior_id);
    }
}
