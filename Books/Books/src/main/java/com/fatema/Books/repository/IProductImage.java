package com.fatema.Books.repository;

import com.fatema.Books.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductImage extends JpaRepository<ProductImage,Integer> {
}
