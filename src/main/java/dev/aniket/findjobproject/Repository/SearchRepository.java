package dev.aniket.findjobproject.Repository;

import dev.aniket.findjobproject.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SearchRepository {
    List<Post> findByQueryText(String s);
}
