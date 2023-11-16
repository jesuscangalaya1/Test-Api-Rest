package com.avatar.service;


import com.avatar.dto.ProductRequest;
import com.avatar.dto.response.PageableResponse;
import com.avatar.dto.response.ProductResponse;

import java.io.File;
import java.util.List;

public interface ProductService {

    PageableResponse<ProductResponse> paginationProducts(int numeroDePagina, int medidaDePagina,
                                                         String ordenarPor, String sortDir);

    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse updateProduct(Long id, ProductRequest productRequest);

    ProductResponse getByIdProduct(Long id);

    void deleteProduct(Long id);

    File exportProducts(List<ProductResponse> flightResponses, String formato) throws Exception;


}
