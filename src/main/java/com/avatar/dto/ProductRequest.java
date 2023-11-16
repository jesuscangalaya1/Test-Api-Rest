package com.avatar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ProductRequest {

    @Schema(
            description = "Nombre del Producto",
            example = "Camiseta Nike"
    )
    @NotBlank(message = "El nombre no debe estar en blanco")
    @Size(max = 100, min = 5, message = "El nombre debe tener como máximo {max} caracteres y como mínimo {min} caracteres.")
    private String name;

    @Schema(
            description = "Descripción del Producto",
            example = "Camiseta de algodón con logo de Nike en la parte frontal."
    )
    @Size(min = 5, max = 200, message = "La descripción debe tener entre {min} y {max} caracteres.")
    private String description;

    @Schema(
            description = "Precio del Producto",
            example = "29.99"
    )
    @Positive(message = "El precio debe ser un valor positivo.")
    private double price;

    @Schema(
            description = "Stock del Producto",
            example = "10"
    )
    @Positive(message = "El stock debe ser un valor positivo")
    private int stock;

}
