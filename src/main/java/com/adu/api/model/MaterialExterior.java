package com.adu.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("material_exterior")
public class MaterialExterior  {

    @Id
    private Long material_exterior_id;
    private String material_type;
    private String description;
    private String color;
    private float price;
    private LocalDateTime updated_at;
    private LocalDateTime created_at;


}
