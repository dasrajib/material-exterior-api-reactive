package com.adu.api.repository;

import com.adu.api.model.MaterialExterior;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MaterialExteriorRepository extends ReactiveCrudRepository<MaterialExterior, Long> {

    Flux<MaterialExterior> findByDescription(String description);    
}
