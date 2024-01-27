package com.fatema.Books.repository;

import com.fatema.Books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBook extends JpaRepository<Book,Integer> {
}
