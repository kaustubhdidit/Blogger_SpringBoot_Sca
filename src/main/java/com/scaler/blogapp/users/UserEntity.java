package com.scaler.blogapp.users;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity(name="users")
@Data
@Getter
@Builder
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    @NonNull
    private String username;
    @Column(nullable = false)
    @NonNull
    private String email;
    @Column(nullable = true)
    @Nullable
    private String bio;
    @Column(nullable = true)
    @Nullable
    private String image;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || Hibernate.getClass(this)!= Hibernate.getClass(o)) return false;
        UserEntity that=(UserEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }

}
