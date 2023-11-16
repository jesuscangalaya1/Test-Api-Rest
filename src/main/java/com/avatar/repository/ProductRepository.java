package com.avatar.repository;


import com.avatar.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Page<ProductEntity> findAllByDeletedFalse(Pageable pageable);


    Optional<ProductEntity> findByIdAndDeletedFalse(Long id);

    // Consulta para desactivar un producto por su ID
    @Modifying
    @Query("UPDATE ProductEntity p SET p.deleted = true WHERE p.id = :productId")
    void desactivarProduct(@Param("productId") Long productId);


}
