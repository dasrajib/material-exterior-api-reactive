package com.adu.api.controller;

import com.adu.api.model.MaterialExterior;
import com.adu.api.service.MaterialExteriorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/materialexterior")
@RequiredArgsConstructor
@Tag(name = "Material Exterior Management", description = "APIs for managing exterior materials")
public class MaterialExteriorController {

    private final MaterialExteriorService materialexteriorService;

    @GetMapping
    @Operation(summary = "Get all material exterior")
    public Flux<MaterialExterior> getAllMaterialExterior() {
        return materialexteriorService.getAllMaterialExterior();
    }

    @GetMapping("/{material_exterior_id}")
    @Operation(summary = "Get MaterialExterior by ID")
    public Mono<MaterialExterior> getMaterialExteriorById(@PathVariable Long material_exterior_id) {
        return materialexteriorService.getMaterialExteriorById(material_exterior_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new MaterialExterior")
    public Mono<MaterialExterior> createMaterialExterior(@RequestBody MaterialExterior material_exterior) {
        return materialexteriorService.createMaterialExterior(material_exterior);
    }

    @PutMapping("/{material_exterior_id}")
    @Operation(summary = "Update an existing MaterialExterior")
    public Mono<MaterialExterior> updateMaterialExterior(@PathVariable Long material_exterior_id, @RequestBody MaterialExterior material_exterior) {
        return materialexteriorService.updateMaterialExterior(material_exterior_id, material_exterior);
    }

    @DeleteMapping("/{material_exterior_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a material exterior")
    public Mono<Void> deleteMaterialExterior(@PathVariable Long material_exterior_id) {
        return materialexteriorService.deleteMaterialExterior(material_exterior_id);
    }
}
