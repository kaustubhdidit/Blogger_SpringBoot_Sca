package com.scaler.blogapp.articles;

import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;


public interface ArticlesRepository extends JpaRepository<ArticleEntity,Long> {
    Object findBySlug(String slug);
}
