package com.avatar.mapper;


import com.avatar.dto.ProductRequest;
import com.avatar.dto.response.ProductResponse;
import com.avatar.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponse toProductDTO(ProductEntity productEntity);

    @Mapping(target = "id", ignore = true) // Ignorar el mapeo del campo 'id'
    @Mapping(target = "deleted", ignore = true)
    ProductEntity toProductEntity(ProductRequest productRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    void updateProductFromDto(ProductRequest productRequest, @MappingTarget ProductEntity productEntity);

    List<ProductResponse> toListProductsDTO(List<ProductEntity> productEntityList);

}
