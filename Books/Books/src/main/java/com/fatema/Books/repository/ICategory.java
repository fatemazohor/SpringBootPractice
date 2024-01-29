package com.fatema.Books.repository;

import com.fatema.Books.model.Book;
import com.fatema.Books.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ICategory extends JpaRepository<Category,Integer> {

    Category findAllByCateName(String cateName);
}
