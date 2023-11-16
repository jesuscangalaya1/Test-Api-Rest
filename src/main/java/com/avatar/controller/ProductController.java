package com.avatar.controller;

import com.avatar.dto.ProductRequest;
import com.avatar.dto.response.PageableResponse;
import com.avatar.dto.response.ProductResponse;
import com.avatar.dto.response.RestResponse;
import com.avatar.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.File;
import java.util.List;

import static com.avatar.util.AppConstants.*;


@Validated
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "PRODUCTO", description = "Operaciones permitidas sobre la entidad Producto")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Obtener la información de todos los productos paginados")
    @GetMapping(value = "/pagination", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse<PageableResponse<ProductResponse>> pageableProducts(
            @RequestParam(value = "pageNo", defaultValue = NUMERO_DE_PAGINA_POR_DEFECTO, required = false) int numeroDePagina,
            @RequestParam(value = "pageSize", defaultValue = MEDIDA_DE_PAGINA_POR_DEFECTO, required = false) int medidaDePagina,
            @RequestParam(value = "sortBy", defaultValue = ORDENAR_POR_DEFECTO, required = false) String ordenarPor,
            @RequestParam(value = "sortDir", defaultValue = ORDENAR_DIRECCION_POR_DEFECTO, required = false) String sortDir) {

        return new RestResponse<>(SUCCESS,
                String.valueOf(HttpStatus.OK),
                "PRODUCT SUCCESSFULLY READED",
                productService.paginationProducts(numeroDePagina, medidaDePagina, ordenarPor, sortDir));
    }

    @Operation(summary = "Crear un nuevo producto")
    @ApiResponse(responseCode = "201", description = "Producto creado exitosamente")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse<ProductResponse> createProduct(@RequestBody @Valid ProductRequest productRequest) {

        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.CREATED),
                "PRODUCT SUCCESSFULLY CREATED",
                productService.createProduct(productRequest));
    }

    @Operation(summary = "Actualizar un producto existente por su ID")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse<ProductResponse> updateProduct(@Positive(message = "el ID solo acepta numeros positivos")
            @PathVariable  Long id , @RequestBody @Valid ProductRequest productRequest) {

        return new RestResponse<>("SUCCESS",
                String.valueOf(HttpStatus.OK),
                "PRODUCT SUCCESSFULLY UPDATED",
                productService.updateProduct(id, productRequest));
    }

    @Operation(summary = "Obtener información de un producto por su ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse<ProductResponse> getByIdProduct(@Positive(message = "el ID solo acepta numeros positivos")
            @PathVariable Long id) {

        return new RestResponse<>(SUCCESS,
                String.valueOf(HttpStatus.OK),
                MESSAGE_ID_PRODUCT + id + " SUCCESSFULLY READED",
                productService.getByIdProduct(id));
    }


    @Operation(summary = "Eliminar un producto por su ID")
    @DeleteMapping(value = "/{id}")
    public RestResponse<String> deleteProduct(@Positive(message = "el ID solo acepta numeros positivos")
            @PathVariable Long id) {

        productService.deleteProduct(id);
        return new RestResponse<>(SUCCESS,
                String.valueOf(HttpStatus.OK),
                MESSAGE_ID_PRODUCT + id + " SUCCESSFULLY DELETED",
                "null"); // Data null.
    }


    @Operation(summary = "Export en PDF o EXCEL")
    @GetMapping(value = "/export-PDF-EXCEL", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resource> exportsFlights(
            @RequestParam(value = "pageNo", defaultValue = NUMERO_DE_PAGINA_POR_DEFECTO, required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = MEDIDA_DE_PAGINA_POR_DEFECTO, required = false) int pageSize,
            @RequestParam(value = "format", defaultValue = FORMATO_EXCEL_ABREVIATURA) @NotBlank String format,
            @RequestParam(value = "ordenarPor", defaultValue = ORDENAR_POR_DEFECTO) String ordenarPor,
            @RequestParam(value = "sortDir", defaultValue = ORDENAR_DIRECCION_POR_DEFECTO) String sortDir)
            throws Exception {

        PageableResponse<ProductResponse> flightPage = productService.paginationProducts(pageNumber, pageSize, ordenarPor, sortDir);
        List<ProductResponse> flights = flightPage.getContent();
        File file = productService.exportProducts(flights, format);

        // Configurar las cabeceras de la respuesta HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", file.getName());

        // Crear la respuesta HTTP con el objeto File
        FileSystemResource fileResource = new FileSystemResource(file);
        return new ResponseEntity<>(fileResource, headers, HttpStatus.OK);
    }

}





