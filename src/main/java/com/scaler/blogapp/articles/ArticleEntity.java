package com.scaler.blogapp.articles;

import com.scaler.blogapp.users.UserEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity(name="articles")
@Data
@Getter
@Setter
@ToString
@Builder 
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    @Column(unique = true)
    private String slug;
    @Nullable
    private String subtitle;
    @NonNull
    private String body;

    @CreatedDate
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "authorId", nullable = false)
    private UserEntity author;

}
