package com.example.SpringBootP3.repository.sale;

import com.example.SpringBootP3.model.sale.StyleAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStyleAttachmentRepo extends JpaRepository<StyleAttachment,Integer> {
}
