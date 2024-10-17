package com.scaler.blogapp.comments;

import com.scaler.blogapp.articles.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {
    @Autowired private final CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository){
        this.commentsRepository=commentsRepository;
    }

}
