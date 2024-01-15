package com.example.SpringBootP3.repository.sale;

import com.example.SpringBootP3.model.sale.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IStyle extends JpaRepository<Style,Integer> {
//    @Query("select s from Style s  where s.id=:id")
//    default Style findStyleById(@Param("id") Integer id);


}
