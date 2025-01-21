package org.example.book.dao.repository;

import org.example.book.dao.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
